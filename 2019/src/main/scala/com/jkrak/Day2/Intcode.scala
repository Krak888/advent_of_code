package com.jkrak.Day2

case class Intcode(array: Array[Int]) {
  def process(startPosition: Int): (Intcode, Int) = array(startPosition) match {
    case 1  => (add(startPosition), startPosition + 4)
    case 2  => (mult(startPosition), startPosition + 4)
    case 99 => (this, -1)
    case _  => (this, -1)
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

    val multiply = array(firstPosition) * array(secondPosition)

    val newArray = array.slice(0, addingPosition) ++ Array(multiply) ++ array.slice(addingPosition+1, array.length)

    Intcode(newArray)
  }

  def prepareIntcode(noun: Int, verb: Int): Intcode = {
    val head: Array[Int] = Array(array.head)
    val corp: Array[Int] = Array(noun,verb)
    val tail: Array[Int] = array.slice(3,array.length)

    val newArray: Array[Int] = head ++ corp ++ tail
    Intcode(newArray)
  }

  def gravityFind(catchValue: Int, dept: Int): (Intcode, Int, Int) = {
    val allPossibilities = getPossibleNounAndVerbe(dept)
    val allConbinaisonProcessed = allPossibilities.
      map{case (noun, verb) => (this.prepareIntcode(noun, verb).
        fullProcess(),
        noun,
        verb)
      }
    val filteredAllResults = allConbinaisonProcessed.filter{ case (intcode, _, _) => intcode.array(0) == catchValue}

    if (filteredAllResults.isEmpty) (this,-1,-1)
    else filteredAllResults.head
  }

  def getPossibleNounAndVerbe(dept: Int):Array[(Int,Int)] = {
    val listOfValues = (1 to dept).toArray
    val alltestedValues = listOfValues.flatMap(x => listOfValues.map((_,x)))

    alltestedValues
  }
}
