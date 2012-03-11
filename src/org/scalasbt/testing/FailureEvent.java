package org.scalasbt.testing;

/**
 * An event that indicates a failure occurred, does not represent a
 * failed test or aborted suite.
 *
 * <p>
 * Unlike failed tests, which should be reported with <code>TestFailedEvent</code>s,
 * and aborted suites, which should be reported with <code>SuiteAbortedEvent</code>s,
 * an <code>ErrorEvent</code> does not include any information that can
 * be used to rerun just the problem portion of the previous run,
 * such as a particular failed test or aborted suite.
 * </p>
 */
public class FailureEvent extends Event {

    private Throwable throwable;

    /**
     * Constructs a new <code>ErrorEvent</code> with passed
     * <code>Throwable</code>.
     *
     * @param throwable a <code>Throwable</code> associated with this <code>ErrorEvent</code>,
     *                  or <code>null</code> if no <code>Throwable</code> is associated with this event.
     */
    public FailureEvent(Descriptor descriptor, Throwable throwable) {
        super(descriptor);
        this.throwable = throwable;
    }

    /**
     * Constructs a new <code>ErrorEvent</code> with a <code>null</code>
     * <code>Throwable</code>.
     */
    public FailureEvent(Descriptor descriptor) {
        super(descriptor);
        this.throwable = null;
    }

    /**
     * Returns the <code>Throwable</code> that caused this <code>ErrorEvent</code>, or
     *          <code>null</code> if no <code>Throwable</code> was associated with this event.
     *
     * @return the <code>Throwable</code> passed to this <code>ErrorEvent</code>, or
     *          <code>null</code>, if no <code>Throwable</code> was passed.
     */
    public Throwable throwable() {
        return throwable;
    }
}
