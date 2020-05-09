package String_interpolation

object Interpolators {

  implicit class LowercaseInterpolator(sc: StringContext) {

    def lowercase(args: Any*): String = {
      val strings = sc.parts.iterator
      val expressions = args.iterator

      val buffer = new StringBuffer(strings.next)
      while(strings.hasNext) {
        buffer append expressions.next
        buffer append strings.next
      }
      buffer.toString.toLowerCase()
    }
  }
}
