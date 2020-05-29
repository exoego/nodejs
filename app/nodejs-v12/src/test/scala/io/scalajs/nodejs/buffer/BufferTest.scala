package io.scalajs.nodejs.buffer

import scala.scalajs.js
import org.scalatest.funspec.AnyFunSpec

/**
  * Buffer Tests
  */
class BufferTest extends AnyFunSpec {
  it("should support writeBigInt64BE, writeBigInt64LE, writeBigInt64BE and writeBigInt64BE") {
    val buf = Buffer.allocUnsafe(8)
    val v   = js.BigInt("0x0102030405060708")
    buf.writeBigInt64BE(v, 0);
    assert(Buffer.compare(buf, Buffer.from(js.Array(1, 2, 3, 4, 5, 6, 7, 8))) === 0)
  }
}
