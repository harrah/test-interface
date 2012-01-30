package org.scalatools.testing2;

/**
 * Indicates a suite of tests aborted while running.
 *
 * <p>
 * This event indicates an error that does not represent a failed tests, but some other
 * problem. However, it can participate in a rerun of failures. If requested to be rerun,
 * the entire suite that aborted should be rerun.
 * </p>
 */
public class SuiteAbortedEvent implements Event {

    private String className;
    private String suiteId;
    private Throwable throwable;

    /**
     * Constructs a new <code>SuiteAbortedEvent</code> with passed class name,
     * suite ID, and <code>Throwable</code>.
     *
     * @param className the class name for this <code>SuiteAbortedEvent</code>
     * @param suiteId a suite ID that can be used to rerun the suite, or <code>null</code> if
     *                no suite ID is needed for rerunning
     * @param throwable a <code>Throwable</code> associated with this <code>SuiteAbortedEvent</code>,
     *                  or <code>null</code> if no <code>Throwable</code> is associated with this event
     */
    public SuiteAbortedEvent(String className, String suiteId, Throwable throwable) {
        this.className = className;
        this.suiteId = suiteId;
        this.throwable = throwable;
    }

    /**
     * Constructs a new <code>SuiteAbortedEvent</code> with passed class name
     * and <code>Throwable</code>.
     *
     * <p>
     * The <code>suiteId</code> returned by a <code>SuiteAbortedEvent</code> created via
     * this constructor will be <code>null</code>.
     * </p>
     *
     * @param className the class name for this <code>SuiteAbortedEvent</code>
     * @param throwable a <code>Throwable</code> associated with this <code>SuiteAbortedEvent</code>,
     *                  or <code>null</code> if no <code>Throwable</code> is associated with this event
     */
    public SuiteAbortedEvent(String className, Throwable throwable) {
        this.className = className;
        this.suiteId = null;
        this.throwable = throwable;
    }

    // Note, in ScalaTest this is for -s <testClassName>
    /**
     * The class name for this <code>SuiteAbortedEvent</code>.
     *
     * @return the class name passed to this <code>SuiteAbortedEvent</code>
     */
    public String className() {
        return className;
    }

    // in ScalaTest, maybe need another name for the -S
    // Note: in ScalaTest, if suiteId is not null, this is for -S <testId.suiteId>
    /**
     * The suite ID for the suite that aborted, which can be used to rerun the aborted suite.
     *
     * @return the test ID passed to this <code>TestFailedEvent</code>
     */
    public String suiteId() {
        return suiteId;
    }

    /**
     * Returns the <code>Throwable</code> that caused this <code>SuiteAbortedEvent</code>, or
     *          <code>null</code> if no <code>Throwable</code> was associated with this event.
     *
     * @return the <code>Throwable</code> passed to this <code>SuiteAbortedEvent</code>, or
     *          <code>null</code>, if no <code>Throwable</code> was passed.
     */
    public Throwable throwable() {
        return throwable;
    }
}
