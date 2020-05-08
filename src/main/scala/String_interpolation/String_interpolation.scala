package String_interpolation
import Interpolators.UppercaseInterpolator

object String_interpolation extends App {

  /*

  String Interpolators:
  - s
  - f
  - raw

   */

  def add(a:Int, b:Int):Int
  =
  {
    a+b
  }

    val x = 100
    val y = 200

    // without s interpolator
    val str1 = "Sum of $x and $y is ${add(x, y)}"

    // with s interpolator
    val str2 = s"Sum of $x and $y is ${add(x, y)}"

    println(str1)
    println(str2)

    // escaping or using raw
  val str3 = s"a\nb"
  val str4 = raw"a\nb"
  val str5 = """a\nb"""

  println(str3)
  println(str4)
  println(str5)

  // f means formatted (type safe)
  val height = 1.85
  val name = "Jakub"

  println(f"$name%s is $height%2.2f meters tall")

  // using own interpolator

  val lower : String = lowercase"This STRING wiLL Contain only SMALL letters"
  println(lower)



}

