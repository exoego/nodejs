package io.scalajs.nodejs

import com.thoughtworks.enableIf
import io.scalajs.nodejs.http.{RequestOptions, ServerResponse}
import io.scalajs.util.PromiseHelper._
import io.scalajs.nodejs.url.URL

import scala.concurrent.Future

/**
  * https package object
  */
package object https {

  /**
    * Https Extensions
    */
  implicit final class HttpExtensions(private val https: Https) extends AnyVal {

    /**
      * Like http.get() but for HTTPS.
      */
    @inline
    def getFuture(options: RequestOptions): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.get(options, _))
    }

    /**
      * Like http.get() but for HTTPS.
      */
    @inline
    def getFuture(url: String): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.get(url, _))
    }

    /**
      * Makes a request to a secure web server.
      */
    @inline
    def requestFuture(options: RequestOptions): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.request(options, _))
    }

    @inline
    def requestFuture(url: String): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.request(url, _))
    }
    @inline
    def requestFuture(url: URL): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.request(url, _))
    }
    @inline
    def requestFuture(url: String, options: RequestOptions): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.request(url, options, _))
    }
    @inline
    def requestFuture(url: URL, options: RequestOptions): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.request(url, options, _))
    }
  }

  implicit final class AgentExtensions[T <: Agent](private val instance: T) extends AnyVal {
    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline def onKeylog(handler: (io.scalajs.nodejs.buffer.Buffer, tls.TLSSocket) => Any): T =
      instance.on("keylog", handler)
  }
}
