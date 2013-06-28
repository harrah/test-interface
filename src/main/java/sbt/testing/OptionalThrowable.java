package sbt.testing;

import java.io.Serializable;

/**
 * An optional <code>Throwable</code>.
 */
public final class OptionalThrowable implements Serializable {

  private Throwable exception;

  /**
   * Constructs an <code>OptionalThrowable</code> containing a <code>Throwable</code>.
   */
  public OptionalThrowable(Throwable exception) {
    if (exception == null) {
      throw new NullPointerException("Cannot pass a null exception to OptionalThrowable's constructor.");
    }
    this.exception = exception;
  }

  /**
   * Constructs an <code>OptionalThrowable</code> containing no <code>Throwable</code>.
   */
  public OptionalThrowable() {
  }

  /**
   * Indicates whether this <code>OptionalThrowable</code> is "defined," <em>i.e.</em>, contains a <code>Throwable</code>.
   *
   * @return true if this <code>OptionalThrowable</code> contains a <code>Throwable</code>
   */
  public boolean isDefined() {
    return exception != null;
  }

  /**
   * Indicates whether this <code>OptionalThrowable</code> is "empty," <em>i.e.</em>, contains no <code>Throwable</code>.
   *
   * @return true if this <code>OptionalThrowable</code> contains no <code>Throwable</code>
   */
  public boolean isEmpty() {
    return exception == null;
  }

  /**
   * Returns the <code>Throwable</code> contained in this <code>OptionalThrowable</code> if defined, else throws <code>IllegalStateException</code>.
   *
   * <p>
   * To avoid the <code>IllegalStateException</code>, ensure <code>isDefined</code> returns <code>true</code> before calling this method.
   * </p>
   *
   * @return the contained <code>Throwable</code>, if this <code>OptionalThrowable</code> is defined
   * @throws IllegalStateException if this <code>OptionalThrowable</code> is not defined.
   */
  public Throwable get() {
    if (exception == null) {
      throw new IllegalStateException("This OptionalThrowable is not defined");
    }
    return exception;
  }

  @Override public boolean equals(Object o) {
    boolean retVal = false;
    if (o instanceof OptionalThrowable) {
      OptionalThrowable ot = (OptionalThrowable) o;
      retVal = ot.exception == exception;
    }
    return retVal;
  }

  @Override public int hashCode() {
    return (exception == null) ? 0 : exception.hashCode();
  }

  @Override public String toString() {
    String retVal = "OptionalThrowable()";
    if (exception != null) {
      retVal = "OptionalThrowable(" + exception + ")";
    }
    return retVal;
  }
}

