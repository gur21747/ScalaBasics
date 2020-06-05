package lectures.part1basics
/*
  Created by  : Ribhu Kashyap
  Created on  : 29/05/2020
  Purpose     : Initial Creation
 */
import scala.annotation.tailrec
import scala.util.Random

object StringOperations extends App {
  val sampleString:String = "this is a sample string"

  //Native string library of Java is available in Scala as well
  println(sampleString.charAt(3))
  println(sampleString.toUpperCase)
  println(sampleString.compareTo(sampleString.substring(0,sampleString.length)))
  println(sampleString.toList)
  println(sampleString.split(" ").toList)
  println(sampleString.replace(" ","#"))
  println(sampleString.sorted)
  println(sampleString.take(3))

  // Scala-specific: String interpolators.
    def randomString(num:Int):String = {
    val low = 65 // A
    val high = 90 // Z
    if(num <= 0) ""
    else (Random.nextInt(high - low) + low).toChar + randomString(num - 1)
  }
  //println(randomString(5))

  //S-interpolator and F-interpolator demo
  println("--------------------------")
  @tailrec
  def printRandomString(num:Int):Unit = {
    var name = randomString(10)
    val pi = num*3.141593f
    println(s"Hello, the random string is $name")   //S-interpolator
    println(f"Hello, the random string is $name and value of pi is $pi%2.6f") //F-interpolator
    if (num<=1) println("")
    else printRandomString(num-1)
  }
  printRandomString(3)

  // raw-interpolator
  println(raw"This is a \n newline")  //new line character is ignored
  val escaped = "This is a \n newline"
  println(raw"$escaped")    //new line character is not ignored

}
