package modules

import com.softwaremill.macwire._
import controllers.MonitoredStatusController
import play.api.ApplicationLoader.Context
import play.api.routing.Router
import play.api._
import play.filters.HttpFiltersComponents
import router.Routes

import scala.concurrent.Future

/**
  * Created by ignacio on 4/15/17.
  */
class HeliosLoader extends ApplicationLoader{
  override def load(context: ApplicationLoader.Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment)
    }
    new MainModule(context).application
  }
}

class MainModule(context: Context) extends BuiltInComponentsFromContext(context) with HttpFiltersComponents {

  Logger.info("Starting App")

  lazy val homeController: MonitoredStatusController = wire[MonitoredStatusController]

  lazy val router: Router = {
    val prefix = "/"
    wire[Routes]
  }

  applicationLifecycle.addStopHook{ () =>
    Logger.info("Shut Down")
    Future.successful(())
  }
}