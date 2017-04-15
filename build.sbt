name := """helios-server"""
organization := "io.pl"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.1"

libraryDependencies ++= {
  Seq(
    filters,
    "com.softwaremill.macwire" %% "macros"             % "2.3.0"  % Provided,
    "org.scalatestplus.play"   %% "scalatestplus-play" % "3.0.0-M3" % Test
  )
}