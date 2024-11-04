ThisBuild / scalaVersion := "3.5.2"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.guizmaii.learning.temporal"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "learning-temporal",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.1.1",
      "io.temporal" % "temporal-sdk" % "1.26.1",
      "dev.zio" %% "zio-test" % "2.1.1" % Test,
      "io.temporal" % "temporal-testing" % "1.26.1" % Test
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )
