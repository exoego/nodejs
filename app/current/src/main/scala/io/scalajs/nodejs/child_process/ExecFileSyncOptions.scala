package io.scalajs.nodejs.child_process

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Spawns a shell then executes the command within that shell, buffering any generated output.
  *
  * Note: Never pass unsanitized user input to this function. Any input containing shell meta-characters
  * may be used to trigger arbitrary command execution.
  *
  * @param cwd        Current working directory of the child process
  * @param input      The value which will be passed as stdin to the spawned process.
  *                   Supplying this value will override stdio[0].
  * @param stdio      Child's stdio configuration. stderr by default will be output to the parent process' stderr unless stdio is specified.
  *                   Default: 'pipe'.
  * @param env        Environment key-value pairs
  * @param encoding   (Default: 'utf8')
  * @param shell      Shell to execute the command with (Default: '/bin/sh' on UNIX, 'cmd.exe' on Windows,
  *                   The shell should understand the -c switch on UNIX or /d /s /c on Windows. On Windows, command line
  *                   parsing should be compatible with cmd.exe.)
  * @param timeout    (Default: 0)
  * @param maxBuffer  largest amount of data (in bytes) allowed on stdout or stderr - if exceeded child process
  *                   is killed (Default: 200*1024)
  * @param killSignal (Default: 'SIGTERM')
  * @param uid        Sets the user identity of the process. (See setuid(2).)
  * @param gid        Sets the group identity of the process. (See setgid(2).)
  * @param windowsHide Hide the subprocess console window that would normally be created on Windows systems. Default: `false`.
  */
class ExecFileSyncOptions(val cwd: js.UndefOr[String] = js.undefined,
                          val input: js.UndefOr[Input],
                          val stdio: js.UndefOr[StdIo] = js.undefined,
                          val env: js.UndefOr[js.Object] = js.undefined,
                          val encoding: js.UndefOr[String] = js.undefined,
                          val shell: js.UndefOr[Boolean | String] = js.undefined,
                          val timeout: js.UndefOr[JsNumber] = js.undefined,
                          val maxBuffer: js.UndefOr[JsNumber] = js.undefined,
                          val killSignal: js.UndefOr[KillSignal] = js.undefined,
                          val uid: js.UndefOr[JsNumber] = js.undefined,
                          val gid: js.UndefOr[JsNumber] = js.undefined,
                          val windowsHide: js.UndefOr[Boolean] = js.undefined)
    extends js.Object