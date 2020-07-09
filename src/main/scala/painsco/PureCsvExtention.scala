package painsco

import java.time.LocalDate
import java.util.Locale

import purecsv.unsafe.converter.StringConverter

package object PureCsvExtention {

  import java.time.format.DateTimeFormatter

  val formatter = DateTimeFormatter.ofPattern("MMM/d/yyyy", Locale.US)


  implicit val dateTimeStringConverter = new StringConverter[LocalDate] {

    override def to(dateTime: LocalDate): String = dateTime.toString

    override def from(b: String): LocalDate = {
      println(b)
      LocalDate.parse(s"${b}/2020", formatter)
    }
  }

}
