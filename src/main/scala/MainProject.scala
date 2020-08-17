import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}


object MainProject {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession
      .builder()
      .master("local[*]")
      .appName("Kafka-SparkStreaming")
      .config("spark.driver.bindAddress","127.0.0.1")
      .config("spark.evenLog.enabled","true")
      .getOrCreate()
    )
  }
}
