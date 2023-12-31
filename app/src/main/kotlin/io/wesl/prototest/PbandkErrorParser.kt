package io.wesl.prototest

import build.buf.connect.AnyError
import build.buf.connect.ConnectErrorDetail
import build.buf.connect.ErrorDetailParser
import build.buf.google.rpc.Status
import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.encodeUtf8
import pbandk.ByteArr
import pbandk.Message
import pbandk.unpack
import kotlin.reflect.KClass

private const val TYPE_URL_PREFIX = "type.googleapis.com/"

object PbandkErrorParser : ErrorDetailParser {

    @Suppress("UNCHECKED_CAST")
    override fun <E : Any> unpack(any: AnyError, clazz: KClass<E>): E? {
        val value = any.value.utf8().decodeBase64() ?: any.value
        val anyProto = pbandk.wkt.Any(
            typeUrl = if (any.typeUrl.contains('/')) any.typeUrl else "$TYPE_URL_PREFIX${any.typeUrl}",
            value = ByteArr(value.toByteArray())
        )

        val kClass = clazz as Message.Companion<Message>
        val unpacked = anyProto.unpack(kClass)
        if (unpacked.javaClass.isAssignableFrom(clazz.java)) {
            return unpacked as E?
        }
        return null;
    }

    override fun parseDetails(bytes: ByteArray): List<ConnectErrorDetail> {
        val status = Status.parseFrom(bytes)
        return status.detailsList.map { msg ->
            val utf8String = msg.value.toStringUtf8()
            ConnectErrorDetail(
                msg.typeUrl,
                // Try to decode via base64 and if that fails, use the original value.
                // Connect unary ends up encoding the payload as base64. GRPC and GRPC-Web
                // both do not encode this payload as base64 so decodeBase64() returns null.
                utf8String.decodeBase64() ?: utf8String.encodeUtf8()
            )
        }
    }

}
