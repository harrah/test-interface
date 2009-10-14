import sbt._

class TestInterfaceProject(info: ProjectInfo) extends DefaultProject(info)
{
	override def mainJavaSourcePath = path("src")
}