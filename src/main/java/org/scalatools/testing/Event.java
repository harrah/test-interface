package org.scalatools.testing;

public interface Event {

    String testName();

    String description();

    Result result();

    Throwable error();
}
