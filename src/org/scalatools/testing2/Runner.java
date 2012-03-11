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
     * Returns a task that when executed will run the test class whose name is passed as
     * <code>testClassName</code>.
     *
     * @param testClassName the fully qualified name of the test class to be run by the returned task
     * @return a task that when executed will run the test class whse name was passed
     * @throws IllegalStateException if invoked after <code>summarize</code> has been invoked.
     */
    public Task task(String testClassName /* NEED FINGERPERINT TO DIFF BETW Class & Obj */);

    /**
     * Returns a task that when executed will rerun failed tests and aborted suites based on the
     * passed test class name, failed test IDs, and aborted suite IDs.
     *
     * @param testClassName the fully qualified name of the test class to be run by the returned task
     * @param failedTestIds a possibly empty array of Test IDs for failed tests to rerun
     * @param abortedSuiteIds a possibly empty array of suite IDs for aborted suites to rerun
     * @return a task that when executed will run the passed test class
     * @throws IllegalStateException if invoked after <code>summarize</code> has been invoked.
     */
    public Task task(String testClassName, Selector[] selectors);
  // THIS needs to be -s, a possible -i, possible -ts, possibly more -is, etc.
    /**
     * Returns a test-framework specific summary string suitable for displaying to the user.
     *
     * <p>
     * If the passed <code>ansiCodesSupported</code> is false, the returned summary string should not
     * contain ANSI color commands. If true, the returned summary string may contain ANSI
     * color commands.
     * </p>
     *
     * <p>
     * The client can decide whether to actually show the summary string to the user.
     * For example, if only using one test framework, it user would probably prefer that the
     * client show the test-framework specific summary string, because it will look the same
     * as the summary they see when using the test framework directly (i.e., not through the
     * client). But if they are using multiple test frameworks, it may be better to show
     * a single, more general client-defined summary.
     * </p>
     *
     * <p>
     * The invocation of this method signals the end of the run. In addition to creating and
     * returning the summary string, the test framework should clean up any resources
     * associated with the run. The <code>Runner</code> is "spent" after <code>summarize</code> returns and
     * cannot be reused. Any subsequent invocations of a <code>task</code> method will be met with
     * <code>IllegalStateException</code>s.
     * </p>
     *
     * @param completionStatus indicates whether the run completed normally, or aborted or was
     *                         requested to stop (information which the test framework may use to
     *                         construct its summary string).
     * @param ansiCodesSupported indicates whether the summary string may contain ANSI color commands.
     *
     * @return a test-framework-specific string summarizing the test run
     */
    public String summarize(RunStatus completionStatus, boolean ansiCodesSupported);
}
    /*
    send expected test count? For progress bars? add a way to notify a reporter of an
    updated expected test count?

    Change the org.scalatools package name?

    Add a ThisJustInRevisedExpectedTestCount event.
    ExpectedTestCountUpdated

    Thanks Jon-Anders Teigen
        */