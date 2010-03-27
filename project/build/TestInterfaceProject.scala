import sbt._

class TestInterfaceProject(info: ProjectInfo) extends DefaultProject(info)
{
	override def mainJavaSourcePath = path("src")
	override def managedStyle = ManagedStyle.Maven
	override def disableCrossPaths = true
	val publishTo = "Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/releases/"
	Credentials(Path.userHome / ".ivy2" / ".credentials", log)
}