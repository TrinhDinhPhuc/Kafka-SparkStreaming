import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets
object createDirectStream{
  def createDirecStream(streamingContext:StreamingContext): Unit ={
    val kafkaParams = Map[String,Object](
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "use_a_separate_group_id_for_each_stream",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean)
    )

    val topics = Array("trump")

    val stream = KafkaUtils.createDirectStream[String, String](
      streamingContext,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams)
    )

//    stream.map(record => (record.key, record.value) )
    stream.map(record=>(record.value().toString)).print()

//    Files.write(Paths.get("/home/harry/Documents/Kafka-SparkStreaming/logs/logs.txt"), stream.map(record=>(record.value().toString)).print.toString.getBytes(StandardCharsets.UTF_8))
  }
}
