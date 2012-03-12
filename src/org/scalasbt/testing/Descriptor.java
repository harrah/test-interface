package org.scalasbt.testing;

/**
 * Information that identifies the suite or test about which an event was fired.
 *
 * <p>
 * This information can be used to rerun suites or tests.
 * </p>
 */
public class Descriptor {

    private String testClassName;
    private Selector selector;

    /**
     * Constructs a new <code>Descriptor</code> with passed test class name and selector.
     * 
     * @param testClassName the fully qualified name of the test class about which an event was fired
     * @param selector additional information identifying the suite or test about which an event was fired
     * @throws NullPointerException if either <code>testClassName</code> or <code>selector</code> is null
     */
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

    /**
     * The fully qualified test class name about which an event was fired.
     *
     * @return the fully qualified test class name
     */
    public String getTestClassName() {
        return testClassName;
    }

    /**
     * A <code>Selector</code> that can be used to identify the suite or test about which an event was fired.
     *
     * @return the fully qualified test class name
     */
    public Selector getSelector() {
        return selector;
    }
}
