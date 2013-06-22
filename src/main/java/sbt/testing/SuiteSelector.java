package sbt.testing;

/**
 * Indicates an event was about the entire suite whose class had the fully qualified name specified as
 * the <code>fullyQualifiedName</code> attribute the event.
 */
public final class SuiteSelector extends Selector {

  @Override public boolean equals(Object o) {
    return o instanceof SuiteSelector;
  }

  @Override public int hashCode() {
    return 29;
  }
}
