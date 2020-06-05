package exercises

import scala.collection.immutable.Stream.Empty

/*
  Created by  : Ribhu Kashyap
  Created on  : 31/05/2020
  Purpose     : Simple linked list implementation
 */
abstract class MyList {
 /* Create a list which has the following -
    1. head - start/first element of the list
    2. tail - remainder of the list excluding the head
    3. isEmpty method - check if the list is empty
    4. add(int) - add an integer element to the list
    5. toString method - print the list as a string
 */

  def head:Int
  def tail:MyList
  def isEmpty:Boolean
  def add(element: Int):MyList
  def printListElements:String
  override def toString:String = "[" + printListElements + "]"
}

object empty extends MyList{    //Create an empty list with only the head element
  def head:Int = throw new NoSuchElementException
  def tail:MyList = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add(element: Int):MyList = new constructList(element,empty)
  def printListElements: String = " "
  override def toString: String = "[" + printListElements + "]"
}

class constructList(h:Int, t:MyList) extends MyList{
  def head:Int = h
  def tail:MyList = t
  def isEmpty:Boolean = false
  def add(element: Int):MyList = new constructList(element, this)
  def printListElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printListElements
}

object testList extends App{
  val list1 = new constructList(1,empty)  //Construct an empty list with only head
  println(s"List 1 head -> ${list1.head}")

  val list2 = new constructList(1,new constructList(2, new constructList(3, empty)))
  println(s"List 2 head -> ${list2.head}")
  println(s"List 2 tail's head -> ${list2.tail.head}")
  println((list2.add(4)).toString)    //Adding element to head
  println(list2.toString)

}
