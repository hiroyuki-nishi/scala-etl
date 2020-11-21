import Dependencies._

name := "scala-etl"

version := "1.0.0"

lazy val root = (project in file("."))
  .settings(
    name := "aws-glue-local-scala",
    scalaVersion := "2.11.1",
    resolvers ++= Seq(
      "aws-glue-etl-artifacts" at "https://aws-glue-etl-artifacts.s3.amazonaws.com/release/"
    ),
    libraryDependencies ++= etlDependencies,
    dependencyOverrides ++= Seq(
      "com.fasterxml.jackson.core" % "jackson-core" % "2.6.7",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.7",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.6.7.1",
    )
  )
