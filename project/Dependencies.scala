import sbt._
import sbt.Keys._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Dependencies {
  val scalaReflect     = Def.setting("org.scala-lang" % "scala-reflect" % scalaVersion.value)
  val scalatestVersion = "3.2.10"

  val core = Def.setting(
    Seq(
      scalaReflect.value,
      "net.exoego" %%% "scalajs-nodejs-markers" % "0.0.2",
      "org.scalatest" %%% "scalatest" % scalatestVersion % "test"
    )
  )

  val app = Def.setting(
    Seq(
      scalaReflect.value,
      "net.exoego"               %%% "scalajs-types-util" % "0.3.0"          % "provided",
      "org.scalatest"            %%% "scalatest"          % scalatestVersion % "test",
      "com.thoughtworks.enableIf" %% "enableif"           % "1.1.7"
    )
  )

}
