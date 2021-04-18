package painsco

object Intervals {

  sealed trait Period
  class Week extends Period
  class WeekEnd extends Period

  case class  Interval(start: Int, end: Int){
    def generate: Int = {
      val rnd = new scala.util.Random(1111111)
      start + rnd.nextInt( (end - start) + 1 )
    }
  }

  trait DailyInterval[T] {

    val SandInterval: Interval
    val ViennInterval: Interval
    val PatInterval: Interval
    val PainInterval: Interval
    val BoisInterval: Interval
    val OnSiteInterval: Interval
  }

  implicit val weekInterval = new DailyInterval[Week] {
    override val SandInterval = Interval(20, 30)
    override val ViennInterval = Interval(27, 32)
    override val PatInterval = Interval(10, 15)
    override val PainInterval = Interval(20, 25)
    override val BoisInterval = Interval(4, 6)
    override val OnSiteInterval = Interval(0, 0)
  }

  implicit val weekEndInterval = new DailyInterval[WeekEnd] {
    override val SandInterval = Interval(3, 5)
    override val ViennInterval = Interval(25, 30)
    override val PatInterval = Interval(20, 22)
    override val PainInterval = Interval(20, 27)
    override val BoisInterval = Interval(4, 5)
    override val OnSiteInterval = Interval(0, 0)
  }
}
