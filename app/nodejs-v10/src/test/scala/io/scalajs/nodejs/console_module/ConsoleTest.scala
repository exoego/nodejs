package io.scalajs.nodejs.console_module

import io.scalajs.nodejs.fs.Fs
import org.scalatest.BeforeAndAfterEach

import scala.scalajs.js
import org.scalatest.funspec.AnyFunSpec

class ConsoleTest extends AnyFunSpec with BeforeAndAfterEach {
  private val logFileName = "x.nodejs10.ConsoleTest"

  override def afterEach(): Unit = {
    if (Fs.existsSync(logFileName)) Fs.unlinkSync(logFileName)
  }

  it("should accept no-arguments") {
    Console.log()
    Console.info()
    Console.warn()
    Console.debug()
    Console.error()
    Console.trace()
  }

  it("should accept single arguments") {
    Console.log("a")
    Console.info("a")
    Console.warn("a")
    Console.debug("a")
    Console.error("a")
    Console.trace("")

    Console.log(ScalaNativeObject(1))
    Console.info(ScalaNativeObject(1))
    Console.warn(ScalaNativeObject(1))
    Console.debug(ScalaNativeObject(1))
    Console.error(ScalaNativeObject(1))
    Console.trace(ScalaNativeObject(1))
  }

  it("should accept multiple arguments") {
    Console.log("a", 1)
    Console.info("a", 2)
    Console.warn("a", 3)
    Console.debug("a", 4)
    Console.error(ScalaNativeObject(1), 5)
    Console.trace("", ScalaNativeObject(1))
    Console.log("a", 1, ScalaNativeObject(1))
    Console.info("a", 2, ScalaNativeObject(1))
    Console.warn("a", 3, ScalaNativeObject(1))
    Console.debug(ScalaNativeObject(1), "a", 4)
    Console.error(ScalaNativeObject(1), "a", 5)
    Console.trace(ScalaNativeObject(1), "a", 6)
  }

  it("should be passed to foreach") {
    val s: Seq[js.Any] = Seq("s", true)
    s.foreach(Console.log)
    s.foreach(Console.info)
    s.foreach(Console.warn)
    s.foreach(Console.debug)
    s.foreach(Console.error)
    s.foreach(Console.trace)
  }

  it("have table added in v10.0.0") {
    Console.table(js.Array("x", "y"))
  }

  it("have timeLog added in v10.7.0") {
    val label = "yay"
    Console.time(label)
    Console.timeLog(label)
    Console.timeEnd(label)
  }

  it("have constructor(options) added in v10.0.0") {
    val console = new Console(
      ConsoleOptions(
        stdout = io.scalajs.nodejs.process.Process.stdout
      )
    )

    val label = "yay"
    console.time(label)
    console.timeEnd(label)
  }
}

case class ScalaNativeObject(a: Int, b: Option[Int] = None)
