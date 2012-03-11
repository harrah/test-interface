package org.scalasbt.testing2;

public class NestedSuiteSelector {

    private String suiteId;

    public NestedSuiteSelector(String suiteId) {
        if (suiteId == null) {
            throw new NullPointerException("suiteId was null");
        }
        this.suiteId = suiteId;
    }

    public String getSuiteId() {
        return suiteId;
    }
}
