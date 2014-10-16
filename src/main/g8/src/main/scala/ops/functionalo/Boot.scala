package $orgId$

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

/**
  * Boot object for the REST API service.
  */
object Boot extends App {
  implicit val system = ActorSystem("$name$")
  val service = system.actorOf(Props[ApiServiceActor], "api-service")
  implicit val timeout = Timeout(5.seconds)
  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)
}
