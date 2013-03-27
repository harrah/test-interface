package org.scalasbt.testing;

/**
 * Interface implemented by clients that handle events fired by the test framework
 * during a run.
 *
 * <p>
 * An event handler is passed to the test framework via the <code>runner</code> method
 * in <code>Framework</code>.
 * </p>
 */
public interface EventHandler 
{

	/**
	 * Handle an event.
	 *
	 * @param event the event to handle
	 */
	public void handle(Event event);
}
