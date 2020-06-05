package lectures.part2oop
/*
  Created by  : Ribhu Kashyap
  Created on  : 31/05/2020
  Purpose     : Demonstrate inheritance in Scala
 */
import lectures.part2oop.Inheritance.Employee

object AbstractTypes extends App {
  // abstract
  abstract class empAttributes {
    val empType: String = "Permanent"
    def printEmpType: Unit
  }

  class contractor extends empAttributes {
    override val empType: String = s"Contractor employee"
    def printEmpType: Unit = println(s"$empType staff")
  }

  val contractEmployee1 = new contractor
  println(contractEmployee1.empType)
  contractEmployee1.printEmpType

  // traits
  trait extStaff {
    def printEmpType(emp1 : empAttributes): Unit
    val preferredLocation: String = "Temp Location"
  }

  trait thirdPartyStaff
  class empIDCard extends empAttributes with extStaff with thirdPartyStaff {
    override val empType: String = "External Staff/GGN"
    def printEmpType: Unit = println("EXT.GGN.100")
    def printEmpType(emp1 : empAttributes): Unit = println(s"External staff works at DLF ${emp1.empType}")
  }

  val contractor2 = new contractor
  val card1 = new empIDCard
  println(card1.empType)
  card1.printEmpType
  println(card1.preferredLocation)    //Field defined in trait
  card1.printEmpType(contractor2)


  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be  inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"

}
