package io.scalajs.nodejs.repl

import com.thoughtworks.enableIf
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.readline.Interface
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * REPL Server
  */
@js.native
trait REPLServer extends IEventEmitter with Interface {

  /**
    * The REPL's context
    */
  val context: REPLContext = js.native

  def clearBufferedCommand(): Unit = js.native

  /**
    * The replServer.defineCommand() method is used to add new .-prefixed commands to the REPL instance.
    * Such commands are invoked by typing a period (.) followed by the keyword. The cmd is either a Function
    * or an object with the following properties:
    * <ul>
    * <li>help (string) Help text to be displayed when .help is entered (Optional).</li>
    * <li>action (Function) The function to execute, optionally accepting a single string argument.</li>
    * </ul>
    * @param keyword The command keyword (without a leading . character).
    * @param cmd     The function to invoke when the command is processed.
    */
  def defineCommand(keyword: String, cmd: DefinedCommand | js.Function1[String, Any]): Unit = js.native

  /**
    * The replServer.displayPrompt() method readies the REPL instance for input from the user, printing the
    * configured prompt to a new line in the output and resuming the input to accept new input.
    *
    * When multi-line input is being entered, an ellipsis is printed rather than the 'prompt'.
    * *
    * When preserveCursor is true, the cursor placement will not be reset to 0.
    *
    * The replServer.displayPrompt method is primarily intended to be called from within the action function
    * for commands registered using the replServer.defineCommand() method.
    * @param preserveCursor indicates whether to preserver the cursor (position?)
    */
  def displayPrompt(preserveCursor: Boolean): Unit = js.native

  /**
    * Like readline.prompt except also adding indents with ellipses when inside blocks. The preserveCursor argument
    * is passed to readline.prompt. This is used primarily with defineCommand. It's also used internally to render
    * each prompt line.
    * @example replServer.displayPrompt([preserveCursor])
    * @see [[prompt()]]
    */
  def displayPrompt(): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def setupHistory(historyPath: String, callback: js.Function2[io.scalajs.nodejs.Error, REPLServer, Any]): Unit =
    js.native
}

@Factory
trait DefinedCommand extends js.Object {
  var action: js.Function1[String, Any]
  var help: js.UndefOr[String] = js.undefined
}
