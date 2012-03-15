package org.scalasbt.testing;

/**
 * Information in addition to a test class name that identifies the suite or test about which an
 * event was fired.
 *
 * <p>
 * This class has four subtypes:
 * </p>
 *
 * <ul>
 * <li><code>SuiteSelector</code> - indicates an event is about an entire suite of tests whose
 * class was reported as <code>fullyQualifiedName</code> in the <code>Event</code></li>
 * <li><code>TestSelector</code> - indicates an event is about a single test directly contained
 * in the suite whose class was reported as <code>fullyQualifiedName</code> in the <code>Event</code></li>
 * <li><code>NestedSuiteSelector</code> - indicates an event is about an entire suite of tests whose
 * class was reported as <code>fullyQualifiedName</code> in the <code>Event</code></li>
 * <li><code>NestedTestSelector</code> - indicates an event is about a single test directly contained
 * in the suite whose class was reported as <code>fullyQualifiedName</code> in the <code>Event</code></li>
 * </ul>
 */
abstract public class Selector {
}
