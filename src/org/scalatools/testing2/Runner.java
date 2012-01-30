package org.scalatools.testing2;

/**
 * Represents one run of a suite of tests.
 *
 * <p>
 * The run represented by a <code>Runner</code> has a lifecycle. The run begins when the
 * <code>Runner</code> is instantiated by the framework and returned to the client during
 * a <code>Framework.testRunner</code> invocation. The run continues until the client
 * invokes <code>summarize</code> on the <code>Runner</code>. Before invoking <code>summarize</code>,
 * the client can invoke the <code>task</code> methods as many times at it wants, but once
 * <code>summarize</code> has been invoked, the <code>Runner</code> enters "spent" mode. Any
 * subsequent invocations of <code>task</code> methods will be met with an
 * <code>IllegalStateException</code>.
 * </p>
 */
public interface Runner {

    /**
     * Gets a task that will execute one test class, possibly returning more tasks.
     * (We don't need the fingerprint in ScalaTest. If no one else needs it, perhaps 
     * we should drop it.) Should only be called during "run mode."
     */

    // This one can be used to just run discovered test classes

    /**
     * Returns a task to run the passed test class name.
     *
     * @param testClassName the fully qualified name of the test class to be run by the returned task
     * @return a task that when executed will run the passed test class
     */
    public Task task(String testClassName);

    // This one can be used to rerun failed tests
    // And this one to rerun aborted suites
    /**
     * Returns a task to rerun failed tests based on the the passed test class name, failed test IDs,
     * and suite aborted IDs.
     *
     * @param testClassName the fully qualified name of the test class to be run by the returned task
     * @return a task that when executed will run the passed test class
     */
    public Task task(String testClassName, TestId[] failedTestIds, String[] abortedSuiteIds);


    /**
     * Returns a summary string, a string suitable for displaying to the user. sbt can decide
     * whether to use the string summary and show that to the user.
     * For example, if only using ScalaTest, better to show the
     * ScalaTest summary. But if they are using multiple test frameworks,
     * better to show the sbt summary.
     *
     * At this time the test framework should clean up any resources
     * associated with the run, so sbt should only call it once
     * the run is completed. Runner is defunct after summarize returns and
     * cannot be reused.
     */
    // Have logger, passed to testRunner method of Framework, so can decide whether
    // to return  string with ansi color codes in it or not.
    public String summarize(RunStatus status);
}
