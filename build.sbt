val Organization = "inseo.io"
val Name = "functional-thinking"
val Version = "0.0.1"
val ScalaVersion = "2.12.8"

lazy val commonSettings = Seq(
  organization := Organization,
  name := Name,
  version := Version,
  scalaVersion := ScalaVersion,
  scalacOptions := Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Ypartial-unification",
    "-target:jvm-1.8"
  ),
  resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  libraryDependencies ++= Seq(
    library.catsCore
  )
)

lazy val root = (project in file("root"))
  .settings(commonSettings)

lazy val library = 
  new {
    object Version {
      val cats = "1.1.0"
    }
    val catsCore = "org.typelevel" %% "cats-core" % Version.cats
  }
