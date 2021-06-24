package com.jkrak.Day1

import com.jkrak.common.ReadInput

object Day1 {

  def fuelNeeded(mass: Int): Int = if (mass > 6) mass / 3 - 2 else 0

  def sumNeededFuel(massArray: Array[Int]): Int = massArray.map(fuelNeeded).sum


  def sumNeededFuelRecursive(massArray: Array[Int]): Int = {
    if (massArray.sum == 0) massArray.sum
    else massArray.map(fuelNeeded).sum + sumNeededFuelRecursive(massArray.map(fuelNeeded))
  }


}
