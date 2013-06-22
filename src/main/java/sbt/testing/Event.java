package sbt.testing;

/**
 * An event fired by the test framework during a run.
 */
public interface Event {

  /**
   * The fully qualified name of a class that can rerun the suite or test
   *     about which an event was fired. This method should never return <code>null</code>.
   */
  String fullyQualifiedName();

  /**
   * The fingerprint of the test class whose fully qualifed name is returned by the <code>fullyQualifiedName</code>
         *     method on this <code>Event</code>. If the <code>isModule</code> method of the fingerprint indicates that the
         *     <code>fullyQualifiedName</code> refers to a module (singleton object), the
   *     <code>fullyQualifiedName</code> string does not include the trailing dollar sign.
   */
  Fingerprint fingerprint();

  /**
   * Additional information identifying the suite or test about which an event was fired. This
   * method should never return <code>null</code>.
   */
  Selector selector();

  /**
   * Indicates whether the event represents a test failure, error, success, or skip. This method should
   * never return <code>null</code>.
   */
  Status status();

  /**
   * A <code>Throwable</code> associated with this <code>Event</code>,
   *     or <code>null</code> if no <code>Throwable</code> is associated with this event.
   */
  Throwable throwable();
}

