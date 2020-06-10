package lectures.part2oop

import lectures.part2oop.Objects.Employee

/*
  Created by  : Ribhu Kashyap
  Created on  : 31/05/2020
  Purpose     : Demonstrate Generic datatype in Scala
 */
object Generics extends App {
  class myGenericList[Type]{    //Type is a generic datatype
  }
  val listOfInt = new myGenericList[Int]
  val listOfStr = new myGenericList[String]
    //...
  class myGenericMap[key, value]{
  }
  val map1 = new myGenericMap[Int, String]
  val map2 = new myGenericMap[Int, Int]
    //...
  //Methods can also be generic
  object myGenericList{
    def addToList[A]: myGenericList[A] = ???
  }
  val newList = myGenericList.addToList[Int]

  class Employee
  class permanentEmployee extends Employee
  class contractorEmployee extends Employee

  val employee:Employee = new permanentEmployee
  //Covariance -- List of permanentEmployees extends list of Employee
  class CovariantList[+Type]
  val permEmployeeList:CovariantList[Employee] = new CovariantList[permanentEmployee]
  val contEmployeeList:CovariantList[Employee] = new CovariantList[contractorEmployee]

  //Invariance
  class InvariantList[Type]
  val employeeList:InvariantList[Employee] = new InvariantList[Employee]
  //employeeList cannot be an invariant list of permanent or contractor employees

  //Contravariance
  class ContravariantList[-Type]
  val permanentEmployees:ContravariantList[permanentEmployee] = new ContravariantList[Employee]

  //bounded types
  //class EmployeeLocation only accepts type parameters "Type" which are subtypes of Employee
  class EmployeeLocation[Type <: Employee](employee: Employee)
  val locationOfPermanent = new EmployeeLocation(new permanentEmployee)
  val locationOfContractor = new EmployeeLocation(new contractorEmployee)

  class MyList[+A] {
    // use the type B which is super type of A
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = permanentEmployee
      B = Employee
     */
  }
}
