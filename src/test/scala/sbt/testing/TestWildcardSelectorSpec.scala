package sbt.testing

import org.scalatest._

class TestWildcardSelectorSpec extends UnitSpec {

  object `a TestWildcardSelector` {
    val redTestWildcardSelector = new TestWildcardSelector("red")
    val blueTestWildcardSelector = new TestWildcardSelector("blue")
    def `should give back what you put into it` {
      redTestWildcardSelector.testWildcard shouldBe "red"
      blueTestWildcardSelector.testWildcard shouldBe "blue"
    }
    def `should have a properly behaving equals method` {
      redTestWildcardSelector shouldEqual redTestWildcardSelector
      redTestWildcardSelector shouldEqual new TestWildcardSelector("red")
      redTestWildcardSelector should not equal new TestWildcardSelector("blue")
      redTestWildcardSelector should not equal null
      redTestWildcardSelector should not equal "howdy"
      redTestWildcardSelector should not equal new SuiteSelector
    }
    def `should have a properly behaving hashCode method` {
      redTestWildcardSelector.hashCode shouldEqual redTestWildcardSelector.hashCode
      redTestWildcardSelector.hashCode shouldEqual (new TestWildcardSelector("red")).hashCode
      redTestWildcardSelector.hashCode should not equal blueTestWildcardSelector.hashCode
      blueTestWildcardSelector.hashCode shouldEqual blueTestWildcardSelector.hashCode
      blueTestWildcardSelector.hashCode shouldEqual (new TestWildcardSelector("blue")).hashCode
    }
    def `should throw NPE from constructor if null passed` {
      a [NullPointerException] should be thrownBy {
        new TestWildcardSelector(null)
      }
    }
  }
}

