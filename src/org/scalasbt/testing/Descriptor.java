package org.scalasbt.testing;

public class Descriptor {

    private String testClassName;
    private Selector selector;

    // (suiteId, testName)
    // (null, null) rerun just the entire exact test class, testClassName
    // (XXX, null) rerun the entire XXX nested suite accessed via testClassName
    // (null, YYY) rerun the YYY test directly contained in testClassName
    // (XXX, YYY) rerun the YYY test in the XXX nested suite accessed via testClassName
    public Descriptor(String testClassName, Selector selector) {
      if (testClassName == null) {
          throw new NullPointerException("testClassName was null");
      }
        if (selector == null) {
            throw new NullPointerException("selector was null");
        }
      this.testClassName = testClassName;
      this.selector = selector;
    }

    public Descriptor(String testClassName) {
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
