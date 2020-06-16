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

//---------------------------------
val words = "This,is,a, ,comma,separated, ,statement"
for{
  it <- words.split(",")
  if it != null
  if it.size > 0
}println(it)

val array1 = for{
  it <- words.split(",")
  if it != " "
  if it.size > 0
} yield {it}

//Ways to print the Array
println(array1.mkString(" "))
array1.foreach(println)
println(array1(0),array1(1),array1(2))

val powerOfTwo = for{i <- 1 to 8; power = 1 << i}yield {power}
