import scala.util.Random // Flow control
  
  // If / else syntax
  if (1 > 3) println("Impossible!") else println("The world makes sense.")
                                                  //> The world makes sense.
  
  if (1 > 3) {
  	println("Impossible!")
  } else {
  	println("The world makes sense.")
  }                                               //> The world makes sense.
  
  // Matching - like switch in other languages:
  val number = 3                                  //> number  : Int = 3
  number match {
  	case 1 => println("One")
  	case 2 => println("Two")
  	case 3 => println("Three")
  	case _ => println("Something else")
 	}                                         //> Three
 	
 	// For loops
 	for (x <- 1 to 4) {
 		val squared = x * x
 		println(squared)
 	}

val randomVar = new Random
	for(a <- 1 until 10) {
		val random1 = randomVar.nextInt()
			if(random1 % 2 == 0){
				random1 match{
					case 2 => println("2 is an even number")
					case 4 => println("4 is an even number")
					case 6 => println("6 is an even number")
					case 8 => println("8 is an even number")
					case _ => println("Even number bigger than expected")
				}
			}
			else{
				random1 match{
					case 1 => println("1 is an odd number")
					case 3 => println("3 is an odd number")
					case 5 => println("5 is an odd number")
					case 7 => println("7 is an odd number")
					case 9 => println("9 is an odd number")
					case _ => println("Odd number bigger than expected")
				}
			}
	}


  // While loops
  var x = 10                                      //> x  : Int = 10
  while (x >= 0) {
  	println(x)
  	x -= 1
  }
                                                  
  x = 0
  do { println(x); x+=1 } while (x <= 10)
                                                  
   // Expressions
   // "Returns" the final value in a block automatically
   
   {val x = 10; x + 20}                           //> res0: Int = 30
                                                
	 println({val x = 10; x + 20})            //> 30
	 
	 // EXERCISE
	 // Write some code that prints out the first 10 values of the Fibonacci sequence.
	 // This is the sequence where every number is the sum of the two numbers before it.
	 // So, the result should be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34

//start with 0 and print 0
//increment by 1 and print 1
//increment by 1 and print previous val + new val

//fibonacci of 5
// 0 1 1 2 3 5

def fibonacciMethod(n:Int):Int = {
	if(n<=2) 1
	else fibonacciMethod(n-1) + fibonacciMethod(n-2)
}
println(fibonacciMethod(6))