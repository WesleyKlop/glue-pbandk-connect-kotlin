package io.wesl.prototest

import build.buf.connect.Codec
import build.buf.connect.codecNameProto
import com.google.protobuf.Empty
import okio.Buffer
import okio.BufferedSource
import pbandk.*
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

class PbandkProtoAdapter<E : Message>(clazz: KClass<E>) : Codec<E> {
    @OptIn(ExperimentalProtoReflection::class)
    val decoder by lazy { clazz.createInstance().descriptor.messageCompanion }

    override fun encodingName() = codecNameProto

    @Suppress("UNCHECKED_CAST")
    override fun deserialize(source: BufferedSource): E {
        return decoder.decodeFromByteArray(source.readByteArray()) as E
    }

    override fun serialize(message: E) = Buffer().write(message.encodeToByteArray())
}
