import org.scalatest.{FunSuite, Matchers}

/**
  * Created by Harley on 2016. 7. 27..
  */
class OptionSpec extends FunSuite with Matchers {
  test("Options") {
    val someValue: Option[String] = Some("I am wrapped in something")
    someValue shouldBe Option("I am wrapped in something")
    someValue shouldBe Some("I am wrapped in something")

    val emptyValue: Option[String] = None
    emptyValue shouldBe None
  }

  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if (flag) Some("Found Value") else None
  }

  val value1 = maybeItWillReturnSomething(true)
  val value2 = maybeItWillReturnSomething(false)

  test("Option2") {
    value1 shouldBe Some("Found Value")
    value1 shouldBe Option("Found Value")
    value2 shouldBe None
  }

  test("getOrElse") {
    value1 getOrElse "No Value" shouldBe "Found Value"
    value2 getOrElse ("No Value") shouldBe "No Value"
  }

  test("isEmpty") {
    value1.isEmpty shouldBe false
    value2.isEmpty shouldBe true
  }

  test("pattern matching") {
    val someValue: Option[Double] = Some(20.0)
    val value = someValue match {
      case Some(v) => v
      case None => 0.0
    }
    value shouldBe 20.0


    val noneValue: Option[Double] = None
    val value2 = noneValue match {
      case Some(v) => v
      case None => 0.0
    }
    value2 shouldBe 0.0
  }

  val number: Option[Int] = Some(3)
  val noNumber: Option[Int] = None

  test("map") {
    val result1 = number.map(_ * 1.5)
    val result2 = noNumber.map(_ * 1.5)

    result1 shouldBe Some(4.5)
    result2 shouldBe None
  }

  test("fold") {
    val result1 = number.fold(0)(_ * 3)
    result1 shouldBe 9

    val result2 = noNumber.fold(0)(_ * 3)
    result2 shouldBe 0
  }
}
