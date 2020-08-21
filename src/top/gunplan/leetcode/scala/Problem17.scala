package top.gunplan.leetcode.scala

import scala.collection.mutable.ListBuffer

object Problem17 {


  object Solution {
    val l = List("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    val r: ListBuffer[String] = ListBuffer[String]()

    def letterCombinations(digits: String): List[String] = {
      if (digits.length == 0) {
        return List.empty[String]
      }
      r.clear()
      letterCombinations0(digits, 0, "")
      r.toList
    }

    def letterCombinations0(digits: String, now: Int, b: String): Unit = {
      if (now == digits.length) {
        r += b
        return
      }
      val k = digits.charAt(now) - '0' - 2
      for (i <- 0 until l(k).length) {
        letterCombinations0(digits, now + 1, b + l(k).charAt(i))
      }
    }


  }

  object Solution1 {
    def letterCombinations(digits: String): List[String] = {
      val lookup = Array(
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
      )

      def gen(list: List[Char]): IndexedSeq[String] =
        list match {
          case Nil => IndexedSeq("")
          case ::(head, next) =>
            for {
              i <- lookup(head.toInt - 50)
              j <- gen(next)
            } yield i + j
        }

      if (digits.length == 0) List.empty[String]
      else gen(digits.toCharArray.toList).toList
    }
  }


}
