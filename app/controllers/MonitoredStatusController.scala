package controllers

import java.time.LocalDateTime

import models.MonitoredStatus
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

class MonitoredStatusController(components: ControllerComponents) extends AbstractController(components) {

  def index = Action{
    val ms = MonitoredStatus("ERROR","LOCAL",LocalDateTime.now(),"An Error occur")
    Ok(Json.toJson(ms))
  }

}
