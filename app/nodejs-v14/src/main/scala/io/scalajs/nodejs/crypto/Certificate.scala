package io.scalajs.nodejs.crypto

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("crypto", "Certificate")
object Certificate extends js.Object {
  def exportChallenge(spkac: String): Buffer     = js.native
  def exportChallenge(spkac: BufferLike): Buffer = js.native

  def exportPublicKey(spkac: String, encoding: String): Buffer = js.native
  def exportPublicKey(spkac: String): Buffer                   = js.native
  def exportPublicKey(spkac: BufferLike): Buffer               = js.native

  def verifySpkac(spkac: BufferLike): Boolean = js.native
}
