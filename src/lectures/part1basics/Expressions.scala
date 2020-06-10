package lectures.part1basics

/*
  Created by  : Ribhu Kashyap
  Created on  : 27/05/2020
  Purpose     : Expressions in Scala
 */
object Expressions extends App {
      val x = 1+2   //Expression
      val y = 2*2
      val z = y-x

      //-------------------------------------
      val isEven = y%2 == 0
      val isOdd = !isEven
      println(z,isEven, isOdd)

      //-------------------------------------
      println(1 == z)   //This is an expression which evaluates to a boolean value true
      println(!(x == 3) && (z == 1))    //Evaluates to false
      println(1+1+2*2)

      //-------------------------------------
      //IF condition in scala is an expression
      var mySimpleCondition = if(!(x == 3) && (z == 1)) "Pass" else "Fail"
      println(mySimpleCondition)
      println(if(!(x == 3) && (z == 1)) "Pass" else "Fail")
      //-------------------------------------
      var myNewVariable = 5
      var iterator = 0

      /* Not a recommended way in Scala to modify variables/side effects */
//      while(iterator<10) {
//        println(iterator)
//        iterator += 1
//      }

      //Everything in Scala is an expression
      var aWhileLoop = while(iterator<10)
                        {
                              println(iterator)
                              iterator += 1
                        }

      println(aWhileLoop)
      //-------------------------------------
      var myVariable1 = (mySimpleCondition)
      var myVariable2 = (myNewVariable = 6) //Expressions returning Unit. This prints () or void
      println(myVariable1, myVariable2)
      //-------------------------------------
      //Code blocks
      val aCodeBlock = {
           if(2<3) "2 is less than 3 " else "3 is less than 2"
      }
      println(aCodeBlock)

}
