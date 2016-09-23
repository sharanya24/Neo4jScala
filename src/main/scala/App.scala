import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._
import spray.json.DefaultJsonProtocol

import scala.concurrent.Future
import scala.text.DocNest

/**
  * Created by sharanyak on 21/9/16.
  */
object App {


  def main(args: Array[String]) {

    implicit val actorSystem=ActorSystem("system")
    implicit val actorMaterializer=ActorMaterializer()
    val dao=Dao



    val route = {

      import Marshaller._

      path("image") {
        post {
          entity(as[Image]) {
            image =>
              dao.persistEntity(image)
              complete(s"Image ${image} created ")
          }
        }
      }
    }
    Http().bindAndHandle(route,"",9000)

  }

}
