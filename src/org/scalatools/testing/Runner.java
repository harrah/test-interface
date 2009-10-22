package org.scalatools.testing;

public interface Runner
{
	/** Runs the test with class name 'testClassName' and returns the result.  The test should be run in the calling
	* (current) thread.
	*
	* 'fingerprint' indicates how the test was identified as a test.  This method may be called with the same value for
	* 'testClassName' but different fingerprints.  For example, if both a class and its companion object were tests,
	* this method would be called with the same name but with a different value for 'fingerprint.isModule'. */
	public TestResult[] run(String testClassName, TestFingerprint fingerprint, String [] args);
}