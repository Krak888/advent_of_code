package com.jkrak.Day1

object Day1 {
  def main (args: Array[String]): Unit = {
    val inputRaw = ReadInput.readInputTextFile("day1","inputDay1")
    val inputClean = inputRaw.map(_.toInt)

    println("sum is : " + sumNeededFuelRecursive(inputClean))
  }

  def fuelNeeded(mass: Int): Int = if (mass > 6) mass / 3 - 2 else 0

  def sumNeededFuel(massArray: Array[Int]): Int = massArray.map(fuelNeeded).sum


  def sumNeededFuelRecursive(massArray: Array[Int]): Int = {
    if (massArray.sum == 0) massArray.sum
    else massArray.map(fuelNeeded).sum + sumNeededFuelRecursive(massArray.map(fuelNeeded))
  }


}

import scala.io.Source

object ReadInput {
  def readInputTextFile(day: String, fileName: String): Array[String] = {
    val fullPath = s"2019/src/main/resources/$day/$fileName"
    Source.fromFile(fullPath).getLines.toArray
  }


}

