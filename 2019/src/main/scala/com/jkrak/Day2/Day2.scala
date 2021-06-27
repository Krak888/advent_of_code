package com.jkrak.Day2

object Day2 {

}

case class Intcode(array: Array[Int]) {
  def process(startPosition: Int): (Intcode, Int) = array(startPosition) match {
    case 1  => (add(startPosition), startPosition + 4)
    case 2  => (mult(startPosition), startPosition + 4)
    case 99 => (this, -1)
    case _  => (this, 0)
  }

  def fullProcess(startPosition: Int =0): Intcode = {
    val (newIntcode, newPosition) = this.process(startPosition)
    newPosition match {
      case -1 => newIntcode
      case _  => newIntcode.fullProcess(newPosition)
    }
  }

  def add(startPosition: Int): Intcode = {
    val firstPosition  = array(startPosition + 1)
    val secondPosition = array(startPosition + 2)
    val addingPosition = array(startPosition + 3)

    val adding = array(firstPosition) + array(secondPosition)

    val newArray = array.slice(0, addingPosition) ++ Array(adding) ++ array.slice(addingPosition+1, array.length)

    Intcode(newArray)
  }

  def mult(startPosition: Int): Intcode = {
    val firstPosition  = array(startPosition + 1)
    val secondPosition = array(startPosition + 2)
    val addingPosition = array(startPosition + 3)

    val adding = array(firstPosition) * array(secondPosition)

    val newArray = array.slice(0, addingPosition) ++ Array(adding) ++ array.slice(addingPosition+1, array.length)

    Intcode(newArray)
  }
}
