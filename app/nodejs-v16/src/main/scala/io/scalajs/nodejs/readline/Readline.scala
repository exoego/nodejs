package io.scalajs.nodejs.readline

import com.thoughtworks.enableIf
import io.scalajs.nodejs.stream.{IReadable, IWritable}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/** Readline allows of a stream (such as process.stdin) on a line-by-line basis. To use this module, do
  * require('readline'). Note that once you've invoked this module, your Node.js program will not terminate until you've
  * closed the interface.
  * @see
  *   https://nodejs.org/api/readline.html
  */
@js.native
trait Readline extends js.Object {

  /** Clears current line of given TTY stream in a specified direction. <tt>dir</tt> should have one of following
    * values: <ul> <li>-1 - to the left from cursor</li> <li>0 - the entire line</li> <li>1 - to the right from
    * cursor</li> </ul>
    * @example
    *   readline.clearLine(stream, dir)
    */
  def clearLine(stream: IWritable, dir: Int, callback: js.Function): Boolean = js.native
  def clearLine(stream: IWritable, dir: Int): Boolean                        = js.native

  /** Clears the screen from the current position of the cursor down.
    * @example
    *   readline.clearScreenDown(stream)
    */
  def clearScreenDown(stream: IWritable, callback: js.Function): Boolean = js.native
  def clearScreenDown(stream: IWritable): Boolean                        = js.native

  /** Creates a readline Interface instance.
    * @example
    *   readline.createInterface(options)
    */
  def createInterface(options: ReadlineOptions): Interface = js.native

  /** Move cursor to the specified position in a given TTY stream.
    * @example
    *   readline.cursorTo(stream, x, y)
    */
  def cursorTo(stream: IWritable, x: Int, y: Int, callback: js.Function): Unit = js.native
  def cursorTo(stream: IWritable, x: Int, y: Int): Unit                        = js.native
  def cursorTo(stream: IWritable, x: Int, callback: js.Function): Unit         = js.native
  def cursorTo(stream: IWritable, x: Int): Unit                                = js.native

  def emitKeypressEvents(stream: IReadable, interface: Interface): Unit = js.native
  def emitKeypressEvents(stream: IReadable): Unit                       = js.native

  /** Move cursor relative to it's current position in a given TTY stream.
    * @example
    *   readline.moveCursor(stream, dx, dy)
    */
  def moveCursor(stream: IWritable, dx: Int, dy: Int, callback: js.Function): Unit = js.native
  def moveCursor(stream: IWritable, dx: Int, dy: Int): Unit                        = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  def getPrompt(): String = js.native
}

/** Readline Singleton
  */
@js.native
@JSImport("readline", JSImport.Namespace)
object Readline extends Readline
