package io.scalajs.nodejs.vm

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.{DataView, Uint8Array}
import scala.scalajs.js.|

/**
  * Contextify Script
  */
@js.native
@JSImport("vm", "Script")
class Script private[this] () extends js.Object {
  def this(code: String, options: ScriptOptions) = this()
  def this(code: String, filename: String) = this()
  def this(code: String) = this()

  def createCachedData(): io.scalajs.nodejs.buffer.Buffer = js.native

  /**
    * Runs the compiled code contained by the vm.Script object within the given contextifiedSandbox and returns the
    * result. Running code does not have access to local scope.
    * @param contextifiedSandbox A contextified object as returned by the vm.createContext() method.
    * @param options             the optional options
    * @example script.runInContext(contextifiedSandbox[, options])
    */
  def runInContext(contextifiedSandbox: Context, options: RunInContextOptions): js.Any = js.native
  def runInContext(contextifiedSandbox: Context): js.Any                               = js.native

  /**
    * First contextifies the given sandbox, runs the compiled code contained by the vm.Script object within the created
    * sandbox, and returns the result. Running code does not have access to local scope.
    * @param sandbox An object that will be contextified. If undefined, a new object will be created.
    * @param options the optional options
    * @example script.runInNewContext([sandbox][, options])
    */
  def runInNewContext(sandbox: js.Object, options: RunInNewContextOptions): js.Any = js.native
  def runInNewContext(sandbox: js.Object): js.Any                                  = js.native
  def runInNewContext(): js.Any                                                    = js.native

  /**
    * Runs the compiled code contained by the vm.Script within the context of the current global object. Running code
    * does not have access to local scope, but does have access to the current global object.
    * @param options the optional options
    * @example script.runInThisContext([options])
    */
  def runInThisContext(options: RunInContextOptions): Script = js.native
  def runInThisContext(): Script                             = js.native
}

@Factory
trait ScriptOptions extends js.Object {
  var filename: js.UndefOr[String]                     = js.undefined
  var lineOffset: js.UndefOr[Int]                      = js.undefined
  var columnOffset: js.UndefOr[Int]                    = js.undefined
  var cachedData: js.UndefOr[Uint8Array | DataView]    = js.undefined
  var produceCachedData: js.UndefOr[Boolean]           = js.undefined
  var importModuleDynamically: js.UndefOr[js.Function] = js.undefined
}

@Factory
trait RunInContextOptions extends js.Object {
  var displayErrors: js.UndefOr[Boolean] = js.undefined
  var timeout: js.UndefOr[Int]           = js.undefined
  var breakOnSigint: js.UndefOr[Boolean] = js.undefined
}

@Factory
trait RunInNewContextOptions extends js.Object {
  var displayErrors: js.UndefOr[Boolean]                = js.undefined
  var timeout: js.UndefOr[Int]                          = js.undefined
  var breakOnSigint: js.UndefOr[Boolean]                = js.undefined
  var contextName: js.UndefOr[String]                   = js.undefined
  var contextOrigin: js.UndefOr[String]                 = js.undefined
  var contextCodeGeneration: js.UndefOr[CodeGeneration] = js.undefined
}

@Factory
trait CodeGeneration extends js.Object {
  var strings: js.UndefOr[Boolean] = js.undefined
  var wasm: js.UndefOr[Boolean]    = js.undefined
}
