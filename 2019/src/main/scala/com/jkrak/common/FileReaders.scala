package com.jkrak.common

import scala.io.Source

object ReadInput {
  def readInputTextFile(day: String, fileName: String): Array[String] = {
    val fullPath = s"2019/src/main/resources/$day/$fileName"
    Source.fromFile(fullPath).getLines.toArray
  }


}


