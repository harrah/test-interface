package org.scalatools.testing2;

public interface Event {

    String testName();

    String description();

    Result result();

    Throwable error();
}
