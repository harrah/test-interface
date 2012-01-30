package org.scalatools.testing2;

/**
 * An enum for the different run completion statuses.
 *
 * <p>
 * A <code>RunStatus</code> is passed to the <code>summarize</code> method of <code>Runner</code>.
 * </p>
 */
public enum RunStatus {
    Completed, Aborted, Stopped
}