package org.scalasbt.testing;

import java.io.Serializable;

/**
 * A way to identify test classes and/or modules that should
 * be discovered when the the client performs discovery.
 */
public interface Fingerprint extends Serializable {}
