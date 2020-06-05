package lectures.part1basics

/*
  Created by  : Ribhu Kashyap
  Created on  : 28/05/2020
  Purpose     : Initial Creation
 */
object CallByValue_CallByReference extends App {

  def systemNanoTime():Long = {
      println("Calling systemNanoTime")
      System.nanoTime()
  }

  // In the call-by-value version, the side-effect of the passed-in function
  // call (to systemNanoTime()) only happened once. This is because call-by-value
  // functions compute the passed-in expression's value before calling the
  // function, thus the same value is accessed every time.
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)

  }

  //In call-by-name the call to the function happens twice which is why
  //it prints the updated time both times. call-by-name functions recompute the
  //passed-in expression's value every time it is accessed.
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(systemNanoTime())
  println("------------------------------")
  calledByName(systemNanoTime())

  println("------------------------------")
  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //  printFirst(infinite(), 34)    -- This would crash the system
  printFirst(34, infinite())      //-- This is a valid call because only the argument which is used in printFirst Fn
                                  //   is computed and call to infinite() is not made

}
