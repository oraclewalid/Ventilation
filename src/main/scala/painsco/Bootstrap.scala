package painsco

import java.io.IOException

import DailySalesModels.RawDailySales
import scalaz.zio.{App, IO}
import scalaz.zio.console._
import purecsv.unsafe._
import PureCsvExtention._

object Bootstrap extends App {

  val headers = Some(Seq("Date", "Sandwichs", "Viennoiserie", "Patisserie","Pains","Boissons", "Conso/place", "Total"))
  def run(args: List[String]): IO[Nothing, ExitStatus] =
    myAppLogic.
      attempt.
      map(_.fold(_ => 1, _ => 0)).
      map(ExitStatus.ExitNow(_))

  def myAppLogic: IO[IOException, Unit] ={

    val records = CSVReader[RawDailySales].readCSVFromFileName("/home/walid/painsco/Ventilation/src/main/resources/T3.csv", skipHeader = true)

    val detailedDailySaleses = records.map(record => CoefficientGenerator.comot(record))
    detailedDailySaleses.reverse.writeCSVToFileName(fileName = "T33.csv", header = headers, sep = ";")
    for {
      _ <- putStrLn(s"${records.length}")
    } yield ()
  }

}