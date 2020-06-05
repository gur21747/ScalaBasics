package lectures.part2oop

import java.io.Writer

/*
  Created by  : Ribhu Kashyap
  Created on  : 30/05/2020
  Purpose     : Initial Creation
 */

class Person1
class Person2(age:Int, name:String)   //constructor declared with class parameters only
class Person3(val age:Int, val name:String)  //class parameters converted to class fields by adding "val"
abstract class Person4 {  //abstract class
  val name:String
  val age:Int
}
class Person5(val age:Int, val name:String){  //The whole block of class will be executed with each instantiation
  val x = 5
  println(x+1)
}
class Person6(val age:Int, val name:String){  //The whole block of class will be executed with each instantiation
 def method1(name:String): Unit = println(s"Hello $name")
 def method2(name:String): Unit = println(s"Hello ${this.name}")
 def method2(): Unit = println(s"Hello $name")    //Overloaded method

}

//------------------------
class writer(firstName:String, surName:String, val yearOfBirth:Int){  //yearOfBirth needs to be declared val
  def fullName = s"$firstName $surName"                               //to be accessed from novel class
}
class novel(name:String, yearOfRelease:Int, author:writer) {
  def authorAge = yearOfRelease - author.yearOfBirth
  def isAuthoredBy(author:writer) = author == this.author
  def copy(newYear:Int) = new novel(name, newYear, author)
}

object OOBasics extends App {

  val person1 = new Person1
  println(person1)

  val person2 = new Person2(30, "BBB")
  //println(person2.age) -- This is not allowed in Scala. Class parameters are not fields.

  val person3 = new Person3(30,"CCC")
  println(person3.age, person3.name)

  val person4 = new Person4 {
    override val name: String = "AAA"
    override val age: Int = 30
  }
  println(person4.age, person4.name)

  val person5 = new Person5(30, "DDD")
  println(person5.age, person5.name, person5.x)   //Notice that 6 is printed as well.

  val person6 = new Person6(30, "ZZZ")
  person6.method1("ABCEDF")
  person6.method2("ABCEDF")   //Notice that ZZZ will be printed here because of {this.name}
  person6.method2()   //Overloaded method call
  //------------------------

  val writer1 = new writer("Fyodor", "Dostoevsky",1821)
  val writer2 = new writer("Leo", "Tolstoy",1828)
  val novel1 = new novel("Crime and Punishment", 1866, writer1)
  val novel2 = new novel("War and Peace", 1867, writer2)


  println(writer1.fullName + " is " + novel1.authorAge + " years old")
  println(writer2.fullName + " is " + novel2.authorAge + " years old")

  if(novel1.isAuthoredBy(writer2))
      println("Crime and Punishment is written by Tolstoy")
  else if(novel1.isAuthoredBy(writer1))
      println("Crime and Punishment is written by Dostoevsky")

  if(novel2.isAuthoredBy(writer2))
    println("War and Peace is written by Tolstoy")
  else if(novel2.isAuthoredBy(writer1))
    println("War and Peace is written by Dostoevsky")

//  println("Crime and Punishment is written by Tolstoy : " + novel1.isAuthoredBy(writer2))
//  println("War and Peace is written by Tolstoy : " + novel2.isAuthoredBy(writer2))
//  println("Crime and Punishment is written by Dostoevsky : " + novel1.isAuthoredBy(writer1))
//  println("War and Peace is written by Dostoevsky : " + novel2.isAuthoredBy(writer1))
}

