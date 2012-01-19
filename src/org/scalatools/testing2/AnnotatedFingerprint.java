package org.scalatools.testing2;

/** Identifies a test by a class or its methods having a specific annotation. */
public interface AnnotatedFingerprint extends Fingerprint
{
	/** Whether a test is a module or a class*/
	public boolean isModule();

	/** The name of the annotation that identifies it as a test.*/
	public String annotationName();

    /**
     * Indicates whether or not the annotation should cause the class to
     * be discovered, or not discovered (even if it matches some other fingerprint).
     */
    public boolean isDiscoverable();
}
