package org.scalasbt.testing;

/**
 * Represents one run of a suite of tests.
 *
 * <p>
 * The run represented by a <code>Runner</code> has a lifecycle. The run begins when the
 * <code>Runner</code> is instantiated by the framework and returned to the client during
 * a <code>Framework.runner</code> invocation. The run continues until the client
 * invokes <code>done</code> on the <code>Runner</code>. Before invoking <code>done</code>,
 * the client can invoke the <code>task</code> methods as many times at it wants, but once
 * <code>done</code> has been invoked, the <code>Runner</code> enters "spent" mode. Any
 * subsequent invocations of <code>task</code> methods will be met with an
 * <code>IllegalStateException</code>.
 * </p>
 */
public interface Runner 
{

	/**
	 * Returns a task that when executed will run the test class whose name is passed as
	 * <code>fullyQualifiedName</code>.
	 *
	 * <p>
	 * The client can use this method to obtain tasks that will run test classes discovered
	 * via a <code>Fingerprint</code>.
	 * </p>
	 *
	 * @param fullyQualifiedName the fully qualified name of the test class to be run by the returned task
	 * @param fingerprint the fingerprint that was used to discover this class
	 * @return a task that when executed will run the test class whose name was passed
	 * @throws IllegalStateException if invoked after <code>done</code> has been invoked.
	 */
	public Task task(String fullyQualifiedName, Fingerprint fingerprint);

	/**
	 * Returns a task that when executed will run tests and suites determined by the
	 * passed test class name and selectors.
	 *
	 * @param fullyQualifiedName the fully qualified name of the test class to be run by the returned task
	 * @param isModule indicates whether this was a module (singleton object). If so, the fullyQualifiedName parameter does not include the trailing dollar sign
	 * @param selectors a possibly empty array <code>Selectors</code> determining suites and tests to run
	 * @return a task that when executed will run the selected test and/or suite "members" of the passed test class
	 * @throws IllegalStateException if invoked after <code>done</code> has been invoked.
	 */
	public Task task(String fullyQualifiedName, boolean isModule, Selector[] selectors);

	/**
	 * Indicates the client is done with this <code>Runner</code> instance.
	 *
	 * <p>
	 * After invoking the <code>done</code> method on a <code>Runner</code> instance, the client should no
	 * longer invoke the <code>task</code> methods on that instance. (If the client does invoke <code>task</code>
	 * after <code>done</code>, it will be rewarded with an <code>IllegalStateException</code>.
	 * </p>
	 *
	 * <p>
	 * Similarly, after returning from <code>done</code>, the test framework should no longer write
	 * any messages to the <code>Logger</code>, nor fire any more events to the <code>EventHandler</code>,
	 * passed to <code>Framework.runner</code>. If the test framework has not completed writing log messages
	 * or firing events when the client invokes <code>done</code>, the framework should not return from
	 * <code>done</code> until it is finished sending messages and events, and may block the thread
	 * that invoked <code>done</code> until it is actually done.
	 * </p>
	 *
	 * <p>
	 * In short, by invoking <code>done</code>, the client indicates it is done invoking the <code>task</code>
	 * methods for this run. By returning from <code>done</code>, the test framework indicates it is done writing
	 * log messages and firing events for this run.
	 * </p>
	 *
	 * <p>
	 * If the client invokes <code>done</code> more than once on the same <code>Runner</code> instance, the test
	 * framework should on subsequent invocations should throw <code>IllegalStateException</code>.
	 * </p>
	 *
	 * <p>
	 * The test framework may send a summary (i.e., a message giving total tests succeeded, failed, and
	 * so on) to the user via a log message. If so, it should return
	 * <code>true</code> from <code>done</code>. If not, it should return <code>false</code>. The client
	 * may use the return value of <code>done</code> to decide whether to display its own summary message.
	 * </p>
	 *
	 * <p>
	 * The test framework may return an array of string (i.e., a message giving total tests succeeded, failed and
	 * so on) to sbt.  sbt can then print it out, or in case of multiple test frameworks is running, sbt will
	 * ignore it and print using its own summary.
	 * </p>
	 *
	 * @return array of string for sbt to print out as summary
	 */
	public String[] done();

	/**
	 * Remote args that will be passed to Runner in sub-process as remoteArgs.
	 *
	 * @return an array of argument that will be passed to Runner in sub-process as remoteArgs.
	 */
	public String[] remoteArgs();

	/**
	 * Return arguments that is used to create this Runner.
	 *
	 * @return an array of argument that is used to create this Runner.
	 */
	public String[] args();
}
