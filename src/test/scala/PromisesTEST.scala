import org.scalatest.FeatureSpec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success, Try}

class PromisesTEST extends FeatureSpec {

  feature("Completing Promises") {
    scenario("Promise can be completed") {
      val p = Promise[Int]
      Future {
        Thread sleep 1000
        p success {
          print("Promise completed successfully");
          1
        }
      }
      p success {
        print("Completing promise")
        0
      }
    }

    scenario("Converting Promise to Future and completing with onCompleted") {
      val p = Promise[Int]
      Future {
        Thread sleep 1000
        p success {
          println("Completing Promise")
          1
        }
      }

      p.future onComplete {
        case Success(_) => println("Future of Promise completed")
        case Failure(_) => assert(1 == 0)
      }

      Thread.sleep(2000)
    }
  }
}
