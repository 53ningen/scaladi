name := "sacaladi"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "com.google.inject" % "guice" % "4.0"

libraryDependencies += "org.specs2" %% "specs2-core" % "2.4.15" % "test"
libraryDependencies in sacaladi ++= Seq(
  "org.specs2" % "specs2-core_2.11" % "latest.integration" % "test"
)
resolvers in sacaladi ++= Seq(
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
)
scalacOptions in Test ++= Seq(
  "-Yrangepos"
)
