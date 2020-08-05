package io.scalajs.nodejs.http2

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.url.URL

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.Uint8Array

@js.native
trait Http2 extends js.Object {
  def createServer(options: Http2ServerOptions, onRequestHandler: ServerCallback): Http2Server = js.native
  def createServer(options: Http2ServerOptions): Http2Server                                   = js.native

  def createSecureServer(options: Http2SecureServerOptions, onRequestHandler: ServerCallback): Http2SecureServer =
    js.native
  def createSecureServer(options: Http2SecureServerOptions): Http2SecureServer = js.native

  def connect(authority: String, options: Http2ConnectOptions, listener: js.Function): ClientHttp2Session = js.native
  def connect(authority: URL, options: Http2ConnectOptions, listener: js.Function): ClientHttp2Session    = js.native

  def constants: Http2Constants = js.native

  def getDefaultSettings(): Http2Settings                    = js.native
  def getPackedSettings(settings: Http2Settings): Buffer     = js.native
  def getUnpackedSettings(buffer: Uint8Array): Http2Settings = js.native
}

@js.native
@JSImport("http2", JSImport.Namespace)
object Http2 extends Http2
