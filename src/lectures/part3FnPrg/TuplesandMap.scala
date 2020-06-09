package lectures.part3FnPrg
/*
  Created by  : Ribhu Kashyap
  Created on  : 03/06/2020
  Purpose     : Demonstrate inheritance in Scala
 */
object TuplesandMap extends App {

  //Tuples are finite ordered lists
  val tupleEmployee1 = new Tuple3(1000, "AAA", "GGN")
  val tupleEmployee2 = Tuple3(1001, "BBB", "GNA")
  val tupleEmployee3 = (1002, "CCC", "HYD")

  println("Employee ID = " + tupleEmployee3._1 +
          " Employee name = "+tupleEmployee3._2 +
          " Employee location = "+tupleEmployee3._3 +
          " Employee3 record modified = " + tupleEmployee3.copy(_3 = "USA") + //Note location of tupleEmployee3
          " Employee1 record swapped = " + tupleEmployee1.copy(_3 = tupleEmployee3._3)) //Note the change above is local

  //Maps are key -> Value pairs
  val employeeNameIdMap: Map[String, Int] = Map()
  val mapOfEmp = Map(("AAA", 1000),
                  ("BBB", 1001),
                  ("CCC", 1002),
                  ("DDD" -> 1003)) //a->b is syntactic sugar for (a,b)
  println("Map is : " + mapOfEmp)
  println(mapOfEmp.contains("CCC"))   //Query the map for a key
  println(mapOfEmp("CCC"))            //Get the value associated with the key

  // add new key-value pair to the map
  val newPairing = "EEE" -> 1004
  val newPairing2 = "FFF" -> 1005
  val newMapOfEmp = mapOfEmp + newPairing + newPairing2 //Adds in the map, not an ordered add
  println(newMapOfEmp)

  // function on maps
  // map, flatMap, filter
  println(newMapOfEmp.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(newMapOfEmp.filterKeys(x => x.startsWith("D")))

  // mapValues
  println(newMapOfEmp.mapValues(number => "GGN001-" + number)) //Prefix a string with values

  // conversions to other collections
  println(newMapOfEmp.toList)
  println(List(("GGG", 555)).toMap)
  val names = List("vikas", "ravi", "sahil", "mahendra", "rishi", "vivek")
  println(names.groupBy(name => name.charAt(0)))    //Create sublist of names which have same starting char

}
