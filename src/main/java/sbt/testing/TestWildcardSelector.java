package sbt.testing;

import java.io.Serializable;

/**
 * Information that identifies zero to many tests directly contained in a test class.
 *
 * <p>
 * The <code>testWildcard</code> is a simple string, <em>i.e.</em>, not a glob or regular expression.
 * Any test whose name includes the <code>testWildcard</code> string as a substring will be selected.
 * </p>
 */
public final class TestWildcardSelector extends Selector implements Serializable {

  private String _testWildcard;

  /**
   * Constructs a new <code>TestWildcardSelector</code> with passed <code>testWildcard</code>.
   *
   * <p>
   * The <code>testWildcard</code> is a simple string, <em>i.e.</em>, not a glob or regular expression.
   * Any test whose name includes the <code>testWildcard</code> string as a substring will be selected.
   * </p>
   *
   * @param testWildcard a string used to select tests.
   */
  public TestWildcardSelector(String testWildcard) {
    if (testWildcard == null) {
      throw new NullPointerException("testWildcard was null");
    }
    _testWildcard = testWildcard;
  }

  /**
   * A test wildcard string used to select tests.
   *
   * <p>
   * The <code>testWildcard</code> is a simple string, <em>i.e.</em>, not a glob or regular expression.
   * Any test whose name includes the <code>testWildcard</code> string as a substring will be selected.
   * </p>
   *
   * @return the test wildcard string used to select tests.
   */
  public String testWildcard() {
    return _testWildcard;
  }

  @Override public boolean equals(Object o) {
    boolean retVal = false;
    if (o instanceof TestWildcardSelector) {
      TestWildcardSelector tws = (TestWildcardSelector) o;
      retVal = tws._testWildcard == _testWildcard;
    }
    return retVal;
  }

  @Override public int hashCode() {
    return _testWildcard.hashCode();
  }

  @Override public String toString() {
    return "TestWildcardSelector(" + _testWildcard + ")";
  }
}

