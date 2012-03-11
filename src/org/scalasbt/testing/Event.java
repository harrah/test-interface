package org.scalasbt.testing;

/**
 * An Event fired by the test framework during a run.
 */
public abstract class Event {
    //Model without nulls the fact that there may not be a test name, but there I think
    // is always a test clss name
    private Descriptor descriptor;

    public Event(Descriptor descriptor) {
        if (descriptor == null) {
            throw new NullPointerException("descriptor was null");
        }
        this.descriptor = descriptor;
    }

    public Descriptor getDescriptor() {
        return descriptor;
    }
}

