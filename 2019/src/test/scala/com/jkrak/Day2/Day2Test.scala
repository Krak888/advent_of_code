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
    val resultIntcode: Intcode = testIntcode.process(0)
    val expectedIntCode = Intcode(Array(1,2,2,4))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }

  it should "1202 - opcode 2 multiply values of index in 2nd and 3rd position" in {
    val testIntcode = Intcode(Array(2, 2, 2, 3))
    val resultIntcode: Intcode = testIntcode.process(0)
    val expectedIntCode = Intcode(Array(2,2,2,4))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }

  it should "1202 - opcode 99 return same Intcode - with many elements" in {
    val testIntcode = Intcode(Array(99, 0, 1, 2, 3, 4))
    val resultIntcode: Intcode = testIntcode.process(0)
    val expectedIntCode = Intcode(Array(99, 0, 1, 2, 3, 4))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }

  it should "1202 - opcode 99 return same Intcode - with no other elements" in {
    val testIntcode = Intcode(Array(99))
    val resultIntcode: Intcode = testIntcode.process(0)
    val expectedIntCode = Intcode(Array(99))

    (resultIntcode.array sameElements expectedIntCode.array) shouldBe true
  }
}
