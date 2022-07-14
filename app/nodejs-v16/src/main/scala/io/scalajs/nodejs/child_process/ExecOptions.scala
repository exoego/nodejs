package io.scalajs.nodejs
package child_process

import scala.scalajs.js
import scala.scalajs.js.|

/** Spawns a shell then executes the command within that shell, buffering any generated output.
  *
  * Note: Never pass unsanitized user input to this function. Any input containing shell meta-characters may be used to
  * trigger arbitrary command execution.
  */
trait ExecOptions extends js.Object {

  /** Current working directory of the child process
    */
  var cwd: js.UndefOr[String] = js.undefined

  /** Environment key-value pairs
    */
  var env: js.UndefOr[js.Object] = js.undefined

  /** (Default: 'utf8')
    */
  var encoding: js.UndefOr[String] = js.undefined

  /** Shell to execute the command with (Default: '/bin/sh' on UNIX, 'cmd.exe' on Windows, The shell should understand
    * the -c switch on UNIX or /d /s /c on Windows. On Windows, command line parsing should be compatible with cmd.exe.)
    */
  var shell: js.UndefOr[Boolean | String] = js.undefined

  /** (Default: 0)
    */
  var timeout: js.UndefOr[Int] = js.undefined

  /** largest amount of data (in bytes) allowed on stdout or stderr - if exceeded child process is killed (Default:
    * 200*1024)
    */
  var maxBuffer: js.UndefOr[Int] = js.undefined

  /** (Default: 'SIGTERM')
    */
  var killSignal: js.UndefOr[KillSignal] = js.undefined

  /** Sets the user identity of the process. (See setuid(2).)
    */
  var uid: js.UndefOr[UID] = js.undefined

  /** Sets the group identity of the process. (See setgid(2).)
    */
  var gid: js.UndefOr[GID] = js.undefined

  /** Hide the subprocess console window that would normally be created on Windows systems. Default: `false`.
    */
  var windowsHide: js.UndefOr[Boolean] = js.undefined

  /** No quoting or escaping of arguments is done on Windows. Ignored on Unix. This is set to true automatically when
    * shell is specified and is CMD. Default: false.
    */
  var windowsVerbatimArguments: js.UndefOr[Boolean] = js.undefined
}
object ExecOptions {
  def apply(
      cwd: js.UndefOr[String] = js.undefined,
      env: js.UndefOr[js.Object] = js.undefined,
      encoding: js.UndefOr[String] = js.undefined,
      shell: js.UndefOr[Boolean | String] = js.undefined,
      timeout: js.UndefOr[Int] = js.undefined,
      maxBuffer: js.UndefOr[Int] = js.undefined,
      killSignal: js.UndefOr[KillSignal] = js.undefined,
      uid: js.UndefOr[UID] = js.undefined,
      gid: js.UndefOr[GID] = js.undefined,
      windowsHide: js.UndefOr[Boolean] = js.undefined,
      windowsVerbatimArguments: js.UndefOr[Boolean] = js.undefined
  ): ExecOptions = {
    val _obj$ = js.Dynamic.literal(
    )
    cwd.foreach(_v => _obj$.updateDynamic("cwd")(_v.asInstanceOf[js.Any]))
    env.foreach(_v => _obj$.updateDynamic("env")(_v.asInstanceOf[js.Any]))
    encoding.foreach(_v => _obj$.updateDynamic("encoding")(_v.asInstanceOf[js.Any]))
    shell.foreach(_v => _obj$.updateDynamic("shell")(_v.asInstanceOf[js.Any]))
    timeout.foreach(_v => _obj$.updateDynamic("timeout")(_v.asInstanceOf[js.Any]))
    maxBuffer.foreach(_v => _obj$.updateDynamic("maxBuffer")(_v.asInstanceOf[js.Any]))
    killSignal.foreach(_v => _obj$.updateDynamic("killSignal")(_v.asInstanceOf[js.Any]))
    uid.foreach(_v => _obj$.updateDynamic("uid")(_v.asInstanceOf[js.Any]))
    gid.foreach(_v => _obj$.updateDynamic("gid")(_v.asInstanceOf[js.Any]))
    windowsHide.foreach(_v => _obj$.updateDynamic("windowsHide")(_v.asInstanceOf[js.Any]))
    windowsVerbatimArguments.foreach(_v => _obj$.updateDynamic("windowsVerbatimArguments")(_v.asInstanceOf[js.Any]))
    _obj$.asInstanceOf[ExecOptions]
  }
}
