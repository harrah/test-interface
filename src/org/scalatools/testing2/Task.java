package org.scalatools.testing2;

/**
 * A task to (possibly) execute.
 *
 * <p>
 * The client  may decide whether or not to execute the task based on its tags.
 * A task can be any job, but is primarily intended for running tests and/or supplying more tasks
 * to the client. The two subtypes provide two ways in which a framework can supply more tasks
 * to the client. <code>ReturningTask</code> returns an array of Tasks (which can be empty if there's
 * no more work to do.) <code>NotifyingTask</code> notifies the client of new Tasks via a
 * passed <code>Notifier</code>.
 * </p>
 */
public interface Task {

    /**
     * Either executes tests and nested suites, or returns more tasks, or both.
     *
     * If parallel (passed to initRun) is false, then ScalaTest would return tasks that run everything
     * sequentially. If parallel is true, then ScalaTest would pass in a distributor that simply collects
     * things passed to the distributor, then returns one task for anything placed in that distributor
     * so that sbt can be responsible for parallelizing. Most often the tests directly defined in a
     * suite would be run in this case, but nested suites would be wrapped in a task and returned in
     * the array. If the suite mixes in ParallelTestExecution, though, then ScalaTest would also return
     * one task per test in the suite, so that sbt could parallelize the test execution too.
     */

    String[] getTags();
}