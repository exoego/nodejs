package io.scalajs.nodejs.readline

import com.thoughtworks.enableIf
import io.scalajs.nodejs.events.IEventEmitter
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

/** Readline Interface
  * @see https://nodejs.org/api/readline.html#readline_class_interface
  */
@js.native
trait Interface extends IEventEmitter {

  /** Closes the Interface instance, relinquishing control on the input and output streams.
    * The 'close' event will also be emitted.
    * @example rl.close()
    */
  def close(): Unit = js.native

  /** Pauses the readline input stream, allowing it to be resumed later if needed.
    * <b>Note</b>: that this doesn't immediately pause the stream of events. Several events may be emitted
    * after calling pause, including line.
    * @example rl.pause()
    */
  def pause(): Unit = js.native

  /** Readies readline for input from the user, putting the current setPrompt options on a new line, giving the user
    * a new spot to write. Set preserveCursor to true to prevent the cursor placement being reset to 0.
    * This will also resume the input stream used with createInterface if it has been paused.
    * If output is set to null or undefined when calling createInterface, the prompt is not written.
    * @example rl.prompt([preserveCursor])
    */
  def prompt(preserveCursor: Boolean): Unit = js.native

  /** Readies readline for input from the user, putting the current setPrompt options on a new line, giving the user
    * a new spot to write. Set preserveCursor to true to prevent the cursor placement being reset to 0.
    * This will also resume the input stream used with createInterface if it has been paused.
    * If output is set to null or undefined when calling createInterface, the prompt is not written.
    * @example rl.prompt([preserveCursor])
    */
  def prompt(): Unit = js.native

  /** Prepends the prompt with query and invokes callback with the user's response. Displays the query to the user,
    * and then invokes callback with the user's response after it has been typed.
    * This will also resume the input stream used with createInterface if it has been paused.
    * If output is set to null or undefined when calling createInterface, nothing is displayed.
    * @example rl.question(query, callback)
    */
  def question(query: String, callback: js.Function1[String, Any]): Unit = js.native

  /** Resumes the readline input stream.
    * @example rl.resume()
    */
  def resume(): Unit = js.native

  /** Sets the prompt, for example when you run node on the command line, you see > , which is Node.js's prompt.
    * @example rl.setPrompt(prompt)
    */
  def setPrompt(prompt: String): Unit = js.native

  /** Writes data to output stream, unless output is set to null or undefined when calling createInterface.
    * key is an object literal to represent a key sequence; available if the terminal is a TTY.
    * This will also resume the input stream if it has been paused.
    * @example rl.write(data[, key])
    */
  def write(data: String, key: Key): Unit = js.native

  /** Writes data to output stream, unless output is set to null or undefined when calling createInterface.
    * key is an object literal to represent a key sequence; available if the terminal is a TTY.
    * This will also resume the input stream if it has been paused.
    * @example rl.write(data[, key])
    */
  def write(data: String): Unit = js.native

  // TODO: [Symbol.asyncIterator]()

  def line: js.UndefOr[String] = js.native

  def cursor: js.UndefOr[Int] = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def getCursorPos(): CursorPos = js.native
}

@Factory
trait Key extends js.Object {
  var ctrl: js.UndefOr[Boolean]  = js.undefined
  var meta: js.UndefOr[Boolean]  = js.undefined
  var shift: js.UndefOr[Boolean] = js.undefined
  var name: js.UndefOr[String]   = js.undefined
}

@Factory
trait CursorPos extends js.Object {
  var rows: Int
  var cols: Int
}
