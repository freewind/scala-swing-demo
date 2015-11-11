name := "scala-swing-demo"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-swing" % "1.0.1",
  "io.reactivex" % "rxswing" % "0.21.0",
  "com.github.benhutchison" %% "scalaswingcontrib" % "1.5",
  "io.reactivex" %% "rxscala" % "0.25.0",
  "pl.metastack" %% "metarx" % "0.1.3"
)
