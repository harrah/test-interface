package sbt;

public interface TestFingerprint
{
	/** The name of the type that designates a test.*/
	public String superClassName();
	/** Whether a test is a module or a class*/
	public boolean isModule();
}