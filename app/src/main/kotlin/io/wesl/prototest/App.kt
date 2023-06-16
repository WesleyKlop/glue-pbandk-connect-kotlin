package io.wesl.prototest

import build.buf.connect.ProtocolClientConfig
import build.buf.connect.impl.ProtocolClient
import build.buf.connect.okhttp.ConnectOkHttpClient
import build.buf.connect.protocols.NetworkProtocol
import com.google.protobuf.Empty
import io.wesl.prototest.api.foo.v1.FooServiceClient
import io.wesl.prototest.api.foo.v1.SetBarRequest
import okhttp3.OkHttpClient

suspend fun main() {
    val transport = ProtocolClient(
        httpClient = ConnectOkHttpClient(OkHttpClient()),
        ProtocolClientConfig(
            host = System.getenv("API_HOST"),
            serializationStrategy = PbandkStrategy(),
            networkProtocol = NetworkProtocol.CONNECT
        )
    )
    val client = FooServiceClient(transport)

    val fooResp = client.getFoo(Empty.getDefaultInstance())

    fooResp.success {
        println("Got success response from getFoo! Class name: ${it.message.javaClass.name}")
        println(it.message.message)
    }
    fooResp.failure {
        println("Got failure response from getFoo!")
        println(it.error)
    }

    val barResp = client.setBar(SetBarRequest(message = "bar"))
    barResp.success {
        println("Got success response from setBar! Class name: ${it.message.javaClass.name}")
    }
    barResp.failure {
        println("Got failure response from setBar!")
        println(it.error)
    }

}

