package sbt.testing;

/**
 * Returns a task that when executed will run tests and suites determined by the
 * passed test class name, fingerprints, "explicitly specified" flag, and selectors.
 *
 * <p>
 * "Explicitly specified" means the user supplied a complete fully qualified test name, such as with the command:
 * </p>
 *
 * <pre>
 * &gt; test-only <code>com.mycompany.myproject.WholeNameSpec</code>
 * </pre>
 *
 * <p>
 * as opposed to commands like:
 * </p>
 * 
 * <pre>
 * &gt; test-only <code>*WholeNameSpec</code>
 * </pre>
 *
 * <p>
 * or simply:
 * </p>
 * 
 * <pre>
 * &gt; test
 * </pre>
 *
 * <p>
 * The <code>explicitlySpecified</code> flag will be true for in the first case, and false in the last two cases, because only
 * in the first case was the fully qualified test class name completely specified by the user. The test framework can use this information
 * to decide whether to ignore an annotation requesting a class not be discovered.
 * </p>
 *
 * <p>
 * The <code>fingerprint</code> parameter indicates how the test suite was identified as a test suite. This <code>task</code>
 * method may be called with the same value for <code>testClassName</code> but different fingerprints.  For example, if both a
 * class and its companion object were test classes, this method would be called with the same name but with a different value
 * for <code>fingerprint.isModule</code>.
 * </p>
 *
 * <p>
 * A test framework may "reject" a requested task by returning a <code>Task</code> that does nothing.
 * </p>
 *
 * @param fullyQualifiedName the fully qualified name of the test class to be run by the returned task
 * @param fingerprint indicates how the test suite was identified as a test suite.
 * @param explicitlySpecified indicates whether the test class is explicitly specified by user.
 * @param selectors a possibly empty array <code>Selectors</code> determining suites and tests to run
 * @return a task that when executed will run the selected test and/or suite "members" of the passed test class
 * @throws IllegalStateException if invoked after <code>done</code> has been invoked.
 */
public class TaskDef {

  private String _fullyQualifiedName;
  private Fingerprint _fingerprint;
  private boolean _explicitlySpecified;
  private Selector[] _selectors;

  // TODO: Check for null and throw NPE
  TaskDef(String fullyQualifiedName, Fingerprint fingerprint, boolean explicitlySpecified, Selector[] selectors) {

    if (fullyQualifiedName == null) {
      throw new NullPointerException("fullyQualifiedName was null");
    }
    if (fingerprint == null) {
      throw new NullPointerException("fingerprint was null");
    }
    if (selectors == null) {
      throw new NullPointerException("selectors was null");
    }

    this._fullyQualifiedName = fullyQualifiedName;
    this._fingerprint = fingerprint;
    this._explicitlySpecified = explicitlySpecified;
    this._selectors = selectors;
  }

  public String fullyQualifiedName() {
    return _fullyQualifiedName;
  }

  public Fingerprint fingerprint() {
    return _fingerprint;
  }

  public boolean explicitlySpecified() {
    return _explicitlySpecified;
  }

  public Selector[] selectors() {
    return _selectors;
  }
}
