package io.scalajs.nodejs.http

import io.scalajs.nodejs.net.Socket
import io.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/** An IncomingMessage object is created by http.Server or http.ClientRequest and passed as the first argument to the
  * 'request' and 'response' event respectively. It may be used to access response status, headers and data. It
  * implements the Readable Stream interface, as well as the following additional events, methods, and properties.
  * @see
  *   [[https://nodejs.org/api/http.html#http_class_http_incomingmessage]]
  */
@js.native
@JSImport("http", "IncomingMessage")
class IncomingMessage extends stream.Readable {
  def aborted: Boolean = js.native

  def complete: Boolean = js.native

  def destroy(error: io.scalajs.nodejs.Error): Unit = js.native
  def destroy(): Unit                               = js.native

  /** The request/response headers object. Key-value pairs of header names and values. Header names are lower-cased.
    * @example
    *   message.headers
    */
  def headers: js.Dictionary[String] = js.native

  /** In case of server request, the HTTP version sent by the client. In the case of client response, the HTTP version
    * of the connected-to server. Probably either '1.1' or '1.0'.
    * @example
    *   message.httpVersion
    */
  def httpVersion: String = js.native

  /** Only valid for request obtained from http.Server. The request method as a string. Read only. Example: 'GET',
    * 'DELETE'.
    * @example
    *   message.method
    */
  def method: js.UndefOr[String] = js.native

  /** The raw request/response headers list exactly as they were received. <b>Note</b> that the keys and values are in
    * the same list. It is not a list of tuples. So, the even-numbered offsets are key values, and the odd-numbered
    * offsets are the associated values. Header names are not lowercased, and duplicates are not merged.
    * @example
    *   message.rawHeaders
    */
  def rawHeaders: js.Array[String] = js.native

  /** The raw request/response trailer keys and values exactly as they were received. Only populated at the 'end' event.
    * @example
    *   message.rawTrailers
    */
  def rawTrailers: js.Array[String] = js.native

  def setTimeout(msecs: Double, callback: js.Function): this.type = js.native

  /** Only valid for response obtained from http.ClientRequest. The 3-digit HTTP response status code (e.g. 404).
    * @example
    *   message.statusCode
    */
  def statusCode: js.UndefOr[Int] = js.native

  /** Only valid for response obtained from http.ClientRequest. The HTTP response status message (reason phrase) (e.g.
    * OK or Internal Server Error).
    * @example
    *   message.statusMessage
    */
  def statusMessage: js.UndefOr[String] = js.native

  /** The net.Socket object associated with the connection. With HTTPS support, use request.socket.getPeerCertificate()
    * to obtain the client's authentication details.
    * @example
    *   message.socket
    */
  def socket: Socket = js.native

  /** The request/response trailers object. Only populated at the 'end' event.
    * @example
    *   message.trailers
    */
  def trailers: js.Dictionary[js.Any] = js.native

  /** Only valid for request obtained from http.Server. Request URL string. This contains only the URL that is present
    * in the actual HTTP request.
    * @example
    *   message.url
    */
  def url: js.UndefOr[String] = js.native
}
