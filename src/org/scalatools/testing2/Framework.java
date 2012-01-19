package org.scalatools.testing2;

public interface Framework {

    /**
     * The name of the test framework that this object represents.
     * It is intended to be a human readable label.
     */
    public String name();

    /**
     * Specifies how to identify classes that are tests.
     */
    public Fingerprint[] tests();

    /**
     * Initiates a run with passed args. The frameworks enters "run mode". Parallel
     * indicates whether it is a parallel. Should only be called when the framework
     * is in "ready mode."
     */
    public Runner testRunner(
            String[] args,
            ClassLoader testClassLoader,
            EventHandler eventHandler,
            Logger[] loggers,
            Boolean parallel
    );
}
