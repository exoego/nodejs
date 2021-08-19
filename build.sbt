lazy val scala213 = "2.13.6"
lazy val scala212 = "2.12.14"
organization in ThisBuild       := "net.exoego"
crossScalaVersions in ThisBuild := Seq(scala213, scala212)
scalaVersion in ThisBuild       := scala213

lazy val root = {
  val p = (project in file("."))
    .aggregate(core)
    .settings(MySettings.commonSettings)
    .settings(MySettings.publishingSettings)
    .settings(MySettings.nonPublishingSetting)
    .settings(
      name := "scala-js-nodejs"
    )
  val nodejsVersion = Option(System.getenv("NODEJS_VERSION")).filter(_.nonEmpty).getOrElse("")
  if (nodejsVersion.startsWith("10.")) p.aggregate(nodejs_v10)
  else if (nodejsVersion.startsWith("12.")) p.aggregate(nodejs_v10, nodejs_v12)
  else p.aggregate(nodejs_v10, nodejs_v12, nodejs_v14)
}

lazy val core = (project in file("./core"))
  .enablePlugins(ScalaJSPlugin)
  .settings(MySettings.commonSettings)
  .settings(MySettings.commonScalaJsSettings)
  .settings(MySettings.publishingSettings)
  .settings(
    name := "scala-js-nodejs-core",
    libraryDependencies ++= Dependencies.core.value
  )

lazy val nodeVerMap = {
  val ciYaml = scala.io.Source.fromFile(".github/workflows/ci.yaml")
  try {
    val nodejsVersionLine = ciYaml.getLines().filter(_.contains("nodejs:")).toSeq.head
    "\\d+\\.\\d+\\.\\d+".r.findAllIn(nodejsVersionLine).toSeq match {
      case Seq(a, b, c) => Map("14" -> a, "12" -> b, "10" -> c)
    }
  } finally {
    ciYaml.close()
  }
}
lazy val nodejs_v14 = createNodeVersionSpecificProject(nodeVerMap("14"))
lazy val nodejs_v12 = createNodeVersionSpecificProject(nodeVerMap("12"))
lazy val nodejs_v10 = createNodeVersionSpecificProject(nodeVerMap("10"))

def createNodeVersionSpecificProject(nodeFullVersion: String) = {
  val majorVersion = nodeFullVersion.split("\\.")(0)
  sbt
    .Project(id = s"nodejs_v${majorVersion}", base = file(s"./app/nodejs-v${majorVersion}"))
    .enablePlugins(ScalaJSPlugin)
    .settings(MySettings.commonSettings)
    .settings(MySettings.commonScalaJsSettings)
    .settings(MySettings.commonMacroParadiseSetting)
    .settings(MySettings.publishingSettings)
    .settings(
      unmanagedSourceDirectories in Compile ++= {
        val symlinkDir = baseDirectory.value / "src" / "main"
        val hasSymlink = symlinkDir.exists && symlinkDir.isDirectory
        Seq(file("app") / "nodejs-v14" / "src" / "main" / "scala").filter(_ => majorVersion != "14" && !hasSymlink)
      },
      scalacOptions ++= Seq(
        s"-Xmacro-settings:nodeJs${nodeFullVersion}"
      ),
      name        := s"scala-js-nodejs-v${majorVersion}",
      description := s"NodeJS v${majorVersion} API for Scala.js",
      libraryDependencies ++= Dependencies.app.value
    )
    .dependsOn(core)
}
