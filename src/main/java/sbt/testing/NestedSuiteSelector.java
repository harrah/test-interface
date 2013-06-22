package sbt.testing;

/**
 * Information in addition to a test class name that identifies a nested suite about which an
 * event was fired.
 */
public final class NestedSuiteSelector extends Selector
{

	private String suiteId;

	/**
	 * Constructs a new <code>NestedSuiteSelector</code> with given <code>suiteId</code>.
	 *
	 * @param suiteId the id of the nested suite
	 */
	public NestedSuiteSelector(String suiteId) 
	{
		if (suiteId == null) 
		{
			throw new NullPointerException("suiteId was null");
		}
		this.suiteId = suiteId;
	}

	/**
	 * An id that, in addition to a test class name, identifies a nested suite about which an
	 * event was fired.
	 *
	 * @return the id of the nested suite
	 */
	public String getSuiteId() 
	{
		return suiteId;
	}
}
