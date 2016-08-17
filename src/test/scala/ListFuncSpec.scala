/**
  * Created by Harley on 2016. 8. 10..
  */

import org.scalatest.{Matchers, WordSpec}

import scala.collection.mutable

/**
  * Created by karellen on 2016. 8. 10..
  */
class ListFuncSpec extends WordSpec with Matchers {

  "리스트" should {
    "생성하다" in {
      // Java 버전
      var jList = new mutable.ListBuffer[Int]()
      jList.append(1)
      jList.append(2)
      jList.append(3)
      jList shouldBe List(1, 2, 3)

      // Scala 버전
      val slist: List[Int] = List(1, 2, 3)
      slist shouldBe List(1, 2, 3)

      val _0To10: List[Int] = (0 to 10).toList
      _0To10 shouldBe List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }

    "변형하다1" in {
      val list = List(1, 2, 3, 4, 5)

      val firstAdd: List[Int] = List(0) ++ list
      firstAdd shouldBe List(0, 1, 2, 3, 4, 5)

      val firstAdd2: List[Int] = 0 :: list
      firstAdd2 shouldBe List(0, 1, 2, 3, 4, 5)


      // 요건 비효율적임.
      val firstAdd2_1: List[Int] = list ++ List(6)
      firstAdd2_1 shouldBe List(1, 2, 3, 4, 5, 6)


      val firstAdd3: List[Int] = 0 +: list
      firstAdd3 shouldBe List(0, 1, 2, 3, 4, 5)

      val firstAdd4: List[Int] = list ::: List(6, 7)
      firstAdd3 shouldBe List(1, 2, 3, 4, 5, 6, 7)

      //      val lastAdd: List[Int] = ???
      //      lastAdd shouldBe List(1, 2, 3, 4, 5, 6)
      //
      //      val lastAddList: List[Int] = ???
      //      lastAddList shouldBe List(1, 2, 3, 4, 5, 6, 7)
    }

    "접근하다 1" in {
      val list = List(1, 2, 3, 4, 5)

      val secondItem: Int = list(1)
      secondItem shouldBe 2

      val firstItem: Int = list.head
      firstItem shouldBe 1

      val lastItem: Int = list.last
      lastItem shouldBe 5

      val exceptFirst: List[Int] = list.tail
      exceptFirst shouldBe List(2, 3, 4, 5)

      val exceptLast: List[Int] = list.init
      exceptLast shouldBe List(1, 2, 3, 4)
    }

    "접근하다 2" in {
      val list = List(1, 2, 3, 4, 5)

      //      val takeList: List[Int] = ???
      //      takeList shouldBe List(1, 2)
      //
      //      val dropList: List[Int] = ???
      //      dropList shouldBe List(3, 4)

      val firstItem: Option[Int] = list.headOption
      firstItem shouldBe Some(1)

      val secondItem: Option[Int] = list.drop(1).headOption
      secondItem shouldBe Some(2)

      val lastItem: Option[Int] = list.drop(list.length - 1).headOption
      lastItem shouldBe Some(5)
      //
      //      val exceptFirst: List[Int] = ???
      //      exceptFirst shouldBe List(2, 3, 4, 5)

      // 이렇게 사용할 일은 없지만..
      //      val exceptLast: List[Int] = ???
      //      exceptLast shouldBe List(1, 2, 3, 4)4
    }

    "필터링하다" in {
      val list = List(1, 2, 3, 4, 5)

      val even: List[Int] = list.filter(x => x % 2 == 0)
      even shouldBe List(2, 4)

      val odd: List[Int] = list.filter(x => x % 2 == 1)
      odd shouldBe List(1, 3, 5)
    }

    "변형하다2" in {
      val list = List(1, 2, 3, 4, 5)

      val doubled: List[Int] = list.map(i => i * 2)
      doubled shouldBe List(2, 4, 6, 8, 10)
    }

    "sum, max" in {
      val list = List(1, 2, 3, 4, 5)

      val sum: Int = list.reduce((x, y) => x + y)
      sum shouldBe 15

      val max: Int = list.max
            max shouldBe 5
    }

  }
}