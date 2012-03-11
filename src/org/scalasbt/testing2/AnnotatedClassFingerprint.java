package org.scalasbt.testing2;

/**
 * Indicates that classes (and possibly modules) with a specific annotation
 * should be discovered as test classes.
 */ // Call it annotated fingerprint again
 // TODO: MERGE THIS BACK and dioc that i tlooks at top level methods and class annotations
public interface AnnotatedClassFingerprint extends Fingerprint
{
    /**
     * Indicates whether modules (singleton objects) with the annotation should
     * be considered during discovery, or just classes.
     *
     * <p>
     * If modules are not allowed by the test framework, they should return <code>false</code> for
     * <code>isModule</code>. Returning <code>false</code> will speed up discovery because
     * classes for modules can be quickly bypassed.
     * </p>
     */
    public boolean considerModules();

    /**
     * The name of the annotation that identifies classes (and possibly modules) as test classes (or
     * modules) to be discovered.
     */
    public String annotationName();
}
