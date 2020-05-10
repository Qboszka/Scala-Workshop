import org.scalatest.FeatureSpec
import String_interpolation.Interpolators.LowercaseInterpolator

class StringInterpolationTEST extends FeatureSpec {
  feature("Lowercase interpolator") {
    scenario("Making all elements of string lowercase") {

      val expected: String = "programowanie scala jest super2"
      val actual: String = lowercase"PrograMowanie SCALA JeST Super2"
      assert(expected == actual)
    }
  }
}
