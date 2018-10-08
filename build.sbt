lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.painsco",
      scalaVersion := "2.12.7"
    )),
    name := "Ventilation"
  )

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies ++= Seq(
  "com.github.melrief" %% "purecsv" % "0.1.1",
  "org.scalaz" %% "scalaz-zio" % "0.2.10",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)
