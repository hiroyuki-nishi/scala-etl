import com.amazonaws.services.glue.GlueContext
import com.amazonaws.services.glue.util.{GlueArgParser, Job, JsonOptions}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.JavaConverters._

object SparkSample {
  def main(sysArgs: Array[String]): Unit = {
    println("START!!!!!!!")
    val glueContext: GlueContext = new GlueContext(
      new SparkContext(
        new SparkConf()
          .setMaster("local")
          .setAppName("GlueExample")
          .set("dynamodb.endpoint", "http://localhost:4569")
          .set("fs.s3a.endpoint", "http://localhost:4572")
          .set("fs.s3a.path.style.access", "true")
          .set("fs.s3a.aws.credentials.provider", "com.amazonaws.auth.DefaultAWSCredentialsProviderChain")
      ))
    //    val sparkSession: SparkSession = glueContext.getSparkSession

    println("SCCCCCCCCCCCCC")
    val args = GlueArgParser.getResolvedOptions(sysArgs, Seq("JOB_NAME").toArray)
    Job.init(if (args("JOB_NAME") != null) args("JOB_NAME") else "test", glueContext, args.asJava)
    val source = glueContext.getSource(
      connectionType = "dynamodb",
      // https://docs.aws.amazon.com/ja_jp/glue/latest/dg/aws-glue-programming-etl-connect.html#aws-glue-programming-etl-connect-dynamodb
      connectionOptions =
        JsonOptions(Map(
          "dynamodb.input.tableName" -> "aws-glue-local-test-table"
        ))
    )
    println("source")
    val frame = source.getDynamicFrame()
    println("frame")
    val applymapping = frame.applyMapping(
      mappings = Seq(
        ("Id", "string", "Id", "string"),
        ("Column1", "string", "Column1", "string"),
        ("Column2", "string", "Column2", "string"),
        ("Column3", "string", "Column3", "string")
      )
    )
    glueContext.getSinkWithFormat(
      connectionType = "s3",
      options = new JsonOptions(
        s"""{
           |"path": "s3://aws-glue-local-test-bucket"
           |}""".stripMargin),
      format = "csv"
    ).writeDynamicFrame(frame)

    println("Wrote Frame")
    Job.commit()
  }
}
