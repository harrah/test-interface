package org.scalasbt.testing;

/**
 * Indicates a test succeeded.
 */
public class SuccessEvent extends Event {
    public SuccessEvent(Descriptor descriptor) {
        super(descriptor);
    }
}
