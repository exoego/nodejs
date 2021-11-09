package io.scalajs.nodejs.readline

import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.process.Process

import scala.concurrent.{ExecutionContext, Promise}
import org.scalatest.funspec.AsyncFunSpec

/** Readline Tests
  */
class ReadlineTest extends AsyncFunSpec {
  override implicit val executionContext = ExecutionContext.Implicits.global

  describe("Readline") {
    it("should read/stream files from disk") {
      val promise = Promise[Unit]()
      var lineNo  = 0
      val file    = "./package.json"
      val reader = Readline.createInterface(
        ReadlineOptions(
          input = Fs.createReadStream(file),
          output = Process.stdout,
          terminal = false
        )
      )

      reader.onLine { line =>
        lineNo += 1
      }

      reader.onClose { () =>
        promise.success(())
      }
      promise.future.map(_ => assert(lineNo === 19))
    }

    it("has REPL-like functionality") {
      val promise = Promise[Unit]()
      val rl      = Readline.createInterface(ReadlineOptions(input = Process.stdin, output = Process.stdout))
      rl.setPrompt("OHAI> ")
      rl.prompt()

      rl.onClose { () =>
        promise.success(())
      }
      rl.close()
      promise.future.map(_ => succeed)
    }
  }
}
