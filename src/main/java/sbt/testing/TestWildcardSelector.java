package sbt.testing;

/**
 * Information that identifies zero to many tests directly contained in a test class.
 *
 * <p>
 * The <code>testWildcard</code> is a simple string, <em>i.e.</em>, not a glob or regular expression.
 * Any test whose name includes the <code>testWildcard</code> string as a substring will be selected.
 * </p>
 */
public final class TestWildcardSelector extends Selector {

  private String testWildcard;

  /**
   * Constructs a new <code>TestSelector</code> with passed <code>testWildcard</code>.
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
    this.testWildcard = testWildcard;
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
  public String getTestWildcard() {
    return testWildcard;
  }
}

