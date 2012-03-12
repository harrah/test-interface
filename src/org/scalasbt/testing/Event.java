package org.scalasbt.testing;

/**
 * An Event fired by the test framework during a run.
 */
public abstract class Event {

    private Descriptor descriptor;

    /**
     * Constructs an <code>Event</code> with the passed <code>Descriptor</code>.
     *
     * @param descriptor the <code>Descriptor</code> that identifies the suite or test about
     *                   which this event was fired.
     */
    public Event(Descriptor descriptor) {
        if (descriptor == null) {
            throw new NullPointerException("descriptor was null");
        }
        this.descriptor = descriptor;
    }

    /**
     * The <code>Descriptor</code> that identifies the suite or test about
     *                   which this event was fired.
     *
     * @return The <code>Descriptor</code> that identifies the suite or test about
     *                   which this event was fired.
     */
    public Descriptor getDescriptor() {
        return descriptor;
    }
}

