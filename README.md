# scala-etl
This Repository is a tool to local test AWS Glue scripts written in Scala
https://docs.aws.amazon.com/ja_jp/glue/latest/dg/aws-glue-programming-etl-libraries.html#develop-local-scala

### Dependencies
* Scala: 2.11.1
* Apache Maven: ???
* Apache Spark: ???

### Install
brew install mave
brew install apache-spark

### 役立ち情報
spark-shell

ex: 
scala> val rdd = sc.parallelize(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
scala> rdd.reduce(_ + _)
res0: Int = 55