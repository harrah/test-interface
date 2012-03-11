package org.scalatools.testing2;

/**
 * Indicates that classes (and possibly modules) that extend a particular superclass,
 * or mix in a particular supertrait, should be discovered as test classes.
 */
public interface SubclassFingerprint extends Fingerprint
{
    /**
     * Indicates whether modules (singleton objects) that extend the superclass or
     * supertrait should be considered during discovery, or just classes.
     *
     * <p>
     * If modules are not allowed by the test framework, they should return <code>false</code> for
     * <code>isModule</code>. Returning <code>false</code> will speed up discovery because
     * classes for modules can be quickly bypassed.
     * </p>
     */                     // TODO update dox it is either or
    public boolean isModule();

    /**
     * The name of the superclass or supertriat that identifies classes (and possibly modules) as test
     * classes to be discovered.
     */
    public String superclassName();
}
