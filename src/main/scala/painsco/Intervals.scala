package painsco

object Intervals {

  case class  Interval(start: Int, end: Int){
    def generate: Int = {
      val rnd = new scala.util.Random
      start + rnd.nextInt( (end - start) + 1 )
    }
  }

  trait DailyInterval {

    val SandInterval: Interval
    val ViennInterval: Interval
    val PatInterval: Interval
    val PainInterval: Interval
    val BoisInterval: Interval
    val OnSiteInterval: Interval
  }

  implicit val weekInterval = new DailyInterval {
    override val SandInterval: Interval = Interval(22, 25)
    override val ViennInterval: Interval = Interval(22, 30)
    override val PatInterval: Interval = Interval(12, 15)
    override val PainInterval: Interval = Interval(15, 17)
    override val BoisInterval: Interval = Interval(22, 25)
    override val OnSiteInterval: Interval = Interval(5, 7)
  }

  implicit val weekEndInterval = new DailyInterval {
    override val SandInterval: Interval = Interval(22, 25)
    override val ViennInterval: Interval = Interval(22, 30)
    override val PatInterval: Interval = Interval(12, 15)
    override val PainInterval: Interval = Interval(15, 17)
    override val BoisInterval: Interval = Interval(22, 25)
    override val OnSiteInterval: Interval = Interval(5, 7)
  }
}
