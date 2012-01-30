package org.scalatools.testing2;

/**
 * A task that may return from its <code>execute</code> method new tasks for the client
 * to execute.
 */
public interface ReturningTask extends Task {

    /**
     * Execute a task, possibly returning to the client new tasks to execute.
     *
     * @return a possibly empty array of new tasks for the client to execute
     */
    Task[] execute();
}
