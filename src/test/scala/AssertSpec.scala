import org.scalatest.{FunSuite, Matchers}

/**
  * Created by Harley on 2016. 7. 27..
  */
class AssertSpec extends FunSuite with Matchers {

  test("ex1") {
    true shouldBe true
  }

  test("ex2") {
    val v1 = 4
    v1 should equal(4)
    v1 should ===(4)
    v1 should be(4)
    v1 shouldBe 4
    v1 shouldEqual 4
  }

  test("ex3") {
    assert(2 == 1 + 1)
  }

}
