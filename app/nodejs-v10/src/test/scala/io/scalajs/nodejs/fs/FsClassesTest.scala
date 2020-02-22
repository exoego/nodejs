package io.scalajs.nodejs
package fs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.url.URL
import org.scalatest.funspec.AnyFunSpec

class FsClassesTest extends AnyFunSpec {
  val dirname = process.Process.cwd()

  describe("ReadStream") {
    it("supports constructor(") {
      assert(new ReadStream("package.json") !== null)
      assert(new ReadStream(Buffer.from("package.json")) !== null)
      assert(new ReadStream(new URL(s"file:///${dirname}/package.json")) !== null)
    }
  }

  describe("WriteStream") {
    it("supports constructor") {
      assert(new WriteStream("package.json") !== null)
      assert(new WriteStream(Buffer.from("package.json")) !== null)
      assert(new WriteStream(new URL(s"file:///${dirname}/package.json")) !== null)
    }
  }
}
