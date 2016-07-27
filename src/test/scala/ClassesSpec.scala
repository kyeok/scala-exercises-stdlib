import org.scalatest.{FunSuite, Matchers}

/**
  * Created by Harley on 2016. 7. 27..
  */
class ClassesSpec extends FunSuite with Matchers {

  test("Classes") {
    val pt = new Point(1, 2)
    pt.toString() shouldBe "(1, 2)"
  }

  test("new class") {
    class ClassWithValParameter(val name: String)
    val aClass = new ClassWithValParameter("Harley")
    aClass.name shouldBe "Harley"
  }

}
