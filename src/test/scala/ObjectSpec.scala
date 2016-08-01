import org.scalatest.{FunSuite, Matchers}

/**
  * Created by Harley on 2016. 8. 1..
  */
class ObjectSpec extends FunSuite with Matchers {

  // singleton 객체의 인스턴스가 하나다
  // Object + , static -
  object Greeting {
    def english = "Hi"

    def espanol = "Hola"

    def deutsch = "Hallo"

    def magyar = "Szia"
  }

  test("Singleton") {
    Greeting.english should be("Hi")
    Greeting.espanol should be("Hola")
    Greeting.deutsch should be("Hallo")
    Greeting.magyar should be("Szia")
  }

  test("Equals") {
    // == 자바(레퍼런스를 비교), scala (값을 비교)
    // equals 자바에서 사용하는 값 비교
    // eq 스칼라에선 레퍼런스 비교

    val x = Greeting
    val y = x
    x eq y shouldBe true
    x == y shouldBe true
    val z = Greeting
    x eq z shouldBe true
    x == z shouldBe true
    x === z shouldBe true
  }

  test("class equals") {
    class Foo
    val a = new Foo
    val b = new Foo

    a == b shouldBe false
    a eq b shouldBe false
  }

  test("Companion class") {
    class Puruni(val student: String, val level: Int)

    object Puruni {
      def apply(student: String, level: Int): Puruni = new Puruni(student, level)
    }

    val p1 = Puruni.apply("harley", 1)
    val p2 = new Puruni("harley", 1)
    
  }
}
