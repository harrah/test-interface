package org.scalatools.testing2;

public class TestId {

    private String suiteId;
    private String testName;

    public TestId(String suiteId, String testName) {
        this.suiteId = suiteId;
        this.testName = testName;
    }

    // in ScalaTest, maybe need another name for the -S
    // Can be null.
    public String suiteId() {
        return suiteId;
    }

    // For the -t
    public String testName() {
        return testName;
    }
}
