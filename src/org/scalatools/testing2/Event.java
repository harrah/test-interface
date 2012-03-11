package org.scalatools.testing2;

/**
 * An Event fired by the test framework during a run.
 */
public interface Event {
    //Model without nulls the fact that there may not be a test name, but there I think
    // is always a test clss name
}

/*
Actually "reruninfo" could go here kind of, because he wants to know if
a test failed before if it succeeds now. But it isn't about "rerunnig" more general
. Just a path to the thing that is being reported about in the event.
a unique identifier for the thing the event is about. comes out in the
event and can be passed back in for a "run", which is not necessarily a rerun.
*/