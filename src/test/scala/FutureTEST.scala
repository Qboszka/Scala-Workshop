import java.util.NoSuchElementException

import org.scalatest.FeatureSpec

import scala.concurrent.duration._
import scala.language.postfixOps
import scala.concurrent.{Await, Future, TimeoutException}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}


class FutureSpec extends FeatureSpec {

  scenario("Future result is awaited") {
    val future: Future[Int] = Future {
      Thread.sleep(1000)
      1
    }
    val actual: Int = Await.result(future, 2 seconds)
    val expected: Int = 1
    assert(actual == expected)
  }

  scenario("Accessing Future value when it is not completed") {
    val future: Future[Int] = Future {
      Thread.sleep(3000)
      1
    }
    assert(future.isCompleted == false)
  }

  feature("Handling Future result using callbacks") {
    scenario("Handle Future using onComplete with pattern matching - Success case") {
      val future = Future[Int] {
        Thread.sleep(1000)
        1
      }
      assert(future.isCompleted == false)

      val _: Unit = future.onComplete {
        case Success(result) =>
          val expected = 1
          val actual = result
          assert(actual == expected)
        case Failure(_) =>
          assert(1 == 0)
      }
      Thread.sleep(2000)
    }
  }
}



