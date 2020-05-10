import org.scalatest.FeatureSpec

class NullTEST extends FeatureSpec{
  feature("Null assignment") {
    scenario("Assigning null to List[String]") {

      val expected: Null = null
      val actual : List[String] = null
      assert(expected==actual)
    }
  }
}

