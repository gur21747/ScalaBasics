package lectures.part1basics
/*
  Created by  : Ribhu Kashyap
  Created on  : 28/05/2020
  Purpose     : Recursive functions in Scala
 */
import scala.annotation.tailrec

object Recursion extends App {
  def findFactorialMethod(n:Int):BigInt = if(n <= 0) 1 else n*findFactorialMethod(n-1)
  //println("Factorial is : " + findFactorialMethod(20000)) //---> java.lang.StackOverflowError

  //In the above recursion the compiler is keeping the intermediate calls & result in its
  //internal stack which has limited memory leading to overflow

  //To solve this we should use tail recursion by using @tailrec annotation
  def tailRecursiveFactorial(n:Int):BigInt = {
    @tailrec
    def findFactorialTailRecursionMethod(x:Int, accumulator: BigInt = 1):BigInt =
      if(x <= 0) accumulator
      else findFactorialTailRecursionMethod(x-1, x*accumulator)

      findFactorialTailRecursionMethod(n)   // TAIL RECURSION = use recursive call as the LAST expression
  }
  println("Factorial is : " + tailRecursiveFactorial(20000))  //Does not throw any Overflow exception

  //-------------------------
  //Tail recursive concatenation
  //Note that the default value of parameter accumulator has been initialized in the function args only so
  //it need not be passed in the caller
  def concatTailRecursive(str:String, n:Int, accumulator:String=""):String =
    if(n <= 0) accumulator
    else concatTailRecursive(str,n -1,str + accumulator)

  println(concatTailRecursive("hello",3))

  //-------------------------
  //Tail recursive fibonacci

  def fibonacci(n: Int): Int = {
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
  }
  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21



}
