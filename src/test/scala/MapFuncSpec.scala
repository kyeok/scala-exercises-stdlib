import org.scalatest.{Matchers, WordSpec}

import scala.collection.mutable

class MapFuncSpec extends WordSpec with Matchers {

  "map" should {

    "java style" in {
      val map = new mutable.HashMap[String, Int]()
      map.put("a", 1)
      map.put("b", 2)

      map.get("a") shouldBe (Some(1))
      map.foreach(m => print(m))
    }

    "custom Map" in {
      object MyMap {
        //        def apply(list: List[Any]*): mutable.HashMap[Any, Any] = {
        //          val map = new mutable.HashMap[Any, Any]()
        //          list.foreach(one => map.put(one(0), one(1)))
        //          map
        //        }


        def apply[T1, T2](list: (T1, T2)*) = {
          val map = new mutable.HashMap[T1, T2]()
          list.foreach(one => map.put(one._1, one._2))
          map
        }
      }

      val list = List(1, 2, 3)
      val myMap = MyMap(("a" -> 1), ("b" -> 2), ("c" -> 3))
      myMap.get("a") shouldBe (Some(1))
    }

    "basic" in {
      val map = Map("a" -> 1, "b" -> 2, "c" -> 2, "c" -> 3)

      val size: Int = map.size
      size shouldBe 3

      val keys: Iterable[String] = map.keys
      keys shouldBe Set("a", "b", "c")

      val values: Iterable[Int] = map.values
      values.toList shouldBe List(1, 2, 3)

      val find: Int = map.getOrElse("a", 1)
      find shouldBe 1

      val findOption: Option[Int] = map.get("a")
      findOption shouldBe Some(1)
    }

    "값 추가, 삭제" in {
      val map = Map("a" -> 1, "b" -> 2, "c" -> 3)

      val add: Map[String, Int] = map.+("d" -> 4).+("e" -> 5)
      val delete: Map[String, Int] = map.-("b", "c")

      add shouldBe Map("a" -> 1, "b" -> 2, "c" -> 3, "d" -> 4, "e" -> 5)
      delete shouldBe Map("a" -> 1)
    }

    "mixed type map" in {
      val map = Map("a" -> 1, 2 -> "b", true -> 3)

      map("a") shouldBe 1
      map(true) shouldBe 3

      //      val map2 = Map() // tuple로 생성
      // map.head
    }
  }
}