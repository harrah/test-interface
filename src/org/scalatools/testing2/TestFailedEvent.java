package org.scalatools.testing2;

/**
 * An event that indicates an error occurred that represents a
 * failed test.
 *
 * <p>
 * This event includes information, a TestId, that can
 * be used to rerun the failed test. The <code>className</code> contained in this
 * event should be the one that was passed to <code>Runner.getTask</code> that
 * created the task the eventually led to this failed test. "Eventually" means
 * that executing either the returned task itself, or one of the tasks produced
 * by executing the returned tasks, or produced by executing one of those tasks,
 * and so on, caused the test that failed to be run.
 * </p>
 */
public class TestFailedEvent implements Event {

    private String className;
    private TestId testId;
    private Throwable throwable;

    public TestFailedEvent(String className, TestId testId, Throwable throwable) {
        this.className = className;
        this.testId = testId;
        this.throwable = throwable;
    }

    // Note, in ScalaTest this is for -s <className>
    /**
     * The class name for this <code>TestFailedEvent</code>.
     *
     * @return the class name passed to this <code>TestFailedEvent</code>
     */
    public String className() {
        return className;
    }

    // Note: in ScalaTest this is for, if testId.suiteId is not null, -S <testId.suiteId>
    // and -t <testId.testName>
    /**
     * The test ID for thr test that failed, which can be used to rerun the failed test.
     *
     * @return the test ID passed to this <code>TestFailedEvent</code>
     */
    public TestId testId() {
        return testId;
    }

    /**
     * Returns the <code>Throwable</code> that caused this <code>TestFailedEvent</code>, or
     *          <code>null</code> if no <code>Throwable</code> was associated with this event.
     *
     * @return the <code>Throwable</code> passed to this <code>TestFailedEvent</code>, or
     *          <code>null</code>, if no <code>Throwable</code> was passed.
     */
    public Throwable throwable() {
        return throwable;
    }
}
