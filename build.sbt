
lazy val guava = "com.google.guava" % "guava" % "18.0"
//lazy val sparkCore = "org.apache.spark" %% "spark-core" % "2.4.5"
lazy val sparkSQL = "org.apache.spark" %% "spark-sql" % "2.4.5"

lazy val commonDependencies = Seq(guava, sparkSQL)

lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.3.0-SNAP2" % Test
lazy val mockito = "org.mockito" %% "mockito-scala" % "1.14.4"

lazy val commonTestDependencies = Seq(scalaTest, mockito)

lazy val commonSettings = Seq(
  crossPaths := false,
  organization := "com.jKrak",
  version := "1.0",
  scalaVersion := "2.13.1",
  libraryDependencies ++= commonDependencies,
  libraryDependencies ++= commonTestDependencies
)

lazy val global = project
  .in(file("."))
  .settings(commonSettings: _*)
  .settings(name := "Advent of Code")

  //.aggregate(year2019)


lazy val year2019 = project
  .in(file("2019"))
  .settings(commonSettings: _*)
  .settings(name := "Advent of Code - 2019")
