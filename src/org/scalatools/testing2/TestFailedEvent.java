package org.scalatools.testing2;

public class TestFailedEvent implements Event {

    private String className;
    private TestId testId;
    private Throwable throwable;

    public TestFailedEvent(String className, TestId testId, Throwable throwable) {
        this.className = className;
        this.testId = testId;
        this.throwable = throwable;
    }

    // The one passed to Runner.getTask, for the -s
    public String className() {
        return className;
    }

    // in ScalaTest, maybe need another name for the -S
    public TestId testId() {
        return testId;
    }

    /**
     * Returns the <code>Throwable</code> that caused this <code>UnexpectedErrorEvent</code>, or
     *          <code>null</code> if no <code>Throwable</code> was associated with this event.
     *
     * @return the <code>Throwable</code> passed to this <code>UnexpectedErrorEvent</code>, or
     *          <code>null</code>, if no <code>Throwable</code> was passed.
     */
    public Throwable throwable() {
        return throwable;
    }
}
