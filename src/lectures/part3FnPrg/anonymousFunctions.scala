package lectures.part3FnPrg
/*
  Created by  : Ribhu Kashyap
  Created on  : 01/06/2020
  Purpose     : Demonstrate anonymous Functions in Scala
 */

object anonymousFunctions extends App {

  // anonymous function (LAMBDA)
  val doubler: Int => Int = (x: Int) => x * 2
  println(doubler(5))

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b
  println(adder(5,5))

  // no params
  val justDoSomething: () => Int = () => 3

  // Always call functions with ()
  println(justDoSomething) // function itself
  println(justDoSomething()) // call

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // syntactic sugar examples below
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}