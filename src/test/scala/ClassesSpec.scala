import org.scalatest.{FunSuite, Matchers}

/**
  * Classes in Scala are static templates that can be instantiated into many objects at runtime.
  * Created by Harley on 2016. 7. 27..
  */
class ClassesSpec extends FunSuite with Matchers {

  test("Classes") {
    val pt = new Point(1, 2)
    pt.toString() shouldBe "(1, 2)"
  }

  test("class with val") {
    class ClassWithValParameter(val name: String)
    val aClass = new ClassWithValParameter("Harley")
    aClass.name shouldBe "Harley"
    //aClass.name = "Edina" // 이건 안돼요
  }

  test("class with var") {
    val hPoint = new HarleyPoint(1, "test")
    hPoint.memo = "test2"
    hPoint.memo shouldBe "test2"
  }
}
