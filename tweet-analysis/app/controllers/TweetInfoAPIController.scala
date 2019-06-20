package controllers

import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._
import services.TweetStreamService

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class TweetInfoAPIController @Inject()(
    cc: ControllerComponents,
    tweetService: TweetStreamService
) extends AbstractController(
      cc
    ) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() =
    Action {
      implicit request: Request[
        AnyContent
      ] =>
        tweetService
          .getInfo() map { msg =>
          Ok(
            Json.toJson(
              msg
            )
          )
        } getOrElse NotFound
    }
}
