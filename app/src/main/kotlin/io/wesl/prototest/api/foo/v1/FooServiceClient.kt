// Code generated by connect-kotlin. DO NOT EDIT.
//
// Source: foo/v1/FooService.proto
//
package io.wesl.prototest.api.foo.v1

import build.buf.connect.Headers
import build.buf.connect.MethodSpec
import build.buf.connect.ProtocolClientInterface
import build.buf.connect.ResponseMessage
import com.google.protobuf.Empty

public class FooServiceClient(
  private val client: ProtocolClientInterface,
) : FooServiceClientInterface {
  public override suspend fun getFoo(request: Empty, headers: Headers):
      ResponseMessage<GetFooResponse> = client.unary(
    request,
    headers,
    MethodSpec(
    "foo.v1.FooService/GetFoo",
      com.google.protobuf.Empty::class,
      io.wesl.prototest.api.foo.v1.GetFooResponse::class
    ),
  )


  public override suspend fun setBar(request: SetBarRequest, headers: Headers):
      ResponseMessage<Empty> = client.unary(
    request,
    headers,
    MethodSpec(
    "foo.v1.FooService/SetBar",
      io.wesl.prototest.api.foo.v1.SetBarRequest::class,
      com.google.protobuf.Empty::class
    ),
  )

}
