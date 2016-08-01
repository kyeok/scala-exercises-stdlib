import org.scalatest.{FunSuite, Matchers}

/**
  * If you have worked with Java at all in the past,
  * it is very likely that you have come across a NullPointerException at some time
  * (other languages will throw similarly named errors in such a case).
  *
  * Usually this happens because some method returns null when you were not expecting it
  * and thus not dealing with that possibility in your client code.
  *
  * A value of null is often abused to represent an absent optional value.
  *
  * Scala tries to solve the problem by getting rid of null values altogether and providing its own type for representing optional values, i.e. values that may be present or not: the Option[A] trait.
  * Option[A] is a container for an optional value of type A. If the value of type A is present, the Option[A] is an instance of Some[A], containing the present value of type A. If the value is absent, the Option[A] is the object None.
  *
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

    None getOrElse (0) shouldBe 0
  }

  test("isEmpty") {
    value1.isEmpty shouldBe false
    value2.isEmpty shouldBe true

    None.isEmpty shouldBe true
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

    val aNumber: Option[Int] = Some(100)
    val bNumber: Option[Int] = None

    aNumber.map(_ * 1.5) shouldBe Some(150)
    bNumber.map(_ * 1.5) shouldBe None

  }

  test("fold는 디폴트 값을 주고 연산한다.") {
    val result1 = number.fold(0)(_ * 3)
    result1 shouldBe 9

    val result2 = noNumber.fold(0)(_ * 3)
    result2 shouldBe 0
  }

  test("puruni_option") {
    val something: Option[String] = Some("The place where I have lunch is delicious~!")
    something getOrElse ("Default") shouldBe "The place where I have lunch is delicious~!"
  }

  test("puruni pattern matching") {
    val something: Option[String] = Some("Harley")
    val somethingValue = something match {
      case Some(v: String) => "Hello " + v
      case None => "Ooops!"
    }

    somethingValue shouldBe "Hello Harley"
  }
}
