package painsco

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

import org.scalatest.{FlatSpec, FunSuite, Matchers}

class PureCsvExtentionTest extends FlatSpec with Matchers {

  "dateTimeStringConverter" should "convert Aug/8 to 8/8/2018" in {

    val date = PureCsvExtention.dateTimeStringConverter.from("Aug/8")


    date shouldBe  LocalDate.of(2018,8,8)
  }
}
