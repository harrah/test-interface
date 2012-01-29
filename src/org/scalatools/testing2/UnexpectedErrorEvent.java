package org.scalatools.testing2;

/**
 * An event that indicates an error occurred that does not represent a
 * failed test or aborted suite.
 *
 * <p>
 * Unlike failed tests, which should be reported with <code>TestFailedEvent</code>s,
 * and aborted suites, which should be reported with <code>SuiteAbortedEvent</code>s,
 * an <code>UnexpectedErrorEvent</code> does not include any information that can
 * be used to rerun just the problem portion of the previous run,
 * such as a particular failed test or aborted suite.
 * </p>
 */
public class UnexpectedErrorEvent implements Event {

    private Throwable throwable;

    /**
     * Constructs a new <code>UnexpectedErrorEvent</code> with passed
     * <code>Throwable</code>.
     *
     * @param throwable a <code>Throwable</code> associated with this <code>UnexpectedErrorEvent</code>,
     *                  or <code>null</code> if no <code>Throwable</code> is associated with this event.
     */
    public UnexpectedErrorEvent(Throwable throwable) {
        this.throwable = throwable;
    }

    /**
     * Constructs a new <code>UnexpectedErrorEvent</code> with a <code>null</code>
     * <code>Throwable</code>.
     */
    public UnexpectedErrorEvent() {
        this.throwable = null;
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
