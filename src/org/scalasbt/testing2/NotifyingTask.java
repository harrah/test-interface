package org.scalasbt.testing2;

/**
 * A task that notifies the new client of new tasks to execute through a <code>Notifier</code> passed
 * to its <code>execute</code> method.
 */
public interface NotifyingTask extends Task {

    /**
     * Execute a task, possibly notifying the client of new tasks via the
     * passed <code>Notifier</code>.
     *
     * @param notifier a <code>Notifier</code> through which to notify the client of more
     *                    tasks to execute
     */
    void execute(Notifier notifier);
}          // DROP
/*
 Note: If parallel (passed to Framework.testRunner) is false, then ScalaTest would return tasks
 that run everything sequentially. If parallel is true, then ScalaTest would pass in a Distributor
 that provides the client through the Notifier one new task for each suite placed in that distributor
 so that the client can be responsible for parallelizing. Most often the tests directly defined in a
 suite would be run in this case, but nested suites would be wrapped in a task and passed to the
 notifier. If the suite mixes in ParallelTestExecution, though, then ScalaTest would also return
 one task per test in the suite, so that the client could parallelize the test execution too.
*/