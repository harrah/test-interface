name := "test-interface"

organization := "org.scalatest"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.1"

javaSource in Compile <<= baseDirectory(base => base / "src")

// disable using the Scala version in output paths and artifacts
crossPaths := false

resolvers ++= Seq("releases" at "http://oss.sonatype.org/content/repositories/releases",
                  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "localmaven" at "file://"+Path.userHome+"/.m2/repository")

publishTo <<= version { v: String =>
  val nexus = "https://oss.sonatype.org/"
  if (v.contains("SNAP")) Some("publish-snapshots" at nexus + "content/repositories/snapshots")
  else                    Some("publish-releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }
