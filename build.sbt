name := "GuicePartialMock"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
   "net.codingwell" %% "scala-guice" % "4.1.0",
   "org.scalatest" % "scalatest_2.12" % "3.0.3",
   "org.scalamock" % "scalamock-scalatest-support_2.12" % "3.5.0",
   "org.mockito" % "mockito-core" % "2.7.22"
)