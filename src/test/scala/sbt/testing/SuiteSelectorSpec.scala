package sbt.testing

import org.scalatest._

class SuiteSelectorSpec extends UnitSpec {

  object `a SuiteSelector` {
    val aSuiteSelector = new SuiteSelector
    def `should have a properly behaving equals method` {
      aSuiteSelector shouldEqual aSuiteSelector
      aSuiteSelector shouldEqual new SuiteSelector
      aSuiteSelector should not equal null
      aSuiteSelector should not equal "howdy"
      aSuiteSelector should not equal new TestSelector("howdy")
    }
    def `should have a properly behaving hashCode method` {
      (new SuiteSelector).hashCode shouldEqual (new SuiteSelector).hashCode
    }
  }
}

