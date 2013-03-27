package org.scalasbt.testing;

/**
 * Indicates that classes or modules with a specific annotation, either on at least one top level
 * method or on the class or module itself, should be discovered as test classes.
 * */
public interface AnnotatedFingerprint extends Fingerprint
{
	/**
	 * Indicates whether modules with the annotation should
	 * be considered during discovery, or just classes.
	 *
	 * <p>
	 * If a test framework allows both classes and modules, they should return two different
	 * fingerprints from <code>Framework.fingerprints</code>, one that returns <code>false</code> for
	 * <code>isModule</code> and another that returns <code>true</code>.
	 * </p>
	 */
	public boolean isModule();

	/**
	 * The fully qualified name of the annotation that identifies classes or modules as test
	 * classes or modules to be discovered.
	 */
	public String annotationName();
}
