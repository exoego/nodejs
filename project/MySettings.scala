import org.scalajs.sbtplugin.ScalaJSPlugin.AutoImport.{ModuleKind, scalaJSModuleKind}
import sbt._
import sbt.Keys._
import sbtrelease.ReleasePlugin.autoImport._
import sbtrelease.ReleaseStateTransformations._

object MySettings {

  lazy val commonSettings = Seq(
    autoCompilerPlugins := true,
    scalacOptions ++= Seq(
      "-deprecation",
      "-unchecked",
      "-feature",
      "-language:implicitConversions",
      "-Xlint"
    ),
    scalacOptions in Compile in compile ++= Seq(
      "-Xfatal-warnings"
    ),
    scalacOptions in Compile in doc ++= Seq(
      "-Xfatal-warnings",
      "-no-link-warnings"
    ),
    autoAPIMappings := true
  )

  lazy val commonScalaJsSettings = Seq(
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    scalaJSModuleKind := ModuleKind.CommonJSModule,
    logBuffered in Test := true
  )

  lazy val commonMacroParadiseSetting = Seq(
    Compile / scalacOptions ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, n)) if n >= 13 => "-Ymacro-annotations" :: Nil
        case _                       => Nil
      }
    },
    libraryDependencies ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, n)) if n >= 13 => Nil
        case _                       => compilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full) :: Nil
      }
    }
  )

  lazy val nonPublishingSetting = Seq(
    skip in publish := true,
    publishArtifact := false,
    publish := {},
    publishLocal := {}
  )

  lazy val publishingSettings = Seq(
    licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/exoego/scala-js-nodejs"),
        "scm:git:git@github.com:exoego/scala-js-nodejs.git"
      )
    ),
    homepage := scmInfo.value.map(_.browseUrl),
    developers := List(
      Developer(
        id = "exoego",
        name = "TATSUNO Yasuhiro",
        email = "ytatsuno.jp@gmail.com",
        url = url("https://www.exoego.net")
      )
    ),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    publishArtifact in (Compile, packageDoc) := true,
    publishArtifact in (Compile, packageSrc) := true,
    publishArtifact in packageDoc := true,
    pomIncludeRepository := { _ =>
      false
    },
    publishTo := Some(
      if (isSnapshot.value)
        Opts.resolver.sonatypeSnapshots
      else
        Opts.resolver.sonatypeStaging
    ),
    publishConfiguration := publishConfiguration.value.withOverwrite(false),
    publishLocalConfiguration := publishLocalConfiguration.value.withOverwrite(true),
    releaseIgnoreUntrackedFiles := true,
    releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      releaseStepCommandAndRemaining("+publishSigned"),
      setNextVersion,
      commitNextVersion,
      releaseStepCommand("sonatypeReleaseAll")
    )
  )

}