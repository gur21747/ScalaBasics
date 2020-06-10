package lectures.part3FnPrg
/*
  Created by  : Ribhu Kashyap
  Created on  : 01/06/2020
  Purpose     : Demonstrate higher order functions in Scala
 */

object higherOrdFn extends App {
  //Any function with takes another function as an argument or returns a function as result is
  //called higher order function (HOF)

  //A function which applies a function n time over a given value
  //nTimes(f, n, x)
  //nTimes(f, 3, x) would mean f(f(f(x)))
  def nTimes(f:Int => Int, n: Int, x: Int): Int =
    if(n <= 0) x
    else nTimes(f, n-1, f(x))

  val incrementer = (x:Int) => x + 1
  println(nTimes(incrementer, 10, 1))

  // ntb(f,n) = x => f(f(f...(x)))
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne....(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(incrementer, 10)
  println(plus10(10))

  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)  // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))
}
