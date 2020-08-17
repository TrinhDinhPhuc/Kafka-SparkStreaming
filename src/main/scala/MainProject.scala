import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}
import org.apache.spark._
import org.apache.spark.streaming._

object MainProject {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession
      .builder()
      .master("local[*]")
      .appName("Kafka-SparkStreaming")
      .config("spark.driver.bindAddress","127.0.0.1")
      .config("spark.evenLog.enabled","true")
      .getOrCreate()

    val streamingContext = new StreamingContext(sparkSession.sparkContext,Seconds(1))
    val create_directStream = createDirectStream.createDirecStream(streamingContext)
    streamingContext.start()
    streamingContext.awaitTermination()

  }
}
