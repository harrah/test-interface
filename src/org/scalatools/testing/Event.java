package org.scalatools.testing;

public interface Event {

    String testName();

    Result result();

    Throwable error();
}
