package lectures.part2oop
/*
  Created by  : Ribhu Kashyap
  Created on  : 31/05/2020
  Purpose     : Demonstrate case classes in Scala
 */
object CaseClasses extends App {

  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val ribhu = new Person("Ribhu", 34)
  println(ribhu.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(ribhu)

  // 3. equals and hashCode implemented OOTB
  val ribhu2 = new Person("Ribhu", 34)
  println(ribhu == ribhu2)

  // 4. CCs have handy copy method
  val ribhu3 = ribhu.copy(age = 35)
  println(ribhu3)

  // 5. CCs have companion objects
  val thePerson = Person
  val person1 = Person("MMMMM", 23)

  // 6. CCs are serializable

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

}