package org.scalatools.testing2;

/**
 * Event indicating a suite completed normally.
 *
 * <p>
 * A suite completes normally unless it aborts because of an error (other
 * than a failed test). A suite can contain failing tests and still complete
 * normally.
 * </p>
 */
public class SuiteCompletedEvent implements Event {
}
