name := """customer-app-2"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.11"

libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs

libraryDependencies ++= Seq(
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final" // replace by your jpa implementation
)
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"
