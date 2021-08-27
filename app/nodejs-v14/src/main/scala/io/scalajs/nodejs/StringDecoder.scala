package io.scalajs.nodejs

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.{DataView, TypedArray}

/** To use this module, do require('string_decoder'). StringDecoder decodes a buffer to a string. It is a simple
  * interface to Buffer.toString() but provides additional support for utf8.
  */
@js.native
@JSImport("string_decoder", "StringDecoder")
class StringDecoder() extends IEventEmitter {
  def this(encoding: String) = this()

  /** Returns any trailing bytes that were left in the buffer.
    * @example
    *   decoder.end()
    */
  def end(buffer: TypedArray[_, _]): String = js.native
  def end(buffer: DataView): String         = js.native
  def end(): String                         = js.native

  /** Returns a decoded string.
    * @example
    *   decoder.write(buffer)
    */
  def write(buffer: TypedArray[_, _]): String = js.native
  def write(buffer: DataView): String         = js.native
}
