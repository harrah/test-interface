package sbt.testing;

/**
 * Information in addition to a test class name that identifies a test directly contained in the suite
 * whose class had the fully qualified name specified as the <code>fullyQualifiedName</code> attribute
 * passed to the event.
 */
public final class TestWildcardSelector extends Selector
{
	private String testWildcard;

	/**
	 * Constructs a new <code>TestSelector</code> with passed <code>testName</code>.
	 *
	 * @param testName the name of the test about which an event as fired.
	 */
	public TestWildcardSelector(String testWildcard) 
	{
		if (testWildcard == null) 
		{
			throw new NullPointerException("testWildcard was null");
		}
		this.testWildcard = testWildcard;
	}

	/**
	 * The name of a test about which an event was fired.
	 *
	 * @return the name of the test
	 */
	public String getTestWildcard() 
	{
		return testWildcard;
	}
}
