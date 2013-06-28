name := "test-interface"

organization := "org.scalatest"

version := "1.0-SNAP7"

scalaVersion := "2.10.1"

// javaSource in Compile <<= baseDirectory(base => base / "src")

// disable using the Scala version in output paths and artifacts
crossPaths := false

resolvers ++= Seq("releases" at "http://oss.sonatype.org/content/repositories/releases",
                  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "localmaven" at "file://"+Path.userHome+"/.m2/repository")

publishTo <<= version { v: String =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some("publish-snapshots" at nexus + "content/repositories/snapshots")
  else                             Some("publish-releases" at nexus + "service/local/staging/deploy/maven2")
}

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0.M6-SNAP24" % "test"

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://www.scala-sbt</url>
  <licenses>
    <license>
      <name>Test Interface License</name>
      <url>https://github.com/harrah/test-interface/blob/master/LICENSE</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/harrah/test-interface</url>
  </scm>
  <developers>
    <developer>
      <id>harrah</id>
      <name>Mark Harrah</name>
    </developer>
    <developer>
      <id>josh</id>
      <name>Josh Cough</name>
    </developer>
    <developer>
      <id>bill</id>
      <name>Bill Venners</name>
    </developer>
    <developer>
      <id>cheeseng</id>
      <name>Chua Chee Seng</name>
    </developer>
  </developers>
)
