package Sync
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.concurrent.Future

class Counter {

  var count: Int = 0

  def increment(): Unit =
    count += 1

  def incrementSynchronized(): Unit =
    this.synchronized {
      count += 1
    }
}

object Increment extends App {
  val counter = new Counter()
  for (_ <- 1 to 100000) {
    Future {
      counter.increment()
    }
  }
  Thread.sleep(1000)
  println(counter.count)
}




