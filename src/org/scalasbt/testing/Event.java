package org.scalasbt.testing;

/**
 * An Event fired by the test framework during a run.
 */
public abstract class Event {

    private String fullyQualifiedName;
    private boolean isModule;
    private Selector selector;

    /**
     * Constructs a new <code>Event</code> with passed fully qualified name, isModule flag, and selector.
     *
     * @param fullyQualifiedName the fully qualified name of a class that can rerun the suite or test
     *                           about which an event was fired
     * @param isModule indicates whether the fullyQualifiedName refers to a module (singleton object). If so, the
     *          fullyQualifiedName parameter does not include the trailing dollar sign.
     * @param selector additional information identifying the suite or test about which an event was fired
     *
     * @throws NullPointerException if <code>fullyQualifiedName</code> or <code>selector</code> is null.
     */
    public Event(String fullyQualifiedName, boolean isModule, Selector selector) {
        if (fullyQualifiedName == null) {
            throw new NullPointerException("fullyQualifiedName was null");
        }
        if (selector == null) {
            throw new NullPointerException("selector was null");
        }
        this.fullyQualifiedName = fullyQualifiedName;
        this.isModule = isModule;
        this.selector = selector;
    }

    /**
     * The fully qualified test class name about which an event was fired.
     *
     * @return the fully qualified test class name
     */
    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    /**
     * Indicates whether the fullyQualifiedName refers to a module (singleton object). If so, the
     *          fullyQualifiedName parameter does not include the trailing dollar sign.
     *
     * @return true if the fullyQualifiedName refers to a module instead of a class
     */
    public boolean isModule() {
        return isModule;
    }

    /**
     * A <code>Selector</code> that can be used to identify the suite or test about which an event was fired.
     *
     * @return the fully qualified test class name
     */
    public Selector getSelector() {
        return selector;
    }
}

