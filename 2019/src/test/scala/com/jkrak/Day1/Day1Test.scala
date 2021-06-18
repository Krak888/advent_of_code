package com.jkrak.Day1

/*import org.scalatest.matchers.should.Matchers
import org.scalatest.funsuite.AnyFunSuite

object Day1Test extends AnyFunSuite with Matchers {
//class Day1Test extends FunSpec {
  test("test the testing fct") {
    assert(Day1.testFct(1) == 4)
  }
}*/

import org.scalatest.flatspec.AnyFlatSpec

class Day1Test extends AnyFlatSpec {
  //Unitary tests FUELNEEDED
  it should "FUELNEEDED - test value without decimal with the division" in {
    val testValue: Int = 12
    val expectedValue: Int = 2
    assert(Day1.fuelNeeded(testValue) == expectedValue)
  }
  it should "FUELNEEDED - test value with decimal lower that 0.5 with the division" in {
    val testValue: Int = 13
    val expectedValue: Int = 2
    assert(Day1.fuelNeeded(testValue) == expectedValue)
  }
  it should "FUELNEEDED - test value with decimal upper that 0.5 with the division" in {
    val testValue: Int = 14
    val expectedValue: Int = 2
    assert(Day1.fuelNeeded(testValue) == expectedValue)
  }

  //Given tests FUELNEEDED
  it should "FUELNEEDED - 1st given test" in {
    val testValue: Int = 12
    val expectedValue: Int = 2
    assert(Day1.fuelNeeded(testValue) == expectedValue)
  }
  it should "FUELNEEDED - 2nd given test" in {
    val testValue: Int = 14
    val expectedValue: Int = 2
    assert(Day1.fuelNeeded(testValue) == expectedValue)
  }
  it should "FUELNEEDED - 3th given test" in {
    val testValue: Int = 1969
    val expectedValue: Int = 654
    assert(Day1.fuelNeeded(testValue) == expectedValue)
  }
  it should "FUELNEEDED - 4th given test" in {
    val testValue: Int = 100756
    val expectedValue: Int = 33583
    assert(Day1.fuelNeeded(testValue) == expectedValue)
  }

  //Unitary tests SUMNEEDEDFUEL
  it should "SUMNEEDEDFUEL - sum the 2 first given example" in {
    val testValue: Array[Int] = Array(12,14)
    val expectedValue: Int = 4
    assert(Day1.sumNeededFuel(testValue) == expectedValue)
  }

}
