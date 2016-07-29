import org.scalatest.FunSuite

/**
  * Created by Harley on 2016. 7. 29..
  */
class TuplesSpec extends FunSuite {

  test("Test Tuple swap") {
    val tuple = (1, "Super man")
    println(tuple)

    println(tuple.swap)
  }
}
