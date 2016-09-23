import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

/**
  * Created by sharanyak on 22/9/16.
  */
object Marshaller extends SprayJsonSupport with DefaultJsonProtocol {

   implicit val itemFormat = jsonFormat13(Image)
}
