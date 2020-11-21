# scala-etl
This Repository is a tool to local test AWS Glue scripts written in Scala
https://docs.aws.amazon.com/ja_jp/glue/latest/dg/aws-glue-programming-etl-libraries.html#develop-local-scala

### Dependencies
* Scala: 2.11.1
* Apache Maven: ???
* Apache Spark: ???
* localStack

### Install
brew install mave
brew install apache-spark

### Test
1.  localStackの起動
docker run -it -p 4567-4582:4567-4582 -p 8080:8080 localstack/localstack

2. テスト用のDynamoDBテーブル＋データを追加+S3バケット作成
sh testSetup.sh

### 役立ち情報
spark-shell

ex: 
scala> val rdd = sc.parallelize(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
scala> rdd.reduce(_ + _)
res0: Int = 55

### ETL
#### ScalaAPI
https://docs.aws.amazon.com/ja_jp/glue/latest/dg/glue-etl-scala-apis-glue-gluecontext.html#glue-etl-scala-apis-glue-gluecontext-defs-getSinkWithFormat

#### 接続パラメーター
https://docs.aws.amazon.com/ja_jp/glue/latest/dg/aws-glue-programming-etl-connect.html#aws-glue-programming-etl-connect-dynamodb