package io.scalajs.nodejs.worker_threads

import com.thoughtworks.enableIf
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait WorkerOptions extends js.Object {
  var env: js.UndefOr[js.Object]             = js.undefined
  var eval: js.UndefOr[Boolean]              = js.undefined
  var execArgv: js.UndefOr[js.Array[String]] = js.undefined
  var stdin: js.UndefOr[Boolean]             = js.undefined
  var stdout: js.UndefOr[Boolean]            = js.undefined
  var stderr: js.UndefOr[Boolean]            = js.undefined
  var workerData: js.UndefOr[js.Any]         = js.undefined

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  var trackUnmanagedFds: js.UndefOr[Boolean] = js.undefined
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  var transferList: js.UndefOr[js.Array[js.Object]] = js.undefined

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  var resourceLimits: js.UndefOr[ResourceLimits] = js.undefined
}
