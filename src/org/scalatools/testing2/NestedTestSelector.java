package org.scalatools.testing2;

public class NestedTestSelector {

    private String suiteId;
    private String testName;

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

    public String getSuiteId() {
        return suiteId;
    }

    public String getTestName() {
        return testName;
    }

}
