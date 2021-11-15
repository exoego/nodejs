package io.scalajs.nodejs
package url

import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.js

/** URLObject Tests
  */
class URLObjectTest extends AnyFunSpec {
  describe("URLObject") {
    val originalUrl = "https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node"
    val urlObject   = new URL(originalUrl)

    it("should break down URLs into components") {
      assert(
        js.JSON.stringify(
          urlObject
        ) === "\"https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node\""
      )
      //  """{"protocol":"https:","slashes":true,"auth":null,"host":"www.google.com","port":null,"hostname":"www.google.com","hash":"#q=node","search":"?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","query":"sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","pathname":"/webhp","path":"/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","href":"https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node"}"""
    }

    it("should properly extract the search query") {
      assert(urlObject.search === "?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8")
    }

    it("should reconstituted the URL to match the original") {
      assert(URL.format(urlObject) === originalUrl)
    }
  }
}
