package playground

import scala.util.Random

object compareListVsVector extends App {

  //Compare the performance of List Vs Vector by calculating average write time
  //---------------------------------------------------------------------------
  val maxRuns = 1000        //Max times the for iteration will run
  val maxElements = 1000000   //Max elements the collection can have
  def compareListVsVector(collection: Seq[Int]):Double = {
    val randomInt = new Random
    val times = for{      //times will be a list of timestamps calculated by the difference
      it <- 1 to maxRuns       //between system time before write and after write.
      } yield {
      val currentTime = System.nanoTime()   //get system time before write operation
      collection.updated(randomInt.nextInt(maxElements), randomInt.nextInt())
      System.nanoTime() - currentTime       //get difference of current time and timestamp before write
    }
    //times.sum * 1.0 / maxRuns
    times.sum * 1.0 / times.size
  }

  //Define list and vector to test performance
  val list1 = (1 to maxElements).toList
  val vector1 = (1 to maxElements).toVector

  println(compareListVsVector(list1))
  println(compareListVsVector(vector1))

}
