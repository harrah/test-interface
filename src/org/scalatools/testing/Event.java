package org.scalatools.testing;

import java.io.Serializable;

public interface Event extends Serializable {

    String testName();

    String description();

    Result result();

    Throwable error();
}
