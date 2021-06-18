package com.jkrak.Day1

import org.apache.spark._

object TestSpark {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local[1]")
      .setAppName("Simple Spark Application")
      .set("spark.logConf", "false")

    val sc = new SparkContext(conf)
    val count = sc.parallelize(Seq("Hello", "from", "Spark"), 1).count()
    println(s"Count result: $count")

    sc.stop()
  }

}