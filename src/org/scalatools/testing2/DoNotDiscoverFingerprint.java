package org.scalatools.testing2;

/**
 * Indicates that classes (and possibly modules) with a specific annotation
 * should <em>not</em> be discovered as test classes, even if the class (or module) would otherwise
 * be discoverable because of some other fingerprint.
 */
public interface DoNotDiscoverFingerprint extends Fingerprint
{
    /**
     * The name of the annotation that indicates a class (or possibly, a module) should
     * <em>not</em> be discovered.
     */
    public String annotationName();
}

// Added this: for not discovering things