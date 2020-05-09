package Options

object Options extends App {

    // val x : Int = null
    // val y : Boolean = null

    val list : List[String] = null

    try { list.appended() } catch {
      case e: NullPointerException => println("Odwołanie do nulla")
    }

  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }


  //null "" "5"
  val i = toInt("")
  println(i)
  //println(i.get)
  println(i.getOrElse("10"))


  toInt("5") match {
    case Some(x) => println(x)
    case None => println("That didn't work.")
  }
}
