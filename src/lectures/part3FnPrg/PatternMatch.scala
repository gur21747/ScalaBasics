package lectures.part3FnPrg
/*
  Created by  : Ribhu Kashyap
  Created on  : 03/06/2020
  Purpose     : Demonstrate switch case aka match in Scala
 */
import scala.util.Random

object PatternMatch extends App {

    val random = new Random
    val x = random.nextInt(10)

    val description = x match {
      case 1 => "ONE"
      case 2 => "TWO"
      case 3 => "THREE"
      case _ => "unknown"  // _ = WILDCARD
    }

    println(x)
    println(description)

    // 1. Decompose values
    case class Person(name: String, age: Int)
    val person1 = Person("AAA", 20)

    val greeting = person1 match {
      case Person(n, a) if a < 21 => s"Hi, my name is $n"
      case Person(n, a) => s"Hi, my name is $n and I am $a years old"
      case _ => "unknown"
    }
    println(greeting)


  //To be continued....

  }
