package painsco

import painsco.Intervals.DailyInterval

object CoefficientGenerator {

  case class Coefficient(sand: Int, vienn: Int, pat: Int, pain: Int, bois: Int, onSite: Int)

  def generate[T : DailyInterval](implicit it: DailyInterval): Coefficient = {
    Coefficient(it.SandInterval.generate, it.ViennInterval.generate, it.PatInterval.generate,
      it.PainInterval.generate, it.BoisInterval.generate, it.BoisInterval.generate)
  }

  
}
