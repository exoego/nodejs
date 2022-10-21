inThisBuild(
  List(
    organization := "net.exoego",
    licenses     := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
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
    )
  )
)

lazy val scala213 = "2.13.10"
lazy val scala212 = "2.12.16"
ThisBuild / crossScalaVersions := Seq(scala213, scala212)
ThisBuild / scalaVersion       := scala213
Global / excludeLintKeys ++= Set(publishArtifact, scalacOptions)

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
  if (nodejsVersion.startsWith("12.")) p.aggregate(nodejs_v12)
  else if (nodejsVersion.startsWith("14.")) p.aggregate(nodejs_v12, nodejs_v14)
  else p.aggregate(nodejs_v12, nodejs_v14, nodejs_v16)
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
      case Seq(v16, v14, v12) => Map("16" -> v16, "14" -> v14, "12" -> v12)
    }
  } finally {
    ciYaml.close()
  }
}
val latestNodeVersion = "16"
lazy val nodejs_v16   = createNodeVersionSpecificProject(nodeVerMap("16"))
lazy val nodejs_v14   = createNodeVersionSpecificProject(nodeVerMap("14"))
lazy val nodejs_v12   = createNodeVersionSpecificProject(nodeVerMap("12"))

def createNodeVersionSpecificProject(nodeFullVersion: String) = {
  val majorVersion = nodeFullVersion.split("\\.")(0)
  val isLatest     = majorVersion == latestNodeVersion
  sbt
    .Project(id = s"nodejs_v${majorVersion}", base = file(s"./app/nodejs-v${majorVersion}"))
    .enablePlugins(ScalaJSPlugin)
    .settings(MySettings.commonSettings)
    .settings(MySettings.commonScalaJsSettings)
    .settings(MySettings.commonMacroParadiseSetting)
    .settings(MySettings.publishingSettings)
    .settings(
      Compile / unmanagedSourceDirectories ++= {
        val symlinkDir = baseDirectory.value / "src" / "main"
        val hasSymlink = symlinkDir.exists && symlinkDir.isDirectory
        Seq(file("app") / s"nodejs-v${latestNodeVersion}" / "src" / "main" / "scala").filter(_ =>
          !isLatest && !hasSymlink
        )
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
