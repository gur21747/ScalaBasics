package lectures.part2oop
/*
  Created by  : Ribhu Kashyap
  Created on  : 30/05/2020
  Purpose     : Infix and  Prefix method notations
 */

class Car(val engineCC:Int, val color:String, val fuelType:String){
  def checkEngine(howManyCC:Int):Boolean = howManyCC == engineCC
  def checkColor(whichColor:String):Boolean = whichColor == color
  def checkFuelType(whatFuelType:String):Boolean = whatFuelType == fuelType
  def >(bigCar:Car) = {
    if(bigCar.engineCC > this.engineCC) println(s"${bigCar.engineCC}cc is a bigger engine than ${this.engineCC}cc")
    else println(s"${this.engineCC}cc is a bigger engine than ${bigCar.engineCC}cc")
  }
  def <(bigCar:Car):Unit = {
    if(bigCar.fuelType == "diesel") println(s"${bigCar.fuelType} engine of ${bigCar.engineCC}cc is powerful")
    else println(s"${this.fuelType} engine is less powerful")
  }
  def unary_+ : Car = new Car(engineCC, color, fuelType)
  def +(carName:String) : Car = new Car(engineCC, s"$color ($carName)", fuelType)

  def unary_! : String = {
    if (this.color.equals("red")) s"Same color"
    else s"Not the same color"
  }
  def apply(): String = s"The car engine is ${this.engineCC}cc and I like its color ${color}"
  def apply(n: Int): String = s"The car is driven $n times"

}
object MethodNotation extends App {
  val newCar = new Car(1200,"white","petrol")
  val biggerCar = new Car(2000,"red", "diesel")
  println(newCar.checkEngine(1200))
  println(newCar.checkColor("Red"))
  println(newCar.checkFuelType("Petrol".toLowerCase))

  //Scala infix notation allows the following. (Also called syntactic sugars)
  //It only works with methods which have single (only 1) parameter
  println(newCar checkEngine 1200)
  println(newCar checkColor "white")
  println(newCar checkFuelType "Diesel")
  biggerCar > newCar    //same as biggerCar.>(newCar)
                        // operator notation for method name is valid in Scala
  newCar < biggerCar    //In this notation "<" is the method name and biggerCar is the argument
  newCar.<(biggerCar)

  println("------------------------")
  //Mathematical Operators are all working in same way
  println(1.+(2)) // == println(1+2)
  println(2.*(2)) // == println(2*2)

  //In scala - All operators are methods

  // prefix notation
  val x = -1  // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !
  println(x,y)

  println(!biggerCar)

  // apply
  println(newCar.apply())
  println(biggerCar())  //equivalent to the above -- whenever compiler sees object name followed by ()
                        //it looks for the definition of apply and executes it
  println(newCar.apply(5))
  println(biggerCar(10))

  val newCar1 = +newCar
  val newCar2 = +newCar
  val newCar3 = +newCar
  println(newCar1.engineCC, newCar2.color, newCar3.fuelType)
  println((newCar + "Honda").apply())

}
