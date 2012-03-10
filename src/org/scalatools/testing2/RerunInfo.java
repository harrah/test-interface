package org.scalatools.testing2;

public class RerunInfo {

    private String testClassName;
    private Selector selector;

    // (suiteId, testName)
    // (null, null) rerun just the entire exact test class, testClassName
    // (XXX, null) rerun the entire XXX nested suite accessed via testClassName
    // (null, YYY) rerun the YYY test directly contained in testClassName
    // (XXX, YYY) rerun the YYY test in the XXX nested suite accessed via testClassName
    public RerunInfo(String testClassName, Selector selector) {
      if (testClassName == null) {
          throw new NullPointerException("testClassName was null");
      }
        if (selector == null) {
            throw new NullPointerException("selector was null");
        }
      this.testClassName = testClassName;
      this.selector = selector;
    }

    public RerunInfo(String testClassName) {
        this(testClassName, new SuiteSelector());
    }

    public String getTestClassName() {
        return testClassName;
    }

    public Selector getSelector() {
        return selector;
    }
// It is either a suite id only, or a test name only, or a combo suite id and test name, or
    // nothing for rerunning the entire testClass name suite
}
