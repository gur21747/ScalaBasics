  // Functions
  
  // Format is def <function name>(parameter name: type...) : return type = { expression }
  // Don't forget the = before the expression!
  def squareIt(x: Int) : Int = {
  	x * x
  }                                               //> squareIt: (x: Int)Int
  
  def cubeIt(x: Int): Int = {x * x * x}           //> cubeIt: (x: Int)Int
  
  println(squareIt(2))                            //> 4
  
  println(cubeIt(2))                              //> 8
  
  // Functions can take other functions as parameters
  
  def transformInt(x: Int, f: Int => Int) : Int = {
  	f(x)
  }                                               //> transformInt: (x: Int, f: Int => Int)Int
  
  val result = transformInt(2, cubeIt)            //> result  : Int = 8
  println (result)                                //> 8
  
  // "Lambda functions", "anonymous functions", "function literals"
  // You can declare functions inline without even giving them a name
  // This happens a lot in Spark.
  transformInt(3, x => x * x * x)                 //> res0: Int = 27
  
  transformInt(10, x => x / 2)                    //> res1: Int = 5
  
  transformInt(2, x => {val y = x * 2; y * y})    //> res2: Int = 16
  
  // This is really important!
  
  // EXERCISE
  // Strings have a built-in .toUpperCase method. For example, "foo".toUpperCase gives you back FOO.
  // Write a function that converts a string to upper-case, and use that function of a few test strings.
  // Then, do the same thing using a function literal instead of a separate, named function.

  def upperCase(string: String):String  = string.toUpperCase
  def lowerCase(string: String):String  = string.toLowerCase
  def countChar(string: String):Int     = string.length
  def transformString(inStr:String,
                          upperCase: String => String,
                          lowerCase: String => String,
                          whichCase: String,
                          countChar: String => Int):
  String = {
    whichCase match {
      case "UPPER" => upperCase(inStr) + " of length = " + countChar(inStr)
      case "lower" => lowerCase(inStr) + " of length = " + countChar(inStr)
      case _       => inStr + " of length = " + countChar(inStr)
    }
  }
  println(transformString("mIxEdCaSeStRiNg", upperCase, lowerCase, "UPPER", countChar))
  println(transformString("mIxEdCaSeStRiNg", upperCase, lowerCase, "lower", countChar))
  println(transformString("mIxEdCaSeStRiNg", upperCase, lowerCase, " ", countChar))

  //Lambda representation of string transform Fn
  def transformString2(inStr:String, f:String => String):String = { f(inStr) }
  def transformString3(inStr:String, f:String => Int):Int = {f(inStr)}
  println(transformString2("mIxEdCaSeStRiNg",upperCase))
  println(transformString2("mIxEdCaSeStRiNg",lowerCase))
  println(transformString3("mIxEdCaSeStRiNg",countChar))

  transformString2("mIxEdCaSeStRiNg", x => x.toUpperCase)
  transformString2("mIxEdCaSeStRiNg", x => x.toLowerCase)
  transformString3("mIxEdCaSeStRiNg", x => x.length)

  def factorial(x:Int, accumulator:Int): Int =
    if(x <= 0) accumulator
    else factorial(x-1, x*accumulator)

  //lambda representation of factorial Fn
  def getFactorial(x:Int, acc:Int, f:(Int,Int) => Int):Int = {f(x,acc)}
  println(getFactorial(5,1,factorial))
  println(getFactorial(7,1,factorial))
  println(getFactorial(10,1,factorial))
