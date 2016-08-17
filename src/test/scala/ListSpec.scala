import org.scalatest.{FunSuite, Matchers}

/**
  * Created by Harley on 2016. 8. 3..
  */
class ListSpec extends FunSuite with Matchers {

  test("List eq") {
    val a = List(1, 2, 3)
    val b = List(1, 2, 3)
    (a eq b) shouldBe false //reference
    (a equals b) shouldBe true //value
    (a == b) shouldBe true //value
    (a === b) shouldBe true //value

    a.headOption shouldBe Option(1)
    a.tail shouldBe List(2, 3)

    a(0) shouldBe 1
    a(1) shouldBe 2

    intercept[IndexOutOfBoundsException] {
      a(3)
    }

    val list = List(1, 2, 3, 4, 5)
    val c = list.filterNot(v => v == 5)

    c shouldBe List(1, 2, 3, 4)

  }

  test("Many Useful Methods") {
    val a = List(1, 3, 5, 7, 9)
    a.length shouldEqual 5
    a.reverse shouldEqual List(9, 7, 5, 3, 1)
    a.map { v => v * 2 } shouldEqual List(2, 6, 10, 14, 18)
    a.filter { v => v % 3 == 0 } shouldEqual List(3, 9)
  }
}
