package models

import java.time.LocalDateTime

import play.api.libs.json.Json

/**
  * Created by ignacio on 4/15/17.
  */
case class MonitoredStatus(status: String, origin: String, date: LocalDateTime, msg: String)

object MonitoredStatus{
  implicit val format = Json.format[MonitoredStatus]
}
