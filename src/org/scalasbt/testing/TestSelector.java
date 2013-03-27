package org.scalasbt.testing;

/**
 * Information in addition to a test class name that identifies a test directly contained in the suite
 * whose class had the fully qualified name specified as the <code>fullyQualifiedName</code> attribute
 * passed to the event.
 */
public final class TestSelector extends Selector 
{

	private String testName;

	/**
	 * Constructs a new <code>TestSelector</code> with passed <code>testName</code>.
	 *
	 * @param testName the name of the test about which an event as fired.
	 */
	public TestSelector(String testName) 
	{
		if (testName == null) 
		{
			throw new NullPointerException("testName was null");
		}
		this.testName = testName;
	}

	/**
	 * The name of a test about which an event was fired.
	 *
	 * @return the name of the test
	 */
	public String getTestName() 
	{
		return testName;
	}
}
