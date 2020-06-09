def square(x: Int) = x * x

def diff(x: Int, y:Int) = x - y

//def add(x: Int, y:Int) = x + y
def add(x: String, y:String) = x + y

square(2)
diff(5,2)
//add(5,2)
add("hello"," Ribhu")

val list = List(1,2,3)
val toPair = (x: Int) => List(x, x+1)
println(list.flatMap(toPair))
