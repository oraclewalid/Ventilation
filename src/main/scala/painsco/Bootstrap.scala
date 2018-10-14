package painsco

import java.io.IOException

import DailySalesModels.RawDailySales
import scalaz.zio.{App, IO}
import scalaz.zio.console._
import purecsv.unsafe._
import purecsvextension._

object Bootstrap extends App {

  def run(args: List[String]): IO[Nothing, ExitStatus] =
    myAppLogic.
      attempt.
      map(_.fold(_ => 1, _ => 0)).
      map(ExitStatus.ExitNow(_))

  def myAppLogic: IO[IOException, Unit] ={

    val records = CSVReader[RawDailySales].readCSVFromFileName("/home/walid/painsco/Ventilation/src/main/resources/T4.csv", skipHeader = true)
    for {
      _ <- putStrLn(s"${records.length}")
    } yield ()
  }

}