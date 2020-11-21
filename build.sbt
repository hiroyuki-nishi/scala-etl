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
    libraryDependencies ++= etlDependencies
  )
