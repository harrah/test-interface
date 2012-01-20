package org.scalatools.testing2;

public interface AsyncTask extends Task {

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

    void execute(Distributor distributor);
}
