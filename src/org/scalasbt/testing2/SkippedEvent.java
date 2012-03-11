package org.scalasbt.testing2;

/**
 * An event that indicates a test was cancelled because of some unmet precondition.
 *
 * <p>
 * A <em>canceled</em> test is one that was not able to run because of some unmet
 * precondition, such as a database not being present on the network. The test did
 * not fail or succeed, because it was not given a chance to run.
 * </p>
 */
public class SkippedEvent implements Event {
    // namme or test name etc and class name actaully put that in event
}
