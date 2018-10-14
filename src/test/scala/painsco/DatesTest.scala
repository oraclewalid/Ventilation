package painsco

import java.time.LocalDate

import org.scalatest.{FlatSpec, FunSuite, Matchers}

class DatesTest extends FlatSpec with Matchers {

  "isWeekEnd" should "return true for 14/10/2018" in {

    val date = LocalDate.of(2018,10,14)
    Dates.isWeekEnd(date) shouldBe true
  }

  "isWeekEnd" should "return true for to 13/10/2018" in {

    val date = LocalDate.of(2018,10,13)
    Dates.isWeekEnd(date) shouldBe true
  }

  "isWeekEnd" should "return true for to 12/10/2018" in {

    val date = LocalDate.of(2018,10,12)
    Dates.isWeekEnd(date) shouldBe false
  }
}