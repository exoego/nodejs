package io.scalajs.nodejs.http2

import com.thoughtworks.enableIf
import io.scalajs.nodejs.{net, tls, stream}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("http2", "Http2ServerRequest")
class Http2ServerRequest extends stream.Readable with Http2TimeoutOps {
  def authority: String = js.native

  def complete: Boolean = js.native

  @deprecated("Use socket", "Node.js v13.0.0")
  def connection: net.Socket | tls.TLSSocket = js.native

  def destroy(error: io.scalajs.nodejs.Error): Unit = js.native
  def destroy(): Unit                               = js.native

  def headers: Http2Headers = js.native

  def httpVersion: String = js.native

  def method: String = js.native

  def rawHeaders: js.Array[String] = js.native

  def rawTrailers: js.Array[String] = js.native

  def scheme: js.Array[String] = js.native

  def socket: net.Socket | tls.TLSSocket = js.native

  def stream: Http2Stream = js.native

  def trailers: js.Object = js.native

  def url: String = js.native
}
