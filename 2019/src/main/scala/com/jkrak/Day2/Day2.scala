package com.jkrak.Day2

object Day2 {

}

case class Intcode(array: Array[Int]) {
  def process(startPosition: Int): Intcode = array(startPosition) match {
    case 1  => add(startPosition)
    case 2  => mult(startPosition)
    case _  => this
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
