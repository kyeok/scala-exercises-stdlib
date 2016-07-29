/**
  * Created by Harley on 2016. 7. 29..
  */
class HarleyPoint(var x: Int, var memo: String) {

  override def toString: String = s"($x, $memo)"
}

object Main1 extends App {
  val hp = new HarleyPoint(1, "test")
  println(hp.toString)
  hp.x = 2
  hp.memo = "test2"
  println(hp.toString)
}

object Main2 {
  def main(args: Array[String]): Unit = {
    val hp = new HarleyPoint(1, "test")
    println(hp.toString)
    hp.x = 2
    hp.memo = "test2"
    println(hp.toString)
  }
}
