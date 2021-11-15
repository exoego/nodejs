package io.scalajs.nodejs.timers

import com.thoughtworks.enableIf

import scala.scalajs.js

/** Immediate Handle
  */
@js.native
trait Immediate extends js.Object {
  def _onImmediate: js.Function = js.native

  def hasRef(): Boolean = js.native

  def ref(): Immediate = js.native

  def unref(): Immediate = js.native
}
