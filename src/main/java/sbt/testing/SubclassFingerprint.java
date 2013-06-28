package sbt.testing;

/**
 * Indicates that classes (and possibly modules) that extend a particular superclass,
 * or mix in a particular supertrait, should be discovered as test classes.
 */
public interface SubclassFingerprint extends Fingerprint {

  /**
   * Indicates whether modules (singleton objects) that extend the superclass or
   * supertrait should be considered during discovery, or just classes.
   *
   * <p>
   * If modules are not allowed by the test framework, they should return <code>false</code> for
   * <code>isModule</code>. Returning <code>false</code> will speed up discovery because
   * classes for modules can be quickly bypassed.
   * </p>
   */
  public boolean isModule();

  /**
   * The name of the superclass or supertrait that identifies classes (and possibly modules) as test
   * classes to be discovered.
   */
  public String superclassName();

  /**
   * Indicates whether discovered classes must have a no-arg constructor.
   *
   * <p>
   * If this method returns <code>true</code>, the client should not discover any subclass of
   * the given <code>superClassName</code> that does not declare a no-arg constructor, <em>i.e.</em>,
   * a constructor that takes no arguments.
   * </p>
   */
  public boolean requireNoArgConstructor();
}
