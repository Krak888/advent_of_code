package com.jkrak.Day2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest._
import matchers.should._

class Day2Test extends AnyFlatSpec with Matchers{
  it should "1202 - test creation of Intcode case class with all values" in {
    val testIntcode = Intcode(1, 9, 10, 3)
    testIntcode shouldBe a [Intcode]

  }

  it should "1202 - test creation of Intcode case class with one value" in {
    val testIntcode = Intcode(1)
    testIntcode shouldBe a [Intcode]
  }

}
