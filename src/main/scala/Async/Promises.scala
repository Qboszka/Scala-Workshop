package Async

import scala.concurrent._
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Promises extends App {
  val p = Promise[String]
  p.future foreach (x => println(s"p succeeded with '$x'"))
  Thread.sleep(1000)
  p success "assigned"
  Thread.sleep(1000)

  val q = Promise[String]
  q failure new Exception("not kept")
  q.future.failed foreach (t => println(s"q failed with $t"))
  Thread.sleep(1000)
}


