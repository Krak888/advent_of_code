package com.jkrak.Day1

object Day1 {
  def main (args: Array[String]): Unit = {
    val inputRaw = ReadInput.readInputTextFile("day1","inputDay1")
    val inputClean = inputRaw.map(_.toInt)

    println("sum is : " + sumNeededFuel(inputClean))
  }


  def fuelNeeded(mass: Int): Int = mass / 3 - 2
  def sumNeededFuel(massArray: Array[Int]): Int = massArray.map(fuelNeeded).sum

}

import scala.io.Source

object ReadInput {
  def readInputTextFile(day: String, fileName: String): Array[String] = {
    val fullPath = s"2019/src/main/resources/$day/$fileName"
    Source.fromFile(fullPath).getLines.toArray
  }


}

