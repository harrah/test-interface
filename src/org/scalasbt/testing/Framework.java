package org.scalasbt.testing;

/**
 * Interface implemented by test frameworks.
 */
public interface Framework {

    /**
     * The name of the test framework that this object represents.
     * It is intended to be a human readable label.
     */
    public String name();

    /**
     * An array of <code>Fingerprint</code> that specify how to identify test classes during
     * discovery.
     */
    public Fingerprint[] fingerprints();

    /**
     * Initiates a run.
     *
     * <p>
     * If a client invokes this method before a previously initiated run has completed,
     * the test framework may throw <code>IllegalStateException</code>to indicate it
     * cannot perform the two runs concurrently.
     * </p>
     * @param args the test-framework-specific arguments for the new run
     * @param testClassLoader a class loader to use when loading test classes during the run
     * @param eventHandler an event handler to which to fire events during the run
     * @param loggers an array of loggers to which to emit log messages during the run
     *
     * @return a <code>Runner</code> representing the newly started run.
     * @throws IllegalStateException if the test framework is unable to initiate a run because it is
     *            already performing a previously initiated run that has not yet completed.
     */
    public Runner runner(
            String[] args,
            ClassLoader testClassLoader,
            EventHandler eventHandler,
            Logger[] loggers
    );
}

