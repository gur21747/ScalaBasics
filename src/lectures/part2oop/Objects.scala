package lectures.part2oop
/*
  Created by  : Ribhu Kashyap
  Created on  : 30/05/2020
  Purpose     : Objects in Scala
 */
object Objects extends App {

  object Employee{    //Objects are singleton instances
    val _empLocation = "Gurugram"
    val _empOffice = "SEZ Tikri"
    def _printEmpLocation = println(s"Employee works at ${_empOffice} in ${_empLocation}")

    // factory method
    def apply(e1: Employee, e2: Employee): Employee = new Employee
  }
  println(Employee._empLocation, Employee._empOffice)
  Employee._printEmpLocation

  val emp1 = Employee
  val emp2 = Employee
  println(emp1 == emp2)   //Prints true

  class Employee{
    //Some implementation
  }
  val employee1 = new Employee
  val employee2 = new Employee
  println(employee1 == employee2)   //Prints False
  val employee3 = Employee(employee1,employee2)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit


}
