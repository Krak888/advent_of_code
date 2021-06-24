package com.jkrak

import com.jkrak.common.ReadInput
import com.jkrak.Day1.Day1

object Main {
  def main (args: Array[String]): Unit = {

    val inputRaw = ReadInput.readInputTextFile("day1","inputDay1")
    val inputClean = inputRaw.map(_.toInt)

    println("sum is : " + Day1.sumNeededFuelRecursive(inputClean))
  }
}
