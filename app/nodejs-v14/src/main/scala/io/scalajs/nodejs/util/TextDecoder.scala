package io.scalajs.nodejs.util

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.{ArrayBuffer, ArrayBufferView}

@js.native
@JSImport("util", "TextDecoder")
class TextDecoder() extends js.Object {
  def this(encoding: String) = this()

  val encoding: String   = js.native
  val fatal: Boolean     = js.native
  val ignoreBOM: Boolean = js.native

  def decode(buffer: ArrayBuffer, options: TextDecodeOptions): String     = js.native
  def decode(buffer: ArrayBufferView, options: TextDecodeOptions): String = js.native
  def decode(buffer: ArrayBuffer): String                                 = js.native
  def decode(buffer: ArrayBufferView): String                             = js.native
}

@Factory
trait TextDecodeOptions extends js.Object {
  var stream: js.UndefOr[Boolean]
}
