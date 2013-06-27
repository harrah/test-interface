package sbt.testing;

import java.util.Arrays;
import java.io.Serializable;

/**
 * A bundle of information used to request a <code>Task</code> from a test framework.
 * 
 * <p>
 * An array of <code>TaskDef</code> is passed to <a href="Runner.html"><code>Runner</code></a>'s <code>tasks</code> method, which returns
 * an array of <code>Tasks</code>.  Each returned task, when executed, will run tests and suites determined by the
 * test class name, fingerprints, "explicitly specified" field, and selectors of one of the passed <code>TaskDef</code>s.
 * </p>
 *
 * <p>
 * The "Explicitly specified" field means the user supplied a complete fully qualified test name, such as with the command:
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
 * The <code>explicitlySpecified</code> field will be true for in the first case, and false in the last two cases, because only
 * in the first case was the fully qualified test class name completely specified by the user. The test framework can use this information
 * to decide whether to ignore an annotation requesting a class not be discovered.
 * </p>
 *
 * <p>
 * The <code>fingerprint</code> parameter indicates how the test suite was identified as a test suite. This <code>tasks</code>
 * method may be called with <code>TaskDef</code>s containing the same value for <code>testClassName</code> but different fingerprints.
 * For example, if both a class and its companion object were test classes, the <code>tasks</code> method could be passed an array containing
 * <code>TaskDef</code>s with the same name but with a different value for <code>fingerprint.isModule</code>.
 * </p>
 *
 * <p>
 * A test framework may "reject" a requested task by returning no <code>Task</code> for that <code>TaskDef</code>.
 * </p>
 */
public final class TaskDef implements Serializable {

  private String _fullyQualifiedName;
  private Fingerprint _fingerprint;
  private boolean _explicitlySpecified;
  private Selector[] _selectors;

  /**
   * Constructs a new <code>TaskDef</code> with the given fully qualified name, fingerprint, "explicitly specified" fag, and array
   * of selectors.
   *
   * @param fullyQualifiedName the fully qualified name of the test class to be run by the requested task
   * @param fingerprint indicates how the test suite was identified as a test suite.
   * @param explicitlySpecified indicates whether the test class was explicitly specified by user.
   * @param selectors a possibly empty array of <code>Selectors</code> determining suites and tests to run
   */
  public TaskDef(String fullyQualifiedName, Fingerprint fingerprint, boolean explicitlySpecified, Selector[] selectors) {

    if (fullyQualifiedName == null) {
      throw new NullPointerException("fullyQualifiedName was null");
    }
    if (fingerprint == null) {
      throw new NullPointerException("fingerprint was null");
    }
    if (selectors == null) {
      throw new NullPointerException("selectors was null");
    }

    _fullyQualifiedName = fullyQualifiedName;
    _fingerprint = fingerprint;
    _explicitlySpecified = explicitlySpecified;
    _selectors = selectors;
  }

  /**
   * The fully qualified name of the test class requested by this <code>TaskDef</code>.
   */
  public String fullyQualifiedName() {
    return _fullyQualifiedName;
  }

  /**
   * The fingerprint that the test class requested by this <code>TaskDef</code> matches.
   */
  public Fingerprint fingerprint() {
    return _fingerprint;
  }

  /**
   * Indicates whether or not the test class requested by this <code>TaskDef</code> was "explicitly specified."
   *
   * <p>
   * For more information on what explicitly specified means, see the main documentation for this class.
   * </p>
   */
  public boolean explicitlySpecified() {
    return _explicitlySpecified;
  }

  // TODO: Flesh out this ScalaDoc, or put it on top. What can actually be in this Selectors array. What are the
  // scenarios. When can it be empty. When can it have more than one, etc.
  /**
   * Zero to many selectors describing the nature of the <code>Task</code> requested by this <code>TaskDef</code>.
   */
  public Selector[] selectors() {
    return _selectors;
  }

  @Override public boolean equals(Object o) {
    boolean retVal = false;
    if (o instanceof TaskDef) {
      TaskDef td = (TaskDef) o;
      retVal =
        td._fullyQualifiedName.equals(_fullyQualifiedName) && 
        td._fingerprint.equals(_fingerprint) && 
        td._explicitlySpecified == _explicitlySpecified && 
        Arrays.equals(td._selectors, _selectors);
    }
    return retVal;
  }

  @Override public int hashCode() {
    int retVal = 17;
    retVal = 31 * retVal + _fullyQualifiedName.hashCode();
    retVal = 31 * retVal + _fingerprint.hashCode();
    retVal = 31 * retVal + (_explicitlySpecified ? 1 : 0);
    retVal = 31 * retVal + Arrays.hashCode(_selectors);
    return retVal;
  }

  @Override public String toString() {
    return "TaskDef(" + _fullyQualifiedName + ", " + _fingerprint + ", " + _explicitlySpecified + ", " + Arrays.toString(_selectors) + ")";
  }
}
