package sbt.testing;

import java.io.Serializable;

/**
 * Indicates an event was about the entire suite whose class had the fully qualified name specified as
 * the <code>fullyQualifiedName</code> attribute the event.
 */
public final class SuiteSelector extends Selector implements Serializable {

  @Override public boolean equals(Object o) {
    return o instanceof SuiteSelector;
  }

  @Override public int hashCode() {
    return 29;
  }

  @Override public String toString() {
    return "SuiteSelector";
  }
}
