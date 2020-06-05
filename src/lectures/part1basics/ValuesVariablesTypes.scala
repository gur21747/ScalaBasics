package lectures.part1basics

/*
  Created by  : Ribhu Kashyap
  Created on  : 27/05/2020
  Purpose     : Initial Creation
 */
object ValuesVariablesTypes extends App {
    val x:Int = 42    //The value of x is constant (like static final) and cannot be reassigned
                      // .e.g x = 2 will be an error. All vals are immutable
    val newInt:Int = x
    val a:Short = 5678
    val b:Long = 3565376565368L

    val str:String = "Hello"
    val str2:String = str

    val y:Float = 4.2f
    val c:Double = 3.14159265358979323846

    val z:Char = 'A'
    val z1 = z       //Type is optional. Compiler infers the type of val

    val boolValT:Boolean = true; //';' is optional
    val boolValF:Boolean = false


  println(x, newInt,a,b,str,str2,y,c,z,z1,boolValT,boolValF)

  //--------------------- Variables -------------------

  var myInt:Integer = 5;    //In contrast to val, a var can be re-assigned
  myInt = 10;


}
