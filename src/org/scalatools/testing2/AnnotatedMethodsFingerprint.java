package org.scalatools.testing2;

/**
 * Indicates that classes (and possibly modules) that contain at least one top-level method
 * with a specific annotation should be discovered as test classes.
 */
public interface AnnotatedMethodsFingerprint extends Fingerprint
{
    /**
     * Indicates whether modules (singleton objects) with the annotation should
     * be considered during discovery, or just classes.
     *
     * <p>
     * If modules are not allowed by the test framework, they should return <code>false</code> for
     * <code>considerModules</code>. Returning <code>false</code> will speed up discovery because
     * classes for modules can be quickly bypassed.
     * </p>
     */
    public boolean considerModules();

    /**
     * The name of the annotation that, when it appears on at least one top-level method of a class,
     * identifies the class as test class to be discovered.
     */
    public String annotationName();
}

// DIFFERENCE: Added this, for JUnit/TestNG discovery?