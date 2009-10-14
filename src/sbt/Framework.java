package sbt;

public interface Framework
{
	/** The name of the test framework that this object represents.  It is intended to be a human readable label.*/
	public String name();
	/** Specifies how to identify classes that are tests.*/
	public TestFingerprint[] tests();

	/** Provide a runner for tests that will load test classes from 'testClassLoader' and direct all
	* logging output from the framework to 'logger'.*/
	public Runner testRunner(ClassLoader testClassLoader, Logger logger);
}