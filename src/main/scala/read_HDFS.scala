import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.streaming.StreamingContext

object read_HDFS {
  def readStreamData(streamingContext: StreamingContext, YOUR_HDFS_PATH:String):Unit ={
    val fs = FileSystem.get(new Configuration())
    val status = fs.listStatus(new Path(YOUR_HDFS_PATH))
    status.foreach(x=> println(x.getPath))
  }
}
