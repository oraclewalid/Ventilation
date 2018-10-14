package painsco

import java.time.LocalDate
import java.util.Locale

import purecsv.unsafe.converter.StringConverter

package object PureCsvExtention {

  import java.time.format.DateTimeFormatter

  val formatter = DateTimeFormatter.ofPattern("yyyy/MMM/d", Locale.US)


  implicit val dateTimeStringConverter = new StringConverter[LocalDate] {

    override def to(dateTime: LocalDate): String = dateTime.toString

    override def from(b: String): LocalDate = {
      LocalDate.parse(s"2018/$b", formatter)
    }
  }

}
