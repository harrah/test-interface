package org.scalatools.testing2;

public class TestFailedEvent implements Event {

    private String className;
    private TestId testId;

    public TestFailedEvent(String className, TestId testId) {
        this.className = className;
        this.testId = testId;
    }

    // The one passed to Runner.getTask, for the -s
    public String className() {
        return className;
    }

    // in ScalaTest, maybe need another name for the -S
    public TestId testId() {
        return testId;
    }
}
