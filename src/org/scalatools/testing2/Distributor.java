package org.scalatools.testing2;

/**
 * An object into which a <em>notifying task</em> can place other tasks to (possibly) execute.
 *
 * <p>
 * The client may decide whether or not to execute the task based on its tags.
 * </p>
 */
public interface Distributor {

    /**
     * Notifies the distributor of a task to (possibly) execute.
     *
     * @param task a task to run
     */
    void put(Task task);
}