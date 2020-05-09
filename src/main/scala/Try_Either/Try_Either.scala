package Try_Either

import scala.util.{Failure, Success, Try, Either, Left, Right}
import scala.io.StdIn.readLine

object Try_Either extends App {

  def divide: Try[Int] = {
    val dividend = Try(readLine("Enter an Int that you'd like to divide:\n").toInt)
    val divisor = Try(readLine("Enter an Int that you'd like to divide by:\n").toInt)
    val problem = dividend.flatMap(x => divisor.map(y => x/y))
    problem match {
      case Success(v) =>
        println("Result of " + dividend.get + "/"+ divisor.get +" is: " + v)
        Success(v)
      case Failure(e) =>
        println("You must've divided by zero or entered something that's not an Int. Try again!")
        println("Info from the exception: " + e.getMessage)
        divide
    }
  }

  def tryToDouble(s: String): Try[Double] = {
    Try(s.toDouble)
  }

 // (divide)
 // (tryToDouble("3"))

  def squared(i: Int) = i * i
  println(Right(42).map(squared))
  println(Left(42).map(squared))


}
