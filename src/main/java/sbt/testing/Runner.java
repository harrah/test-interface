package sbt.testing;

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
public interface Runner {

  /**
   * Returns a task that when executed will run tests and suites determined by the
   * passed test class name, fingerprints, "explicitly specified" flag, and selectors.
   *
   * <p>
   * "Explicitly specified" means the user supplied a complete fully qualified test name, such as with the command:
   * </p>
   *
   * <pre>
   * &gt; test-only <code>com.mycompany.myproject.WholeNameSpec</code>
   * </pre>
   *
   * <p>
   * as opposed to commands like:
   * </p>
   * 
   * <pre>
   * &gt; test-only <code>*WholeNameSpec</code>
   * </pre>
   *
   * <p>
   * or simply:
   * </p>
   * 
   * <pre>
   * &gt; test
   * </pre>
   *
   * <p>
   * The <code>explicitlySpecified</code> flag will be true for in the first case, and false in the last two cases, because only
   * in the first case was the fully qualified test class name completely specified by the user. The test framework can use this information
   * to decide whether to ignore an annotation requesting a class not be discovered.
   * </p>
   *
   * <p>
   * The <code>fingerprint</code> parameter indicates how the test suite was identified as a test suite. This <code>task</code>
   * method may be called with the same value for <code>testClassName</code> but different fingerprints.  For example, if both a
   * class and its companion object were test classes, this method would be called with the same name but with a different value
   * for <code>fingerprint.isModule</code>.
   * </p>
   *
   * <p>
   * A test framework may "reject" a requested task by returning a <code>Task</code> that does nothing.
   * </p>
   *
   * @param fullyQualifiedName the fully qualified name of the test class to be run by the returned task
   * @param fingerprint indicates how the test suite was identified as a test suite.
   * @param explicitlySpecified indicates whether the test class is explicitly specified by user.
   * @param selectors a possibly empty array <code>Selectors</code> determining suites and tests to run
   * @return a task that when executed will run the selected test and/or suite "members" of the passed test class
   * @throws IllegalStateException if invoked after <code>done</code> has been invoked.
   */
  public Task[] tasks(TaskDef[] taskDefs);

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
   * so on) to the user via a log message. If so, it should return the summary from <code>done</code>.
     * If not, it should return an empty string. The client may use the return value of <code>done</code>
     * to decide whether to display its own summary message.
   * </p>
   *
   * <p>
   * The test framework may return a multi-lines string (i.e., a message giving total tests succeeded, failed and
   * so on) to sbt
   * </p>
   *
   * @return string for sbt to print out as summary
   */
  public String done();

  /**
   * Remote args that will be passed to Runner in sub-process as remoteArgs.  This method must not return null.
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
