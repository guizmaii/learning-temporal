Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / scalaVersion      := "3.5.2"
ThisBuild / version           := "0.1.0-SNAPSHOT"
ThisBuild / organization      := "com.guizmaii.learning.temporal"
ThisBuild / scalafmtCheck     := true
ThisBuild / scalafmtSbtCheck  := true
ThisBuild / scalafmtOnCompile := !insideCI.value
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision // use Scalafix compatible version
ThisBuild / usePipelining     := true                        // Scala 3.5+
ThisBuild / resolvers ++= Resolver.sonatypeOssRepos("snapshots")

// ### Aliases ###

addCommandAlias("tc", "Test/compile")
addCommandAlias("ctc", "clean; Test/compile")
addCommandAlias("rctc", "reload; clean; Test/compile")

// ### App Modules ###

lazy val root = (project in file("."))
  .settings(BuildHelper.stdSettings *)
  .settings(
    name := "learning-temporal",
    libraryDependencies ++= Seq(
      "dev.zio"    %% "zio"              % "2.1.1",
      "io.temporal" % "temporal-sdk"     % "1.26.1",
      "dev.zio"    %% "zio-test"         % "2.1.1"  % Test,
      "io.temporal" % "temporal-testing" % "1.26.1" % Test
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )
