package lectures.part1basics

/*
  Created by  : Ribhu Kashyap
  Created on  : 28/05/2020
  Purpose     : Functions in Scala
 */
object Functions extends App {

  def scalaMethodExample(a:String, b:String, c:Int): String = a + b + c*2   //Parameterized function
  println(scalaMethodExample("Hello ", "this is a test ", 5))
  //-------------------------------------
  def paramLessFunction(): Int = 42   //Parameter less function
  println(paramLessFunction())
  println(paramLessFunction)
  //-------------------------------------
  //Append a string n number of times using recursive function
  //Recursion is the preferred way in Scala rather than loops
  def recursiveFuncConcatenate(str:String, n:Int): String = {
    if(n==1) str
    else str+ recursiveFuncConcatenate(str, n-1)
  }
  println(recursiveFuncConcatenate("Scala",5))
  //-------------------------------------
  //Function with return type Unit
  def funcWithReturnTypeUnit(myString:String, x:Int):Unit = println(myString+x)
  funcWithReturnTypeUnit("Hello Scala", 1)
  //-------------------------------------
  //Nested functions in code blocks
  def sampleNestedFunction(n:Int):Unit = {
    def printEvenNum(a:Int) = if(a%2==0) println("Even") else println("Odd")
    printEvenNum(n)
  }
  sampleNestedFunction(6)
  //-------------------------------------
  //Recursive factorial function
  def findFactorialMethod(n:Int):Int = if(n <= 0) 1 else n*findFactorialMethod(n-1)
    println("Factorial is : " + findFactorialMethod(5))

  //-------------------------------------
  //Recursive fibonacci function
  def fibonacciMethod(n:Int):Int = if(n<=2) 1 else fibonacciMethod(n-1) + fibonacciMethod(n-2)
  println("Fibonacci is : "+ fibonacciMethod(8))
  //-------------------------------------
  //Prime number check function
  def isPrime(n:Int):Boolean = {
    def loopUntil(temp:Int):Boolean = if (temp <= 1) true else (n % temp != 0) && (loopUntil(temp - 1))

      loopUntil(n/2)
  }
  println(isPrime(37))

  //-------------------------------------
  //Default arguments - Scala allows you to initialize the argument values in the function definition
   def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  //User can choose to call the function with only those argument values which he wants different from
  //the default values
  savePicture(width = 800)
  savePicture(height = 600, width = 800, format = "bmp")

}
