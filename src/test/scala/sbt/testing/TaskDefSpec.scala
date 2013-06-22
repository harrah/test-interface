package sbt.testing

import org.scalatest._

class TaskDefSpec extends UnitSpec {

  case object SuiteSubclassFingerprint extends SubclassFingerprint {
    def isModule: Boolean = false
    def superclassName: String = "org.scalatest.Suite"
    def requireNoArgConstructor: Boolean = true
  }

  case object WrapWithAnnotatedFingerprint extends AnnotatedFingerprint {
    def isModule: Boolean = false
    def annotationName: String = "org.scalatest.WrapWith"
  }

  object `a TaskDef` {
    def `should give back what you put into it` {

      val fqn1 = "com.myproject.SomeSpec"
      val td1 =
        new TaskDef(
          fqn1,
          SuiteSubclassFingerprint,
          false,
          Array(new SuiteSelector)
        )
        td1.fullyQualifiedName shouldBe fqn1
        td1.fingerprint shouldBe SuiteSubclassFingerprint
        td1.explicitlySpecified shouldBe false
        td1.selectors shouldBe Array(new SuiteSelector)

        val fqn2 = "com.myproject.SomeOtherSpec"
        val td2 =
          new TaskDef(
            fqn2,
            WrapWithAnnotatedFingerprint,
            true,
            Array(new TestSelector("it should do something"))
        )
        td2.fullyQualifiedName shouldBe fqn2
        td2.fingerprint shouldBe WrapWithAnnotatedFingerprint
        td2.explicitlySpecified shouldBe true
        td2.selectors shouldBe Array(new TestSelector("it should do something"))
    }
    def `should throw NPE from constructor of null passed` {
      val fullyQualifiedName: String = "com.myproject.SomeSpec"
      val fingerprint: Fingerprint = SuiteSubclassFingerprint
      val selectors: Array[Selector] = Array(new SuiteSelector)
      val invalidCombos =
        Table(
          ("fullyQualifiedName", "fingerprint", "selectors"),
          (        null        ,  fingerprint ,  selectors ),
          ( fullyQualifiedName ,     null     ,  selectors ),
          ( fullyQualifiedName ,  fingerprint ,    null    )
        )
      forAll (invalidCombos) { (fqn, fp, sel) =>
        a [NullPointerException] should be thrownBy {
          new TaskDef(fqn, fp, false, sel)
        }
      }
    }
  }
}

