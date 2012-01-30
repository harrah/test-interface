package org.scalatools.testing2;

/**
 * An event that indicates an error occurred that represents a
 * failed test.
 *
 * <p>
 * This event includes information, a <code>TestId</code>, that can
 * be used to rerun the failed test. The <code>testClassName</code> contained in this
 * event should be the one that was passed to <code>Runner.getTask</code> that
 * created the task the eventually led to this failed test. "Eventually" means
 * that executing either the returned task itself, or one of the tasks produced
 * by executing the returned tasks, or produced by executing one of those tasks,
 * and so on, caused the test that failed to be run. The client can then rerun
 * this failed test by passing the <code>testClassName</code> and <code>testId</code>
 * to the appropriate <code>Runner.task</code> method.
 * </p>
 */
public class TestFailedEvent implements Event {

    private String testClassName;
    private TestId testId;
    private Throwable throwable;

    /**
     * Constructs a new <code>TestFailedEvent</code> with passed <code>testClassName</code>,
     * <code>testId</code>, and <code>throwable</code>.
     *
     * @param testClassName the test class name that can be used to rerun this failed test
     * @param testId a test ID that can be used to rerun this failed test
     * @param throwable a <code>Throwable</code> associated with the failed test, or <code>null</code>
     *                  if no <code>Throwable</code> is associated with this test
     *
     * @throws NullPointerException if either <code>testClassName</code> or <code>testId</code>
     *              is <code>null</code>
     */
    public TestFailedEvent(String testClassName, TestId testId, Throwable throwable) {
        if (testClassName == null)
            throw new NullPointerException();
        if (testId == null)
            throw new NullPointerException();
        this.testClassName = testClassName;
        this.testId = testId;
        this.throwable = throwable;
    }

    /**
     * Constructs a new <code>TestFailedEvent</code> with passed <code>testClassName</code>,
     * <code>testId</code>, and a <code>null</code> <code>throwable</code>.
     *
     * @param testClassName the test class name that can be used to rerun this failed test
     * @param testId a test ID that can be used to rerun this failed test
     *
     * @throws NullPointerException if either <code>testClassName</code> or <code>testId</code>
     *              is <code>null</code>
     */
    public TestFailedEvent(String testClassName, TestId testId) {
        this(testClassName, testId, null);
    }

    // Note, in ScalaTest this is for -s <testClassName>
    /**
     * The test class name for this <code>TestFailedEvent</code>.
     *
     * @return the test class name passed to this <code>TestFailedEvent</code>
     */
    public String testClassName() {
        return testClassName;
    }

    // Note: in ScalaTest this is for, if testId.suiteId is not null, -S <testId.suiteId>
    // and -t <testId.testName>
    /**
     * The test ID for the test that failed, which can be used to rerun the failed test.
     *
     * @return the test ID passed to this <code>TestFailedEvent</code>
     */
    public TestId testId() {
        return testId;
    }

    /**
     * Returns the <code>Throwable</code> that caused this <code>TestFailedEvent</code>, or
     *          <code>null</code> if no <code>Throwable</code> was associated with this event.
     *
     * @return the <code>Throwable</code> passed to this <code>TestFailedEvent</code>, or
     *          <code>null</code>, if no <code>Throwable</code> was passed.
     */
    public Throwable throwable() {
        return throwable;
    }
}
