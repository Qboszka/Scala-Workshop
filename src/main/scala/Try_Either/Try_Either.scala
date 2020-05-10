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
 (tryToDouble("3"))

  def squared(i: Int) = i * i

  //println(Right(42).map(squared))
  //println(Left(42).map(squared))

  def Either_function {
    val in = readLine("Type Either a string or an Int: ")
    val result: Either[String, Int] =
      try Right(in.toInt)
      catch {
        case e: NumberFormatException => Left(in)
      }
    println(result match {
      case Right(x) => s"You passed me the Int: $x, which I will increment. $x + 1 = ${x + 1}"
      case Left(x) => s"You passed me the String: $x"
    })
  }

  Either_function


/*
  val a: Either[String, Int] = Left("scala")

  println(a.left.map(_.size))
  println(a.right.map(_.toDouble))

 */



}
