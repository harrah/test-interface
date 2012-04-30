package org.scalasbt.testing;

/**
 * An event fired by the test framework during a run.
 */
public interface Event {

    /*
     * The fully qualified name of a class that can rerun the suite or test
     *     about which an event was fired. This method should never return <code>null</code>.
     */
    String fullyQualifiedName();

    /**
     * Indicates whether the fullyQualifiedName refers to a module (singleton object). If so, the
     *          fullyQualifiedName string does not include the trailing dollar sign.
     */
    boolean isModule();

    /*
     * Additional information identifying the suite or test about which an event was fired. This
     * method should never return <code>null</code>.
     */
    Selector selector();

    /**
     * Indicates whether the event represents a test failure, error, success, or skip. This method should
     * never return <code>null</code>.
     */
    Status status();

    /*
     * A <code>Throwable</code> associated with this <code>Event</code>,
     *     or <code>null</code> if no <code>Throwable</code> is associated with this event.
     */
    Throwable throwable();
}

