package top.gunplan.leetcode.scala

import scala.collection.mutable

class Problem32 {

  class Solution {
    def longestValidParentheses(s: String): Int = {
      var max = 0
      var start = 0
      if (null == s) return 0
      val stack = new mutable.ArrayStack[Int]()
      var index = 0
      while (index < s.length) {
        if ('(' == s.charAt(index)) {
          stack.push(index)
        }
        else if (stack.isEmpty) {
          start = index + 1
        }
        else {
          stack.pop
          if (stack.isEmpty) max = Math.max(max, index - start + 1)
          else max = Math.max(max, index - stack.top)
        }
      }
      max
    }
  }

  object Solution {
    def longestValidParentheses(s: String): Int = {
      var k = new Array[(Int, Int)](0)
      var i = 1
      k(0) = (if (s.toCharArray()(0) == '(') -1 else 1, 0)
      for (v <- s.toCharArray) {
        k(i) = (v match {
          case '(' =>

            if (k(i - 1)._1 <= 0) {
              k(i - 1)._1 - 1
            }
            else {
              1
            }
          case ')' =>
            k(i - 1)._1 + 1
        }, 0)

        i += 1
      }

      0
    }


  }


}
