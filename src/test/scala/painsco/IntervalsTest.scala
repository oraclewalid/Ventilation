package painsco


import org.scalatest.{FlatSpec, FunSuite, Matchers}
import painsco.Intervals.Interval

class IntervalsTest extends FlatSpec with Matchers {

  "dateTimeStringConverter" should "convert Aug/8 to 8/8/2018" in {

    val randomValue = Interval(3,9).generate

    println(randomValue)
    randomValue >= 3 shouldBe true
    randomValue <= 9 shouldBe true
  }
}