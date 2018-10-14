package painsco

import java.time.LocalDate

object DailySalesModels {

  case class RawDailySales(date: LocalDate, grosssales: Double, refunds: String,discounts: String,netsales: String,costofgoods: String,grossprofit: String,margin: String,taxes: String)

  case class DetailedDailySales(date: LocalDate, sand: Double, vienn: Double, pat: Double, pain: Double, bois: Double, onSite: Double, grosssales: Double)
}
