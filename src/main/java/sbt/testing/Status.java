package sbt.testing;

/**
 * Represents the status of running a test. Test frameworks can decided which of these to
 * use and what they mean, but in general, the intended meanings are:
 *
 * <ul>
 * <li>Success - a test succeeded</li>
 * <li>Error - an "error" occurred during a test</li>
 * <li>Failure - an "failure" during a test</li>
 * <li>Skipped - a test was skipped for any reason</li>
 * <li>Ignored - a test was ignored, <em>i.e.</em>, temporarily disabled with the intention of fixing it later</li>
 * <li>Canceled - a test was canceled, <em>i.e.</em>, not able to be completed because of some unmet pre-condition, such as a database being offline that the test requires</li>
 * <li>Pending - a test was declared as pending, <em>i.e.</em>, with test code and/or production code as yet unimplemented </li>
 * </ul>
 *
 * <p>
 * The difference between errors and failures, if any, is determined by the test frameworks.
 * JUnit and specs2 differentiate between errors and failures. ScalaTest reports everything (both assertion failures and unexpected errors) as failures.
 * JUnit and ScalaTest support ignored tests. ScalaTest and specs2 support a notion of pending tests. ScalaTest differentiates between ignored and
 * canceled tests, whereas specs2 only supports skipped tests, which are implemented like ScalaTest's canceled tests. TestNG uses "skipped" to report tests
 * that were not executed because of failures in dependencies, which is also similar to canceled tests in ScalaTest.
 * </p>
 */
public enum Status {

  /**
   * Indicates a test succeeded.
   */
  Success,

  /**
   * Indicates an "error" occurred.
   */
  Error,

  /**
   * Indicates a "failure" occurred.
   */
  Failure,

  /**
   * Indicates a test was skipped.
   */
  Skipped,

  /**
   * Indicates a test was ignored.
   */
  Ignored,

  /**
   * Indicates a test was canceled.
   */
  Canceled,

  /**
   * Indicates a test was declared as pending.
   */
  Pending
}


