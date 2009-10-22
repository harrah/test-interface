package org.scalatools.testing;

public interface TestResult {

    String testName();

    Result result();

    Throwable error();
}
