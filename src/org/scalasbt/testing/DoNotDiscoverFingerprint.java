package org.scalasbt.testing;

/**
 * Indicates that classes and modules with a specific annotation
 * should <em>not</em> be discovered as test classes, even if the class or module would otherwise
 * be discoverable because of some other fingerprint.
 */
public interface DoNotDiscoverFingerprint extends Fingerprint
{
	/**
	 * The fully qualified name of the annotation that indicates a class or module should
	 * <em>not</em> be discovered.
	 */
	public String annotationName();
}

