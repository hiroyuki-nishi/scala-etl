import sbt._

object Dependencies {
  lazy val etlDependencies = Seq(
    "com.amazonaws" % "AWSGlueETL" % "1.0.0",
    "org.apache.logging.log4j" % "log4j-core" % "2.13.1",
    "org.apache.spark" %% "spark-core" % "2.4.3" % "provided",
    "org.apache.spark" %% "spark-mllib" % "2.4.3" % "provided",
    "org.apache.spark" %% "spark-sql" % "2.4.3" % "provided",
    "org.scalactic" %% "scalactic" % "3.1.1",
    "org.scalamock" %% "scalamock" % "4.4.0" % Test,
    "org.scalatest" %% "scalatest" % "3.1.1" % Test,
    "com.holdenkarau" %% "spark-testing-base" % "2.4.3_0.14.0" % Test,
    "software.amazon.awssdk" % "aws-sdk-java" % "2.13.0"
  )
}
