package painsco

import java.time.LocalDate

object DailySalesModels {

  case class RawDailySales(date: LocalDate, grosssales: Double)

  case class DetailedDailySales(date: LocalDate, sand: Double, vienn: Double, pat: Double, pain: Double, bois: Double, onSite: Double, grosssales: Double)
}
