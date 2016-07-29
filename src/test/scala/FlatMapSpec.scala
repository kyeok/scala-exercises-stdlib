import org.scalatest.FunSuite

/**
  * Created by Harley on 2016. 7. 29..
  */
class FlatMapSpec extends FunSuite {

  test("FlatMap") {
    val myList = List(List(1, 2), List(3, 4))
    println(myList.flatMap(x => x.map(_ * 2)))

  }
}
