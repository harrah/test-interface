package org.scalasbt.testing;

/**
 * An event that indicates a failure occurred.
 *
 * <p>
 * Implementing test frameworks can decide how to differentiate between "failures" and
 * "errors." JUnit reports assertion failures as "failures," and any other problems as "errors,"
 * so many users may expect these meanings.
 * </p>
 */
public class FailureEvent extends Event {

    private Throwable throwable;

    /**
     * Constructs a new <code>ErrorEvent</code> with passed <code>Descriptor</code> and
     * <code>Throwable</code>.
     *
     * @param descriptor the <code>Descriptor</code> that identifies the suite or test about
     *                   which this event was fired.
     * @param throwable a <code>Throwable</code> associated with this <code>ErrorEvent</code>,
     *                  or <code>null</code> if no <code>Throwable</code> is associated with this event.
     */
    public FailureEvent(Descriptor descriptor, Throwable throwable) {
        super(descriptor);
        this.throwable = throwable;
    }

    /**
     * Constructs a new <code>ErrorEvent</code> with passed <code>Descriptor</code> and a <code>null</code>
     * <code>Throwable</code>.
     *
     * @param descriptor the <code>Descriptor</code> that identifies the suite or test about
     *                   which this event was fired.
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
