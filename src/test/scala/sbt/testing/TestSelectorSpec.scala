package sbt.testing

import org.scalatest._

class TestSelectorSpec extends UnitSpec {

  object `a TestSelector` {
    val redTestSelector = new TestSelector("red")
    val blueTestSelector = new TestSelector("blue")
    def `should have a properly behaving equals method` {
      redTestSelector shouldEqual redTestSelector
      redTestSelector shouldEqual new TestSelector("red")
      redTestSelector should not equal new TestSelector("blue")
      redTestSelector should not equal null
      redTestSelector should not equal "howdy"
      redTestSelector should not equal new SuiteSelector
    }
    def `should have a properly behaving hashCode method` {
      redTestSelector.hashCode shouldEqual redTestSelector.hashCode
      redTestSelector.hashCode shouldEqual (new TestSelector("red")).hashCode
      redTestSelector.hashCode should not equal blueTestSelector.hashCode
      blueTestSelector.hashCode shouldEqual blueTestSelector.hashCode
      blueTestSelector.hashCode shouldEqual (new TestSelector("blue")).hashCode
    }
  }
}

