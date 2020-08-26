package top.gunplan.leetcode.scala

import scala.collection.mutable.ListBuffer

class Problem21 {

  object Solution {
    val ls = ListBuffer[String]()

    def dosth(n: Int, str: String, l: Int, lz: Int): Unit = {
      if (str.length == 2 * n) {
        ls += str
        return
      }
      if (lz < n) {
        dosth(n, str + "(", l + 1, lz + 1)
      }
      if (l > 0) {
        dosth(n, str + ")", l - 1, lz)
      }
    }

    def generateParenthesis(n: Int): List[String] = {
      ls.clear()
      dosth(n, "", 0, 0)
      ls.toList
    }
  }

}



