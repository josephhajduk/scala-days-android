import java.io.{File, FileInputStream}
import java.util.Properties
import scala.collection.JavaConverters._

object Generator {

  val manifestProperties = "manifest.properties"
  
  val defaultMap = Map("google.map.key" -> "")

  lazy val manifestPlaceholderMap: Map[String, String] = {
    (loadManifestPropertiesFile map { file =>
      val properties = new Properties()
      properties.load(new FileInputStream(file))
      properties.asScala.toMap
    }) getOrElse defaultMap
  }
  
  private def loadManifestPropertiesFile: Option[File] = {
    val file = new File(manifestProperties)
    if (file.exists()) Some(file) else None
  }

}