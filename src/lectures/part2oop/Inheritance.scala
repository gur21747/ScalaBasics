package lectures.part2oop
/*
  Created by  : Ribhu Kashyap
  Created on  : 31/05/2020
  Purpose     : Demonstrate inheritance in Scala
 */
object Inheritance extends App {
  // single class inheritance
  sealed class Employee {
    val empLocation = "Gurugram"
    val empOffice = "SEZ Tikri"
    def printEmpLocation = println(s"Employee works at ${empOffice} in ${empLocation}")
  }

  class ContractEmployee extends Employee {
    val contractorLoc = "Noida"
    def printContractorLoc = {
      printEmpLocation
      println("Located at Noida")
    }
  }

  val contractor1 = new ContractEmployee
  contractor1.printContractorLoc

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Intern(override val empOffice: String) extends Employee {
    //override val empOffice = "DLF"
    override def printEmpLocation = {
      super.printEmpLocation
      println("Located at DLF")
    }
  }
  val intern1 = new Intern("DLF")
  intern1.printEmpLocation
  println(intern1.empLocation, intern1.empOffice)


  // type substitution (broad: polymorphism)
  val unknownEmployee: Employee = new Intern("HYD")
    println(unknownEmployee.empOffice)

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in the current file, prevent extension in other files
}
