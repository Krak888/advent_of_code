package com.jkrak

object Main {
  def main (args: Array[String]): Unit = {
    val inputRaw = ReadInput.readInputTextFile("day1","inputDay1")
    val inputClean = inputRaw.map(_.toInt)

    println("sum is : " + sumNeededFuelRecursive(inputClean))
  }
}