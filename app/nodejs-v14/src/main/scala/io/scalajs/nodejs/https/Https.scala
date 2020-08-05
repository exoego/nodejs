package io.scalajs.nodejs.https

import io.scalajs.nodejs.http.{ClientRequest, RequestOptions, ServerResponse}
import io.scalajs.nodejs.url.URL

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * HTTPS is the HTTP protocol over TLS/SSL. In Node.js this is implemented as a separate module.
  * @see https://nodejs.org/api/https.html
  */
@js.native
trait Https extends js.Object {
  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Global instance of https.Agent for all HTTPS client requests.
    */
  def globalAgent: Agent = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns a new HTTPS web server object. The options is similar to tls.createServer().
    * The requestListener is a function which is automatically added to the 'request' event.
    * @example https.createServer(options[, requestListener])
    */
  def createServer(options: ServerOptions, requestListener: js.Function): Server = js.native
  def createServer(requestListener: js.Function): Server                         = js.native
  def createServer(options: ServerOptions): Server                               = js.native
  def createServer(): Server                                                     = js.native

  def get(url: String, options: RequestOptions, callback: js.Function1[ServerResponse, Any]): ClientRequest = js.native
  def get(url: String, callback: js.Function1[ServerResponse, Any]): ClientRequest                          = js.native
  def get(url: URL, options: RequestOptions, callback: js.Function1[ServerResponse, Any]): ClientRequest    = js.native
  def get(url: URL, callback: js.Function1[ServerResponse, Any]): ClientRequest                             = js.native
  def get(options: RequestOptions, callback: js.Function): ClientRequest                                    = js.native

  def request(url: String, options: RequestOptions, callback: js.Function1[ServerResponse, Any]): Unit = js.native
  def request(url: String, options: RequestOptions): Unit                                              = js.native
  def request(url: String, callback: js.Function1[ServerResponse, Any]): Unit                          = js.native
  def request(url: String): Unit                                                                       = js.native
  def request(url: URL, options: RequestOptions, callback: js.Function1[ServerResponse, Any]): Unit    = js.native
  def request(url: URL, options: RequestOptions): Unit                                                 = js.native
  def request(url: URL, callback: js.Function1[ServerResponse, Any]): Unit                             = js.native
  def request(url: URL): Unit                                                                          = js.native
  def request(options: RequestOptions): Unit                                                           = js.native
  def request(options: RequestOptions, callback: js.Function1[ServerResponse, Any]): Unit              = js.native
}

/**
  * Https Singleton
  */
@js.native
@JSImport("https", JSImport.Namespace)
object Https extends Https
