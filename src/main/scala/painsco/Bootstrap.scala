package painsco

import java.io.IOException
import java.time.format.DateTimeFormatter
import java.util.Date

import DailySalesModels.RawDailySales
import scalaz.zio.{App, IO}
import scalaz.zio.console._
import purecsv.unsafe._
import PureCsvExtention._

object Bootstrap extends App {

  import java.text.SimpleDateFormat

  val pattern = "M/d/yy"
  val simpleDateFormat = new SimpleDateFormat(pattern)
  val date: String = simpleDateFormat.format(new Date())
  System.out.println(date)

  val headers = Some(Seq("Date", "Sandwichs", "Viennoiserie", "Patisserie","Pains","Boissons", "Conso/place", "Total"))
  def run(args: List[String]): IO[Nothing, ExitStatus] =
    myAppLogic.
      attempt.
      map(_.fold(_ => 1, _ => 0)).
      map(ExitStatus.ExitNow(_))

  def myAppLogic: IO[IOException, Unit] ={

    val records = CSVReader[RawDailySales].readCSVFromFileName("/home/walid/Downloads/T1.csv", skipHeader = true)

    val detailedDailySaleses = records.map(record => CoefficientGenerator.comot(record))
    detailedDailySaleses.reverse.writeCSVToFileName(fileName = "T1.csv", header = headers, sep = ";")
    for {
      _ <- putStrLn(s"${records.length}")
    } yield ()
  }

}