package org.scalatools.testing2;

/**
 * A container for information sufficient to identify a failed test that can be rerun. 
 */
public class TestId {

    private String suiteId;
    private String testName;

    /**
     * Constructs a new <code>TestId</code> with passed <code>suiteId</code> and <code>testName</code>.
     * 
     * @param suiteId a string ID for the suite containing the failed test, or <code>null</code> if no
     *                suite ID is necessary to identify the failed test
     * @param testName a string name for the failed test represented by this <code>TestId</code>
     *
     * @throws NullPointerException if <code>testName</code> is null
     */
    public TestId(String suiteId, String testName) {
        if (testName == null)
            throw new NullPointerException("testName was null");
        this.suiteId = suiteId;
        this.testName = testName;
    }

    /**
     * Constructs a new <code>TestId</code> with passed <code>testName</code> and a <code>null</code>
     * <code>suiteId</code>.
     *
     * @param testName a string name for the failed test represented by this <code>TestId</code>
     *
     * @throws NullPointerException if <code>testName</code> is null
     */
    public TestId(String testName) {
        this(null, testName);
    }

    // in ScalaTest, maybe need another name for the -S
    // Can be null.
    public String suiteId() {
        return suiteId;
    }

    // For the -t   cannot be null
    public String testName() {
        return testName;
    }
}
