name := "SampleApp"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-experimental" % "1.0",
  "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "1.0",
  "com.typesafe.akka" %%"akka-http-testkit-experimental" % "1.0",
  "org.scalatest" %% "scalatest" % "2.2.5" % "test",
  "org.neo4j.driver" % "neo4j-java-driver" % "1.0.4"
)