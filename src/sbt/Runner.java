package sbt;

public interface Runner
{
	/** Runs the test with class name 'testClassName' and returns the result.  The test should be run in the calling (current) thread. */
	public Result run(String testClassName);
}