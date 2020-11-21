import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SparkSampleTest extends AnyFunSuite with Matchers {
//  class SparkSampleTest extends AnyFunSuite with Matchers with DataFrameSuiteBase {
//  test("test-1") {
//    import spark.implicits._
//    val df = List(("1", "Tarou")).toDF("id", "name")
//    df.collect().length should be(1)
//    val row = df.first()
//    assert(row.get(0) == "1")
//  }

  test("ETL") {
    SparkSample.main(Array("AAA"))
    assert(true)
  }
}
