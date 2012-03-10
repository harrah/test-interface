package org.scalatools.testing2;

public class TestSelector {
    
    private String testName;

    public TestSelector(String testName) {
        if (testName == null) {
            throw new NullPointerException("testName was null");
        }
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }
}
