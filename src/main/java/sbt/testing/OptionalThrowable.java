package sbt.testing;

/**
 * Indicates an event was about the entire suite whose class had the fully qualified name specified as
 * the <code>fullyQualifiedName</code> attribute the event.
 */
public final class OptionalThrowable {

  private Throwable exception;

// TODO: NPE
  public OptionalThrowable(Throwable exception) {
    if (exception == null) {
      throw new NullPointerException("Cannot pass a null exception to OptionalThrowable's constructor.");
    }
    this.exception = exception;
  }

  public OptionalThrowable() {
  }

  public boolean isDefined() {
    return exception != null;
  }

  public boolean isEmpty() {
    return exception == null;
  }

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

