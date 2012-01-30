package org.scalatools.testing2;

/**
 * A task to execute.
 *
 * <p>
 * The client may decide when or how to execute the task based on its tags.
 * A task can be any job, but is primarily intended for running tests and/or supplying more tasks
 * to the client. The two subtypes provide two ways in which a framework can supply more tasks
 * to the client. <code>ReturningTask</code> returns an array of Tasks (which can be empty if there's
 * no more work to do.) <code>NotifyingTask</code> notifies the client of new tasks via a
 * passed <code>Notifier</code>.
 * </p>
 */
public interface Task {

    /**
     * A possibly zero length array of string tags associated with this task.
     *
     * <p>
     * A task may be tagged, for example, with a string that indicates it consumes a lot
     * of CPU time. Users can configure the client to only run, say, three such CPU-intensive
     * tasks concurrently.
     * </p>
     *
     * @return a possibly zero length string array of this task's tags
     */
    String[] tags();
}