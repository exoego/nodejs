package io.scalajs.nodejs
package child_process

import io.scalajs.nodejs
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/** The child_process module provides the ability to spawn child processes in a manner that is similar, but not
  * identical, to popen(3). This capability is primarily provided by the child_process.spawn() function.
  *
  * @see
  *   https://nodejs.org/api/child_process.html
  */
@js.native
trait ChildProcess extends IEventEmitter {
  def kill(signal: js.UndefOr[KillSignal]): Unit = js.native
  def kill(): Unit                               = js.native
  def ref(): Unit                                = js.native
  def unref(): Unit                              = js.native

  val channel: js.UndefOr[js.Object] = js.native
  val connected: Boolean             = js.native
  val killed: Boolean                = js.native
  val pid: Int                       = js.native
  val stderr: stream.IReadable       = js.native
  val stdin: stream.IWritable        = js.native
  val stdio: js.Array[IEventEmitter] = js.native
  val stdout: stream.IReadable       = js.native
}

@js.native
trait ForkedChildProcess extends ChildProcess {
  def disconnect(): Unit = js.native

  def send(message: js.Any,
           sendHandle: Handle,
           options: SendOptions,
           callback: js.Function1[nodejs.Error, Any]
  ): Boolean                                                                                        = js.native
  def send(message: js.Any, sendHandle: Handle, options: SendOptions): Boolean                      = js.native
  def send(message: js.Any, sendHandle: Handle, callback: js.Function1[nodejs.Error, Any]): Boolean = js.native
  def send(message: js.Any, sendHandle: Handle): Boolean                                            = js.native
  def send(message: js.Any, callback: js.Function1[nodejs.Error, Any]): Boolean                     = js.native
  def send(message: js.Any): Boolean                                                                = js.native
}

/** @see
  *   https://nodejs.org/api/child_process.html
  */
@JSImport("child_process", JSImport.Namespace)
@js.native
object ChildProcess extends scala.scalajs.js.Object {
  def exec(args: String, options: ExecOptions, callback: ExecCallback): ChildProcess = js.native
  def exec(args: String, callback: ExecCallback): ChildProcess                       = js.native
  def exec(args: String, options: ExecOptions): ChildProcess                         = js.native
  def exec(args: String): ChildProcess                                               = js.native

  def execFile(file: String, args: js.Array[String], options: ExecOptions, callback: ExecCallback): ChildProcess =
    js.native
  def execFile(file: String, args: js.Array[String], options: ExecOptions): ChildProcess   = js.native
  def execFile(file: String, args: js.Array[String], callback: ExecCallback): ChildProcess = js.native
  def execFile(file: String, args: js.Array[String]): ChildProcess                         = js.native
  def execFile(file: String, options: ExecOptions, callback: ExecCallback): ChildProcess   = js.native
  def execFile(file: String, options: ExecOptions): ChildProcess                           = js.native
  def execFile(file: String, callback: ExecCallback): ChildProcess                         = js.native
  def execFile(file: String): ChildProcess                                                 = js.native

  def execSync(command: String, options: ExecOptions): Output = js.native
  def execSync(command: String): Output                       = js.native

  def execFileSync(file: String, args: js.Array[String], options: ExecFileSyncOptions): Output = js.native
  def execFileSync(file: String, args: js.Array[String]): Output                               = js.native
  def execFileSync(file: String, options: ExecFileSyncOptions): Output                         = js.native
  def execFileSync(file: String): Output                                                       = js.native

  def fork(modulePath: String, args: js.Array[String], options: ForkOptions): ForkedChildProcess = js.native
  def fork(modulePath: String, args: js.Array[String]): ForkedChildProcess                       = js.native
  def fork(modulePath: String, options: ForkOptions): ForkedChildProcess                         = js.native
  def fork(modulePath: String): ForkedChildProcess                                               = js.native

  def spawn(command: String, args: js.Array[String], options: SpawnOptions): ChildProcess = js.native
  def spawn(command: String, args: js.Array[String]): ChildProcess                        = js.native
  def spawn(command: String, options: SpawnOptions): ChildProcess                         = js.native
  def spawn(command: String): ChildProcess                                                = js.native

  def spawnSync(command: String, args: js.Array[String], options: SpawnSyncOptions): SpawnSyncResult = js.native
  def spawnSync(command: String, args: js.Array[String]): SpawnSyncResult                            = js.native
  def spawnSync(command: String, options: SpawnSyncOptions): SpawnSyncResult                         = js.native
  def spawnSync(command: String): SpawnSyncResult                                                    = js.native
}
