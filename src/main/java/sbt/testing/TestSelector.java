package sbt.testing;

/**
 * Information in addition to a test class name that identifies a test directly contained in the suite
 * whose class had the fully qualified name specified as the <code>fullyQualifiedName</code> attribute
 * passed to the event.
 */
public final class TestSelector extends Selector {

  private String _testName;

  /**
   * Constructs a new <code>TestSelector</code> with passed <code>testName</code>.
   *
   * @param testName the name of the test about which an event as fired.
   */
  public TestSelector(String testName) {
    if (testName == null) {
      throw new NullPointerException("testName was null");
    }
    _testName = testName;
  }

  /**
   * The name of a test about which an event was fired.
   *
   * @return the name of the test
   */
  public String testName() {
    return _testName;
  }

  @Override public boolean equals(Object o) {
    boolean retVal = false;
    if (o instanceof TestSelector) {
      TestSelector ts = (TestSelector) o;
      retVal = ts._testName == _testName;
    }
    return retVal;
  }

  @Override public int hashCode() {
    return _testName.hashCode();
  }
}

