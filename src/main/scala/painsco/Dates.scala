package painsco

import java.time.{DayOfWeek, LocalDate}
import java.util.Calendar

object Dates {

  def isWeekEnd(date: LocalDate): Boolean = {
    if (date.getDayOfWeek == DayOfWeek.SATURDAY || date.getDayOfWeek == DayOfWeek.SUNDAY)
      true
    else
      false
  }
}
