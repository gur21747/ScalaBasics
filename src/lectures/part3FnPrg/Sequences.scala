package lectures.part3FnPrg
/*
  Created by  : Ribhu Kashyap
  Created on  : 03/06/2020
  Purpose     : Demonstrate sequences and operations in Scala
 */
import java.util

import scala.util.Random

object Sequences extends App {
  // Seq
  val stringSeq = Seq(" This"," is"," a"," scala"," sequence")
  val intSeq = Seq(2334,234454,7653,575757,574834)
  println(stringSeq)
  println(stringSeq.reverse)
  println(stringSeq(2))             //prints the element at index 2
  println(stringSeq ++ intSeq)      //++ operator concatenates two lists into one seq
  println(intSeq.sorted)            //sorts a given sequence

  // Ranges
  val intRange: Seq[Int] = 0 until 10
  val charRange: Seq[Char] = 'b' until 'f'
//  intRange.foreach(println)
//  charRange.foreach(println)

  (1 to 5).foreach(x => println(charRange.size, intRange.size))

  // lists
  val intList = List(1,2,3,4,5)
  val prepended2 = 0 +: intList :+ 6
  println(prepended2)    //note the output of this - it prints List

  val stringList = List.fill(5)("apple")
  println(stringList)
  println(stringSeq.mkString("-|-"))

  // arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)    //Array of a defined length 3
  threeElements.foreach(println)                     //Prints null initialized strings
  val threeIntElements = Array.ofDim[Int](3)
  println(threeIntElements)                          //Prints uninitialized garbage
  threeIntElements.foreach(println)                  //Prints 0 initialized integers

  // mutation
  numbers.update(3,5) //update an element on a specific index
  numbers(3) = 5      //syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers  // implicit conversion
  println(numbersSeq)                 //note that it prints a WrappedArray

  // vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  val prepended = 'a' +: charRange :+ 'f'
  println(prepended)    //note the output of this - it prints Vector

  //Compare the performance of List Vs Vector by calculating average write time - check playground for example

}
