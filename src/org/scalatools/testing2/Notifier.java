package org.scalatools.testing2;

/**
 * An object into which a <em>notifying task</em> can place other tasks to execute.
 */
public interface Notifier {

    /**
     * Notifies the client of a new task to execute.
     *
     * @param task a new task to execute
     */
    void put(Task task);
}