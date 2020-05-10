package Exceptions
import java.io.FileReader
import java.io.FileNotFoundException

object Exceptions {
  // Object => Throwable => Exceptions

  def main(args: Array[String]) {
    try {
      val f = new FileReader("file.txt")
    } catch {
      case ex: FileNotFoundException =>{
        println("Missing file exception")
      }
    }
      /*
    finally {
      println("Finally do this")
    }

       */

    val e = new ExceptionExample()
    try{
      e.validate(5)
    }catch{
      case e : Exception => println("Exception Occured: " + e)
    }
  }
}

