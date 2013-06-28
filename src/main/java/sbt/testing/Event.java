package sbt.testing;

/**
 * An event fired by the test framework during a run.
 */
public interface Event {

  /**
   * The fully qualified name of a class that can rerun the suite or test
   * about which an event was fired.
   */
  String fullyQualifiedName();

  /**
   * The fingerprint of the test class whose fully qualifed name is returned by the <code>fullyQualifiedName</code>
   * method on this <code>Event</code>. If the <code>isModule</code> method of the fingerprint indicates that the
   * <code>fullyQualifiedName</code> refers to a module (singleton object), the
   * <code>fullyQualifiedName</code> string does not include the trailing dollar sign.
   */
  Fingerprint fingerprint();

  /**
   * Additional information identifying the suite or test about which an event was fired.
   */
  Selector selector();

  /**
   * Indicates whether the event represents a test success, failure, error, skipped, ignored, canceled, pending.
   */
  Status status();

  /**
   * An <a href="OptionalThrowable.html"><code>OptionalThrowable</code></a> associated with this <code>Event</code>.
   */
  OptionalThrowable throwable();

  /**
   * An amount of time, in milliseconds, that was required to complete the action reported by this event, or -1, if no duration was available.
   */
  long duration();
}

