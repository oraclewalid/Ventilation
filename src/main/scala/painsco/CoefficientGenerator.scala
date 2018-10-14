package painsco

import painsco.DailySalesModels.{DetailedDailySales, RawDailySales}
import painsco.Intervals.{DailyInterval, Week, WeekEnd}
import painsco.Dates._

object CoefficientGenerator {

  case class Coefficient(sand: Int, vienn: Int, pat: Int, pain: Int, bois: Int, onSite: Int)

  def generate[T](implicit it: DailyInterval[T]): Coefficient = {
    Coefficient(it.SandInterval.generate, it.ViennInterval.generate, it.PatInterval.generate,
      it.PainInterval.generate, it.BoisInterval.generate, it.OnSiteInterval.generate)
  }

  def compute(coefficient: Coefficient, rawDailySales: RawDailySales) : DetailedDailySales = {

    def computeByType(coefficient: Double): Double = {
      BigDecimal((coefficient * rawDailySales.grosssales) / 100)
        .setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble
    }

    val sand = computeByType(coefficient.sand)
    val vienn = computeByType(coefficient.vienn)
    val pat = computeByType(coefficient.pat)
    val bois = computeByType(coefficient.bois)
    val onSite = computeByType(coefficient.onSite)

    val pain = BigDecimal(rawDailySales.grosssales - (sand + vienn + pat + bois + onSite))
      .setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble

    DetailedDailySales(
      date = rawDailySales.date,
      sand = sand,
      vienn = vienn,
      pat = pat,
      bois = bois,
      onSite = onSite,
      grosssales = rawDailySales.grosssales,
      pain = pain
    )
  }

  def comot(rawDailySales: RawDailySales): DetailedDailySales = {
    val coefficient = {
      if(isWeekEnd(rawDailySales.date))
        generate[WeekEnd]
      else
        generate[Week]
    }
    compute(coefficient, rawDailySales)
  }

  
}
