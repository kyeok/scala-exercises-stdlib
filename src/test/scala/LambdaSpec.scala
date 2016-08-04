import org.scalatest.{FunSuite, Matchers}

/**
  * Created by Harley on 2016. 8. 3..
  */
class LambdaSpec extends FunSuite with Matchers {

  test("high order function") {
    def addWithoutSyntaxSugar(x: Int) = {
      new Function1[Int, Int]() {
        override def apply(v1: Int): Int = x + v1
      }
    }

    addWithoutSyntaxSugar(1).isInstanceOf[Function[Int, Int]] should be(true)
    addWithoutSyntaxSugar(5)(2) shouldBe 7
    val fiveAdd = addWithoutSyntaxSugar(5)
    fiveAdd(10) shouldBe 15

    def addWithoutSyntaxSugar2(x: Int) = {
      new Function2[Int, Int, Int]() {
        override def apply(v1: Int, v2: Int): Int = x + v1 + v2
      }
    }

    addWithoutSyntaxSugar2(5)(1, 2) shouldBe 8
  }
}
