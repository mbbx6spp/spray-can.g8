package $orgId$

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

class ApiServiceActor extends Actor with ApiService {
  def actorRefFactory = context
  def receive = runRoute(apiRoutes)
}

trait ApiService extends HttpService {
  val apiRoutes =
    path("") {
      get {
        respondWithMediaType(`text/plain`) { complete("hello!") }
      }
    }
}
