package sbt.testing;

/**
 * Information in addition to a test class name that identifies a test in a nested suite about which an
 * event was fired.
 */
public final class NestedTestSelector extends Selector {

  private String _suiteId;
  private String _testName;

  /**
   * Constructs a new <code>NestedSuiteSelector</code> with given <code>suiteId</code> and <code>testName</code>.
   *
   * @param suiteId the id of the nested suite containing the test
   * @param testName the name of the test
   */
  public NestedTestSelector(String suiteId, String testName) {
    if (suiteId == null) {
      throw new NullPointerException("suiteId was null");
    }
    if (testName == null) {
      throw new NullPointerException("testName was null");
    }
    _suiteId = suiteId;
    _testName = testName;
  }

  /**
   * An id that, in addition to a test class name, identifies a nested suite that contains a test
   * about which an event was fired.
   *
   * @return the id of the nested suite containing the test
   */
  public String suiteId() {
    return _suiteId;
  }

  /**
   * The name of the test in a nested suite about which an event was fired.
   *
   * @return the name of the test in the nested suite identified by the id returned by <code>suiteId</code>.
   */
  public String testName() {
    return _testName;
  }

  @Override public boolean equals(Object o) {
    boolean retVal = false;
    if (o instanceof NestedTestSelector) {
      NestedTestSelector nts = (NestedTestSelector) o;
      retVal =
        nts._suiteId.equals(_suiteId) && 
        nts._testName.equals(_testName);
    }
    return retVal;
  }

  @Override public int hashCode() {
    int retVal = 17;
    retVal = 31 * retVal + _suiteId.hashCode();
    retVal = 31 * retVal + _testName.hashCode();
    return retVal;
  }

  @Override public String toString() {
    return "NestedTestSelector(" + _suiteId + ", " + _testName + ")";
  }
}
