package com.jkrak

import com.jkrak.common.ReadInput
import com.jkrak.Day2.Intcode
import com.jkrak.Day1.Day1

object Main {
  def main (args: Array[String]): Unit = {
    runDay2
  }

  def runDay2: Unit = {
    val inputRaw: Array[Int]= ReadInput.readInputTextToOnRawToArrayOfInt("day2","inputDay2")
    val intcode = Intcode(inputRaw).prepareIntcode.fullProcess(0)

    println("value at 0 is : " + intcode.array(0))
    println("       answer : 9581917")
  }
  def runDay1: Unit = {
    val inputRaw = ReadInput.readInputTextFileListedToArrayOfInt("day1","inputDay1")

    println("sum is : " + Day1.sumNeededFuelRecursive(inputRaw))
    println("answer : 4943578")
  }
}
