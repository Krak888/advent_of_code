package com.jkrak.common

import scala.io.Source

//TODO : add option and side effect handeling (zio?)
object ReadInput {
  def readInputTextFile(day: String, fileName: String): Array[String] = {
    val fullPath = s"2019/src/main/resources/$day/$fileName"
    Source.fromFile(fullPath).getLines.toArray
  }

  def readInputTextFileListedToArrayOfInt(day: String, fileName: String): Array[Int] =
    readInputTextFile(day,fileName)
      .map(_.toInt)
  def readInputTextToOnRawToArrayOfInt(day: String, fileName: String): Array[Int] =
    readInputTextFile(day,fileName)
      .head.split(",")
      .map(_.toInt)
}


