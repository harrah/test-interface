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

    private String suiteId;
    private Throwable throwable;

    public SuiteAbortedEvent(String suiteId, Throwable throwable) {
        this.suiteId = suiteId;
        this.throwable = throwable;
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
