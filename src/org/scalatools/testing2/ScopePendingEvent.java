package org.scalatools.testing2;

/**
 * Event that indicates a scope was pending.
 *
 * <p>
 * A <em>scope</em> is a named grouping of tests within a suite. For example, in the
 * following code the "A Stack" block is a scope:
 * </p>
 *
 * <pre>
 *  "A Stack" should {
 *    "be empty" in {
 *        // ...
 *    }
 *    pending // The rest of the "A Stack" scope is pending
 *  }
 * </pre>
 */
public class ScopePendingEvent implements Event {
}
