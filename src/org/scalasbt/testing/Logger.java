package org.scalasbt.testing;

/**
 * A logger through which to provide feedback to the user about a run.
 *
 * <p>
 * The difference between the event handler and the logger is that the event handler is
 * for events intended to be consumed by the client software whereas the logger is
 * for messages intended to be consumed by the client *user* (i.e., a human).
 * </p>
 */
public interface Logger
{
    /**
     * True if ANSI color codes are understood by this instance.
     */
    public boolean ansiCodesSupported();

    /**
     * Provide an error message.
     *
     * @param msg the error message
     */
    public void error(String msg);

    /**
     * Provide an warning message.
     *
     * @param msg the warning message
     */
    public void warn(String msg);

    /**
     * Provide an info message.
     *
     * @param msg the info message
     */
    public void info(String msg);

    /**
     * Provide an debug message.
     *
     * @param msg the debug message
     */
    public void debug(String msg);

    /**
     * Provide a stack trace
     *
     * @param t the <code>Throwable</code> containing the stack trace being logged
     */
    public void trace(Throwable t);
}
