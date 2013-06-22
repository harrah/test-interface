package sbt.testing;

/**
 * Information in addition to a test class name that identifies a nested suite about which an
 * event was fired.
 */
public final class NestedSuiteSelector extends Selector {

  private String _suiteId;

  /**
   * Constructs a new <code>NestedSuiteSelector</code> with given <code>suiteId</code>.
   *
   * @param suiteId the id of the nested suite
   */
  public NestedSuiteSelector(String suiteId) {
    if (suiteId == null) {
      throw new NullPointerException("suiteId was null");
    }
    _suiteId = suiteId;
  }

  /**
   * An id that, in addition to a test class name, identifies a nested suite about which an
   * event was fired.
   *
   * @return the id of the nested suite
   */
  public String suiteId() {
    return _suiteId;
  }

  @Override public boolean equals(Object o) {
    boolean retVal = false;
    if (o instanceof NestedSuiteSelector) {
      NestedSuiteSelector nss = (NestedSuiteSelector) o;
      retVal = nss._suiteId == _suiteId;
    }
    return retVal;
  }

  @Override public int hashCode() {
    return _suiteId.hashCode();
  }

  @Override public String toString() {
    return "NestedSuiteSelector(" + _suiteId + ")";
  }
}
