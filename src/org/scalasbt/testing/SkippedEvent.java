package org.scalasbt.testing;

/**
 * An event that indicates a test was cancelled because of some unmet precondition.
 *
 * <p>
 * A <em>canceled</em> test is one that was not able to run because of some unmet
 * precondition, such as a database not being present on the network. The test did
 * not fail or succeed, because it was not given a chance to run.
 * </p>
 */
public final class SkippedEvent extends Event {

    /**
     * Constructs a new <code>SkippedEvent</code> with passed fully qualified name, isModule flag, and selector.
     *
     * @param fullyQualifiedName the fully qualified name of a class that can rerun the suite or test
     *                           about which an event was fired
     * @param isModule indicates whether the fullyQualifiedName refers to a module (singleton object). If so, the
     *          fullyQualifiedName parameter does not include the trailing dollar sign.
     * @param selector additional information identifying the suite or test about which an event was fired
     *
     * @throws NullPointerException if <code>fullyQualifiedName</code> or <code>selector</code> is null.
     */
    public SkippedEvent(String fullyQualifiedName, boolean isModule, Selector selector) {
        super(fullyQualifiedName, isModule, selector);
    }
}
