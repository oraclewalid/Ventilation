package painsco

import java.time.LocalDate

object DailySalesModels {

  case class RawDailySales(date: LocalDate, grosssales: Double)
}
