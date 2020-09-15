import scala.annotation.tailrec

//What are the 3 string interpolators in scala

//What is adv. of tail recursion in scala. Write a method to find Factorial using tail rec.
def tailRecursiveFactorial(n:Int):BigInt = {
  @tailrec
  def factTailRecursion(x:Int, accumulator: BigInt = 1):BigInt =
    if(x <= 0) accumulator
    else factTailRecursion(x-1, x*accumulator)
  factTailRecursion(n)   // TAIL RECURSION = use recursive call as the LAST expression
}
println("Factorial is : " + tailRecursiveFactorial(20000))  //Does not throw any Overflow exception


val stringList = List("ABC", "AEF", "GHI", "GKL", "JKL")
//Print the list in reverse using map
val reverseList = stringList.map( (elem: String) => {elem.reverse})
for (elem <- reverseList) {println(elem)}
//Print sublist of the list which have same starting char
println(stringList.groupBy(name => name.charAt(0)))


val list = List(1,2,3,4,5,6,7,8,9,10)
//Print the square of each member of the list using map
println(list.map(_ * 2))
//Print the total of all elements of the list using reduce
val sum = list.reduce( (x: Int, y: Int) => x + y)
println(sum)
//Print largest number in list
val res = list.reduce((x, y) => x max y)
println(res)

//What will be the output
val intList = List(1,2,3,4,5)
val m = 0 +: intList :+ 6
println(m)    //note the output of this - it prints List


val justDoSomething: () => Int = () => 3
println(justDoSomething) // function itself
println(justDoSomething()) // call

// Write anonymous Scala function which can take other functions as parameters
//e.g. anonFunc2(3, anonFunc1)

def square(x: Int): Int = {x * x}
def transformInt(x: Int, f: Int => Int) : Int = {f(x)}
val result = transformInt(3, square)
println (result)

val s = "This is a \n newline"
println(raw"This is a \n newline")
println(raw"$s")
