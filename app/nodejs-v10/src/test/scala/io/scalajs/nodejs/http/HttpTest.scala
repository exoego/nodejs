package io.scalajs.nodejs
package http

import scala.scalajs.js
import org.scalatest.funspec.AnyFunSpec

/** Http Tests
  */
class HttpTest extends AnyFunSpec {
  describe("Http") {
    it("should provide an HTTP server") {
      val server = Http.createServer((request: ClientRequest, response: ServerResponse) => {
        response.writeHead(statusCode = 200, headers = js.Dictionary("Content-Type" -> "text/plain"))
        response.write("Hello World")
        response.end()
      })
      assert(server !== null)

      // don't listen on a port
      //server.listen(58888)
      //setTimeout(() => server.close(), 100.millis)
    }

    it("should provide statusCode") {
      assert(Http.STATUS_CODES.`403` === "Forbidden")
      assert(Http.STATUS_CODES.`500` === "Internal Server Error")
    }
  }
}
