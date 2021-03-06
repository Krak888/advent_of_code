package com.jkrak.Day2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest._
import matchers.should._

class Day2Test extends AnyFlatSpec with Matchers{
  it should "1202 - test creation of Intcode case class" in {
  val testIntcode = Intcode(Array(1, 9, 10, 3))
    testIntcode shouldBe a [Intcode]
  }

  it should "1202 - opcode 1 add values of index in 2nd and 3rd position" in {
    val testIntcode = Intcode(Array(1, 2, 2, 3))
    val (resultIntcode, _): (Intcode, Int) = testIntcode.process(0)
    val expectedIntCode = Intcode(Array(1,2,2,4))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }

  it should "1202 - opcode 2 multiply values of index in 2nd and 3rd position" in {
    val testIntcode = Intcode(Array(2, 2, 2, 3))
    val (resultIntcode, _): (Intcode, Int) = testIntcode.process(0)
    val expectedIntCode = Intcode(Array(2,2,2,4))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }

  it should "1202 - opcode 99 return same Intcode - with many elements" in {
    val testIntcode = Intcode(Array(99, 0, 1, 2, 3, 4))
    val (resultIntcode, _): (Intcode, Int) = testIntcode.process(0)
    val expectedIntCode = Intcode(Array(99, 0, 1, 2, 3, 4))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }

  it should "1202 - opcode 99 return same Intcode - with no other elements" in {
    val testIntcode = Intcode(Array(99))
    val (resultIntcode, _): (Intcode, Int) = testIntcode.process(0)
    val expectedIntCode = Intcode(Array(99))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }

  it should "1202 - test 1st given test serie" in {
    val testIntcode = Intcode(Array(1,9,10,3,2,3,11,0,99,30,40,50))
    val resultIntcode: Intcode = testIntcode.fullProcess(0)
    val expectedIntCode = Intcode(Array(3500,9,10,70, 2,3,11,0, 99, 30,40,50))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }

  it should "1202 - test 2nd given test serie" in {
    val testIntcode = Intcode(Array(1,0,0,0,99))
    val resultIntcode: Intcode = testIntcode.fullProcess(0)
    val expectedIntCode = Intcode(Array(2,0,0,0,99))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }
  it should "1202 - test 3rd given test serie" in {
    val testIntcode = Intcode(Array(2,3,0,3,99))
    val resultIntcode: Intcode = testIntcode.fullProcess(0)
    val expectedIntCode = Intcode(Array(2,3,0,6,99))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }
  it should "1202 - test 4th given test serie" in {
    val testIntcode = Intcode(Array(2,4,4,5,99,0))
    val resultIntcode: Intcode = testIntcode.fullProcess(0)
    val expectedIntCode = Intcode(Array(2,4,4,5,99,9801))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }
  it should "1202 - test 5th given test serie" in {
    val testIntcode = Intcode(Array(1,1,1,4,99,5,6,0,99))
    val resultIntcode: Intcode = testIntcode.fullProcess(0)
    val expectedIntCode = Intcode(Array(30,1,1,4,2,5,6,0,99))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }

  it should "1202 - prepare Intcode" in {
    val testIntcode = Intcode(Array(1,1,1,4,99,5,6,0,99))
    val resultIntcode: Intcode = testIntcode.prepareIntcode(12, 2)
    val expectedIntCode = Intcode(Array(1,12,2,4,99,5,6,0,99))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }
  it should "1202 - generate an array with all possible values for noun and verbe" in {
    val testAllNounAndVerbe = Intcode(Array(1)).getPossibleNounAndVerbe(4)
    val expectedArray = Array((0,0),(0,1),(0,2),(0,3),
                              (1,0),(1,1),(1,2),(1,3),
                              (2,0),(2,1),(2,2),(2,3),
                              (3,0),(3,1),(3,2),(3,3))
    (testAllNounAndVerbe should be equals(expectedArray))
  }

  it should "1202 - gravity should return the noun and verbe used to find a given value" in {
    val testIntcode = Intcode(Array(1,1,1,4,99,5,6,0,99))
    val (resultIntcode, resultNoun, resultVerb): (Intcode, Int, Int) = testIntcode.gravityFind(30,5)
    val expectedIntcode = Intcode(Array(30,1,1,4,2,5,6,0,99))
    val expectedNoun = 0
    val expectedVerb = 0

    (resultIntcode.array sameElements expectedIntcode.array) shouldBe true
    (resultNoun should be equals(expectedNoun))
    (resultVerb should be equals(expectedVerb))

  }

}
