package org.scalasbt.testing;

/**
 * Information in addition to a test class name that identifies a test in a nested suite about which an
 * event was fired.
 */
public class NestedTestSelector extends Selector {

    private String suiteId;
    private String testName;

    /**
     * Constructs a new <code>NestedSuiteSelector</code> with given <code>suiteId</code> and <code>testName</code>.
     *
     * @param suiteId the id of the nested suite containing the test
     * @param testName the name of the test
     */
    public NestedTestSelector(String suiteId, String testName) {
        if (suiteId == null) {
            throw new NullPointerException("suiteId was null");
        }
        if (testName == null) {
            throw new NullPointerException("testName was null");
        }
        this.suiteId = suiteId;
        this.testName = testName;
    }

    /**
     * An id that, in addition to a test class name, identifies a nested suite that contains a test
     * about which an event was fired.
     *
     * @return the id of the nested suite containing the test
     */
    public String getSuiteId() {
        return suiteId;
    }

    /**
     * The name of the test in a nested suite about which an event was fired.
     *
     * @return the name of the test in the nested suite identified by the id returned by <code>getSuiteId</code>.
     */
    public String getTestName() {
        return testName;
    }

}
