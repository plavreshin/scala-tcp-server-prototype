lazy val `tcp-server`: Project = (project in file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)
  .settings(
    organization := "org.laborunion",
    name := "scala-tcp-server-prototype",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.11.8",
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8"),
    fork in run := true,
    parallelExecution in IntegrationTest := false,
    libraryDependencies ++= dependencies
  )

lazy val dependencies: Seq[ModuleID] = {

  val akkaV = "2.4.10"
  val scalatestV = "2.2.6"
  val mockitoV = "1.10.19"

  Seq(
    // akka
    "com.typesafe.akka" %% "akka-actor" % akkaV,

    // tests
    "org.scalatest" %% "scalatest" % scalatestV % "it, test",
    "org.mockito" % "mockito-core" % mockitoV % "it, test"
  )
}