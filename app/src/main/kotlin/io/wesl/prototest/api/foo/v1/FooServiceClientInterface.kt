// Code generated by connect-kotlin. DO NOT EDIT.
//
// Source: foo/v1/FooService.proto
//
package io.wesl.prototest.api.foo.v1

import build.buf.connect.Headers
import build.buf.connect.ResponseMessage
import com.google.protobuf.Empty

public interface FooServiceClientInterface {
  public suspend fun getFoo(request: Empty, headers: Headers = emptyMap()):
      ResponseMessage<GetFooResponse>

  public suspend fun setBar(request: SetBarRequest, headers: Headers = emptyMap()):
      ResponseMessage<Empty>
}
