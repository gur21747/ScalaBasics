package SparkScripts
/*
  Created by      : Ribhu Kashyap
  Created on      : 06/15/20
  Purpose         : This script computes the daily mortality rate of covid cases
                    for a given country. It shows a comparison of India's covid
                    mortality rate with that of any other country.
  Data source     : https://github.com/owid/covid-19-data/tree/master/public/data
  Validated with  : https://coronavirus.jhu.edu/data/mortality
 */

import org.apache.spark._
import org.apache.spark.SparkContext
import org.apache.log4j._

object DemoCovidMortalityRate {

  def totalCases(line: String):(Double) = {
    val fields  = line.split("\t")
    val cases   = fields(4).toDouble

    cases
  }
  def totalDeaths(line: String):(Double) = {
    val fields    = line.split("\t")
    val mortality = fields(6).toDouble

    mortality
  }
  //main begins
  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.ERROR)

    // Create a SparkContext using every core of the local machine, named demo1
    val sc            = new SparkContext("local[*]", "demo1")
    val lines         = sc.textFile("../SparkScala/ml-100k/world-covid-data")
    val country1      = "IND"
    val country2      = "BEL"
    val linesIndia    = lines.filter(line => line.contains(country1))
    val linesCountry2 = lines.filter(line => line.contains(country2))

    val rddOfCasesInd     = linesIndia.map(totalCases)
    val rddOfDeathsInd    = linesIndia.map(totalDeaths)
    val result1Ind        = rddOfCasesInd.collect()
    val result2Ind        = rddOfDeathsInd.collect()

    val rddOfCasesCountry2  = linesCountry2.map(totalCases)
    val rddOfDeathsCountry2 = linesCountry2.map(totalDeaths)
    val result1Country2     = rddOfCasesCountry2.collect()
    val result2Country2     = rddOfDeathsCountry2.collect()

    for(it <- 0 until result2Ind.size){
      if((result1Country2(it) > 0.0)
        //&& (result2Country2(it) > 0.0)
        //&& (result2Ind(it) > 0.0)
        && (result1Ind(it) > 0.0)) {
        var rateInd     : Double = result2Ind(it) / result1Ind(it) * 100.00
        var rateCountry2: Double = result2Country2(it) / result1Country2(it) * 100.00
        println(f"DAY[$it] | $country2 = $rateCountry2%.2f | $country1 = $rateInd%.2f")
      }
    }

  }//main ends
}

