package io.scalajs.nodejs.process

import io.scalajs.nodejs.os.OS
import io.scalajs.nodejs.TestEnvironment
import org.scalatest.funspec.AnyFunSpec

class ProcessTest extends AnyFunSpec {
  describe("Process") {
    val versionPrefix =
      if (TestEnvironment.isExecutedInExactNode10) "v10."
      else if (TestEnvironment.isExecutedInExactNode12) "v12."
      else if (TestEnvironment.isExecutedInExactNode14) "v14."
      else if (TestEnvironment.isExecutedInExactNode16) "v16."
      else "Unknown node.js version"

    it("contains the following properties") {
      assert(Process.arch.isInstanceOf[String])
      assert(Process.argv.length === 1)
      assert(Process.argv(0).endsWith("node"))
      assert(Process.config.variables.host_arch === OS.arch())
      assert(Process.connected.isEmpty)
      assert(Process.cwd().nonEmpty)
      assert(Process.env("PATH").nonEmpty)
      assert(Process.env.PATH === Process.env("PATH"))
      assert(Process.execArgv.length === 0)
      assert(Process.execPath.endsWith("node"))
      assert(Process.features.uv)
      assert(Process.moduleLoadList.length > 0)
      assert(Process.title.isInstanceOf[String])
      assert(Process.version.startsWith(versionPrefix))
      assert(s"v${Process.versions.node}".startsWith(versionPrefix))

      // TODO: actually undefined in test
      // assert(process.stdout.isTTY)
      // assert(process.stderr.isTTY)
    }

    it("hrtime") {
      val value = Process.hrtime()
      assert(value.length === 2)
      val diff = Process.hrtime(value)
      assert(diff.length === 2)
      assert(diff(0) === 0)
    }

    it("hrtime.bigint") {
      val value = Process.hrtime.bigint()
      assert(value.toString().matches("^\\d+$"))
    }
  }
}
