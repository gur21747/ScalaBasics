package lectures.part3FnPrg
/*
  Created by  : Ribhu Kashyap
  Created on  : 02/06/2020
  Purpose     : Demonstrate map, flatMap and filter in Scala
 */
object MapFlatmapFilter extends  App{

  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val numbers = List(1020,2020,3030,4040)
  val names = List("aaa","bbb","ccc","ddd")
  val location = List("Gurgaon", "Noida")

  // List("aaa-1020", "aaa-2020"... "ddd-4040")
  //For every number n in the "numbers" list we need to traverse every name
  val combination1 = numbers.flatMap(n => names.map(c => "" + c + "-" + n))
  println(combination1)

  //List(aaa1020-Gurgaon, aaa1020-Noida, bbb1020-Gurgaon,.... ddd4040-Noida)
  //This works like a 3 way loop with two flat maps and one map
  val combination2 = numbers.filter(_ % 2 == 0).flatMap(n => names.flatMap(c => location.map(
                                                                  color => "" + c + n + "-" + color)))
  println(combination2)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0  // the if condition is called guard is same as numbers.filter(_ % 2 == 0)
    c <- names
    loc <- location
  } yield "" + c + n + "-" + loc
  println("for combinations - " + forCombinations)

  for {   //println for each element of list numbers
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

}
