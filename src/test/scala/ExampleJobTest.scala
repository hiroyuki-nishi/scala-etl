import org.scalatest.funsuite.AnyFunSuite

class ExampleJobTest extends AnyFunSuite {
  test("Example") {
    println(s"Starting ExampleJob at ${new java.util.Date()}")

    // Trigger the execution by directly calling the main class and supplying
    // arguments. AWS Glue job arguments always begin with "--" so that the
    // resolver can correctly convert it to a Map
    ExampleJob.main(Array(
      "--JOB_NAME", "job",
      "--stage", "dev",
      "--inputBucket", "aws-glue-local-test-bucket",
      "--outputBucket", "aws-glue-local-test-bucket",
      "--inputPrefix", "input",
      "--outputPrefix", "output"
    ))

    println(s"ExampleJob Finished at ${new java.util.Date()}")

  }
}
