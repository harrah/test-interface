package sbt.testing;

/**
 * A task to execute.
 *
 * <p>
 * The client may decide when or how to execute the task based on its tags.
 * A task can be any job, but is primarily intended for running tests and/or supplying more tasks
 * to the client. A framework can supply more tasks
 * to the client in the returned an array of Tasks (which can be empty if there's
 * no more work to do.)
 * </p>
 */
public interface Task 
{

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

	/**
	 * Execute a task, possibly returning to the client new tasks to execute.
	 * @param eventHandler an event handler to which to fire events during the run
	 * @param loggers an array of loggers to which to emit log messages during the run
	 * @return a possibly empty array of new tasks for the client to execute
	 */
	Task[] execute(EventHandler eventHandler, Logger[] loggers);
}