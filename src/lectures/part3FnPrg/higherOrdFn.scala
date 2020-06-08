package lectures.part3FnPrg

object higherOrdFn extends App {
  //Any function with takes another function as an argument or returns a function as result is
  //called higher order function (HOF)

  //A function which applies a function n time over a given value
  //nTimes(f, n, x)
  //nTimes(f, 3, x) would mean f(f(f(x)))
  def nTimes(f:Int => Int, n: Int, x: Int): Int =
    if(n <= 0) x
    else nTimes(f, n-1, f(x))

  val incrementer = (x:Int) => x + 1
  println(nTimes(incrementer, 10, 1))

  // ntb(f,n) = x => f(f(f...(x)))
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne....(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(incrementer, 10)
  println(plus10(10))


}
