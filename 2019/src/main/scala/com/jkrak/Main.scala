package com.jkrak

import com.jkrak.common.ReadInput
import com.jkrak.Day2.Intcode
import com.jkrak.Day1.Day1

object Main {
  def main (args: Array[String]): Unit = {
    runDay2_2
  }
  def runDay2_2: Unit = {
    val inputRaw: Array[Int]= ReadInput.readInputTextToOnRawToArrayOfInt("day2","inputDay2")
    val (_, noun, verb) = Intcode(inputRaw)gravityFind(19690720, 50)
    val computeResult = 100 * noun + verb

    println(s"noun = $noun and verb = $verb")
    println(s"the result is : $computeResult")
    println("       answer : 2505")
  }
  def runDay2_1: Unit = {
    val inputRaw: Array[Int]= ReadInput.readInputTextToOnRawToArrayOfInt("day2","inputDay2")
    val intcode = Intcode(inputRaw).prepareIntcode(12,2).fullProcess(0)

    println("value at 0 is : " + intcode.array(0))
    println("       answer : 9581917")
  }
  def runDay1: Unit = {
    val inputRaw = ReadInput.readInputTextFileListedToArrayOfInt("day1","inputDay1")

    println("sum is : " + Day1.sumNeededFuelRecursive(inputRaw))
    println("answer : 4943578")
  }
}
