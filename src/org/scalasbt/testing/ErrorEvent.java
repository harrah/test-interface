package org.scalasbt.testing;

/**
 * An event that indicates an error occurred.
 *
 * <p>
 * Implementing test frameworks can decide how to differentiate between "failures" and
 * "errors." JUnit reports assertion failures as "failures," and any other problems as "errors,"
 * so many users may expect these meanings.
 * </p>
 */
public final class ErrorEvent extends Event {

    private Throwable throwable;

    /**
     * Constructs a new <code>ErrorEvent</code> with passed fully qualified name, isModule flag, selector,
     * and <code>Throwable</code>.
     *
     * <p>
     * The passed <code>Throwable</code> may not be null. If you wish to indicate no <code>Throwable</code> is
     * associated with this event, you must use the other constructor.
     * </p>
     *
     * @param fullyQualifiedName the fully qualified name of a class that can rerun the suite or test
     *                           about which an event was fired
     * @param isModule indicates whether the fullyQualifiedName refers to a module (singleton object). If so, the
     *          fullyQualifiedName parameter does not include the trailing dollar sign.
     * @param selector additional information identifying the suite or test about which an event was fired
     * @param throwable a <code>Throwable</code> associated with this <code>ErrorEvent</code>,
     *                  or <code>null</code> if no <code>Throwable</code> is associated with this event.
     *
     * @throws NullPointerException if <code>fullyQualifiedName</code>, <code>selector</code>, or
     *     <code>throwable</code> is null.
     */
    public ErrorEvent(String fullyQualifiedName, boolean isModule, Selector selector, Throwable throwable) {
        super(fullyQualifiedName, isModule, selector);
        if (throwable == null) {
            throw new NullPointerException("throwable was null");
        }
        this.throwable = throwable;
    }

    /**
     * Constructs a new <code>ErrorEvent</code> with passed fully qualified name, isModule flag, selector,
     * and a <code>null</code> <code>Throwable</code>.
     *
     * @param fullyQualifiedName the fully qualified name of a class that can rerun the suite or test
     *                           about which an event was fired
     * @param isModule indicates whether the fullyQualifiedName refers to a module (singleton object). If so, the
     *          fullyQualifiedName parameter does not include the trailing dollar sign.
     * @param selector additional information identifying the suite or test about which an event was fired
     *
     * @throws NullPointerException if <code>fullyQualifiedName</code> or <code>selector</code>is null.
    */
    public ErrorEvent(String fullyQualifiedName, boolean isModule, Selector selector) {
        super(fullyQualifiedName, isModule, selector);
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
