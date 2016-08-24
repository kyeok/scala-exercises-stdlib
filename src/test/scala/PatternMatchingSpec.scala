import org.scalatest.{Matchers, WordSpec}

/**
  * Created by Harley on 2016. 8. 24..
  */
class PatternMatchingSpec extends WordSpec with Matchers {

  "Pattern Matching" should {

    "basic" in {

      def func1(num: Int): String = num match {
        case 1 => "one"
        case _ => "other"
      }

      func1(1) shouldBe "one"
      func1(2) shouldBe "other" // 1외의 아무 숫자나 넣었을 때


      def func2(num: Int): Any = num match {
        case 1 => "one"
        case something => something
      }

      func2(1) shouldBe "one"
      func2(2) shouldBe 2 // 1외의 아무 숫자나 넣었을 때
      func2(66) shouldBe 66 // 1외의 아무 숫자나 넣었을 때
    }

    "type" in {

      def func(obj: Any): String = obj match {
        case x: String => "string"
        case x: Number => "number"
        case _ => "etc"
      }

      func("str") shouldBe "string" // 문자열을 넣으면
      func(1) shouldBe "number" // 숫자를 넣으면
    }

    "type2" in {

      trait Link
      class Facebook extends Link {
        def getID() = "아이디"
      }
      class Kakao extends Link {
        def getName() = "본명"
      }
      class KakaoStrory extends Link {
        def getNickName() = "닉네임"
      }

      def getName(link: Link): String = link match {
        case x: Facebook => x.getID()
        case x: Kakao => x.getName()
        case x: KakaoStrory => x.getNickName()
        case _ => "Who are you?"
      }

      getName(new Facebook) shouldBe "아이디"
      getName(new Kakao) shouldBe "본명"
      getName(new KakaoStrory) shouldBe "닉네임"
    }


  }

}