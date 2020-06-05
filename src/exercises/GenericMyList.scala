package exercises
/*
  Created by  : Ribhu Kashyap
  Created on  : 01/06/2020
  Purpose     : Simple linked list implementation
 */

/*
Modify the generic list to perform the following operations -
[1,2,3].map(n*2) = [2,6,8]
[1,2,3,4].filter(n%2) = [2,4]
[1,2,3].flatMap(n => [n, n+1]) = [1,2,2,3,3,4]
 */
abstract class GenericMyList[+A] {      //Covariant list
  def head: A
  def tail: GenericMyList[A]
  def isEmpty:Boolean
  def add[B >: A](element: B): GenericMyList[B]
  def printListElements:String
  override def toString:String = "[" + printListElements + "]"

  //--- Function signatures for map, filter and flatMap ---
  def map[B](transform: myTransform[A,B]): GenericMyList[B]
  def flatMap[B](transform: myTransform[A, GenericMyList[B]]): GenericMyList[B]
  def filter(predicate: myPredicate[A]):GenericMyList[A]

  //concatenation
  def ++[B >: A](list: GenericMyList[B]):GenericMyList[B]
}

case object Empty extends GenericMyList[Nothing]{    //Create an empty list with only the head element
  def head:Nothing = throw new NoSuchElementException
  def tail:GenericMyList[Nothing] = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add[B >: Nothing](element: B):GenericMyList[B] = new constructGenericList(element,Empty)
  def printListElements: String = " "
  override def toString: String = "[" + printListElements + "]"

  //--- Empty implementation for map, filter and flatMap ---
  def map[B](transform: myTransform[Nothing,B]): GenericMyList[B] = Empty
  def flatMap[B](transform: myTransform[Nothing, GenericMyList[B]]): GenericMyList[B] = Empty
  def filter(predicate: myPredicate[Nothing]):GenericMyList[Nothing] = Empty

  def ++[B >: Nothing](list: GenericMyList[B]):GenericMyList[B] = list

}

case class constructGenericList[+A](h:A, t:GenericMyList[A]) extends GenericMyList[A]{
  def head:A = h
  def tail:GenericMyList[A] = t
  def isEmpty:Boolean = false
  def add[B >: A](element: B):GenericMyList[B] = new constructGenericList(element, this)
  def printListElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printListElements

  //--- Cons implementation for map, filter and flatMap ---
  def map[B](transformer: myTransform[A,B]): GenericMyList[B] =
      new constructGenericList(transformer.transform(h), t.map(transformer))

  def ++[B >: A](list: GenericMyList[B]):GenericMyList[B] =
      new constructGenericList(h, t ++ list)
  def flatMap[B](transformer: myTransform[A, GenericMyList[B]]): GenericMyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  def filter(predicate: myPredicate[A]): GenericMyList[A] = {
      if(predicate.test(h)) new constructGenericList(h, t.filter(predicate))  //head is returning TRUE
      else t.filter(predicate)    //head did not pass the test i.e. return TRUE
  }

}

trait myPredicate[-T]{
  def test(elem:T): Boolean   //returns TRUE when predicate.test(head or tail) passes
}
trait myTransform[-A, B]{
  def transform(elem:A):B     //returns the value evaluated by myTransform.transform(element)
}

object genListTest extends App {
  //list of Integers
  val list1: GenericMyList[Int] =
      new constructGenericList(1,new constructGenericList(2, new constructGenericList(3, Empty)))
  val list3: GenericMyList[Int] =
    new constructGenericList(4,new constructGenericList(5, Empty))
  val copyOfList1: GenericMyList[Int] =
    new constructGenericList(1,new constructGenericList(2, new constructGenericList(3, Empty)))
  val list4: GenericMyList[Int] =
    new constructGenericList(3,new constructGenericList(2, new constructGenericList(1, Empty)))
  //list of Strings
  val list2: GenericMyList[String] =
      new constructGenericList("AAA",new constructGenericList("BBB", new constructGenericList("CCC", Empty)))

  println(list1.toString)
  println(list2.toString)

  println(list1.map(new myTransform[Int, Int]  {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(list1.filter(new myPredicate[Int]  {
    override def test(elem: Int): Boolean = (elem % 2) == 0
  }).toString)

  //Check concatenation is working fine
  println(list1 ++ list3)
  println(list1.flatMap(new myTransform[Int, GenericMyList[Int]] {
    override def transform(elem: Int): GenericMyList[Int] =
      new constructGenericList(elem, new constructGenericList(elem + 1, Empty))}).toString)

  //case object demo
  println(list4 == list1)
  println(copyOfList1 == list3)

}

