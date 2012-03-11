package org.scalasbt.testing;

/**
 * Indicates that classes or modules with a specific annotation, either on at least one top level
 * method or the class itself, should be discovered as test classes. */
public interface AnnotatedFingerprint extends Fingerprint
{
    /**
     * Indicates whether modules (singleton objects) with the annotation should
     * be considered during discovery, or just classes.
     *
     * <p>
     * If modules are not allowed by the test framework, they should return <code>false</code> for
     * <code>isModule</code>. Returning <code>false</code> will speed up discovery because
     * classes for modules can be quickly bypassed.   TODO: Clarify framework needs one for each.
     * </p>
     */
    public boolean isModule();

    /**
     * The fully qualified name of the annotation that identifies classes (and possibly modules) as test
     * classes (or modules) to be discovered.
     */
    public String annotationName();
}
