@file:OptIn(pbandk.PublicForGeneratedCode::class)

package io.wesl.prototest.api.foo.v1

@pbandk.Export
public data class GetFooResponse(
    val message: String = "",
    override val unknownFields: Map<Int, pbandk.UnknownField> = emptyMap()
) : pbandk.Message {
    override operator fun plus(other: pbandk.Message?): io.wesl.prototest.api.foo.v1.GetFooResponse = protoMergeImpl(other)
    override val descriptor: pbandk.MessageDescriptor<io.wesl.prototest.api.foo.v1.GetFooResponse> get() = Companion.descriptor
    override val protoSize: Int by lazy { super.protoSize }
    public companion object : pbandk.Message.Companion<io.wesl.prototest.api.foo.v1.GetFooResponse> {
        public val defaultInstance: io.wesl.prototest.api.foo.v1.GetFooResponse by lazy { io.wesl.prototest.api.foo.v1.GetFooResponse() }
        override fun decodeWith(u: pbandk.MessageDecoder): io.wesl.prototest.api.foo.v1.GetFooResponse = io.wesl.prototest.api.foo.v1.GetFooResponse.decodeWithImpl(u)

        override val descriptor: pbandk.MessageDescriptor<io.wesl.prototest.api.foo.v1.GetFooResponse> by lazy {
            val fieldsList = ArrayList<pbandk.FieldDescriptor<io.wesl.prototest.api.foo.v1.GetFooResponse, *>>(1)
            fieldsList.apply {
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "message",
                        number = 1,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(),
                        jsonName = "message",
                        value = io.wesl.prototest.api.foo.v1.GetFooResponse::message
                    )
                )
            }
            pbandk.MessageDescriptor(
                fullName = "foo.v1.GetFooResponse",
                messageClass = io.wesl.prototest.api.foo.v1.GetFooResponse::class,
                messageCompanion = this,
                fields = fieldsList
            )
        }
    }
}

@pbandk.Export
public data class SetBarRequest(
    val message: String = "",
    override val unknownFields: Map<Int, pbandk.UnknownField> = emptyMap()
) : pbandk.Message {
    override operator fun plus(other: pbandk.Message?): io.wesl.prototest.api.foo.v1.SetBarRequest = protoMergeImpl(other)
    override val descriptor: pbandk.MessageDescriptor<io.wesl.prototest.api.foo.v1.SetBarRequest> get() = Companion.descriptor
    override val protoSize: Int by lazy { super.protoSize }
    public companion object : pbandk.Message.Companion<io.wesl.prototest.api.foo.v1.SetBarRequest> {
        public val defaultInstance: io.wesl.prototest.api.foo.v1.SetBarRequest by lazy { io.wesl.prototest.api.foo.v1.SetBarRequest() }
        override fun decodeWith(u: pbandk.MessageDecoder): io.wesl.prototest.api.foo.v1.SetBarRequest = io.wesl.prototest.api.foo.v1.SetBarRequest.decodeWithImpl(u)

        override val descriptor: pbandk.MessageDescriptor<io.wesl.prototest.api.foo.v1.SetBarRequest> by lazy {
            val fieldsList = ArrayList<pbandk.FieldDescriptor<io.wesl.prototest.api.foo.v1.SetBarRequest, *>>(1)
            fieldsList.apply {
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "message",
                        number = 1,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(),
                        jsonName = "message",
                        value = io.wesl.prototest.api.foo.v1.SetBarRequest::message
                    )
                )
            }
            pbandk.MessageDescriptor(
                fullName = "foo.v1.SetBarRequest",
                messageClass = io.wesl.prototest.api.foo.v1.SetBarRequest::class,
                messageCompanion = this,
                fields = fieldsList
            )
        }
    }
}

@pbandk.Export
@pbandk.JsName("orDefaultForGetFooResponse")
public fun GetFooResponse?.orDefault(): io.wesl.prototest.api.foo.v1.GetFooResponse = this ?: GetFooResponse.defaultInstance

private fun GetFooResponse.protoMergeImpl(plus: pbandk.Message?): GetFooResponse = (plus as? GetFooResponse)?.let {
    it.copy(
        unknownFields = unknownFields + plus.unknownFields
    )
} ?: this

@Suppress("UNCHECKED_CAST")
private fun GetFooResponse.Companion.decodeWithImpl(u: pbandk.MessageDecoder): GetFooResponse {
    var message = ""

    val unknownFields = u.readMessage(this) { _fieldNumber, _fieldValue ->
        when (_fieldNumber) {
            1 -> message = _fieldValue as String
        }
    }

    return GetFooResponse(message, unknownFields)
}

@pbandk.Export
@pbandk.JsName("orDefaultForSetBarRequest")
public fun SetBarRequest?.orDefault(): io.wesl.prototest.api.foo.v1.SetBarRequest = this ?: SetBarRequest.defaultInstance

private fun SetBarRequest.protoMergeImpl(plus: pbandk.Message?): SetBarRequest = (plus as? SetBarRequest)?.let {
    it.copy(
        unknownFields = unknownFields + plus.unknownFields
    )
} ?: this

@Suppress("UNCHECKED_CAST")
private fun SetBarRequest.Companion.decodeWithImpl(u: pbandk.MessageDecoder): SetBarRequest {
    var message = ""

    val unknownFields = u.readMessage(this) { _fieldNumber, _fieldValue ->
        when (_fieldNumber) {
            1 -> message = _fieldValue as String
        }
    }

    return SetBarRequest(message, unknownFields)
}
