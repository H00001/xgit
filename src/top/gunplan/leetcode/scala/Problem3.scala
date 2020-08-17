package top.gunplan.leetcode.scala

import scala.util.control.Breaks._


class Problem3 {

  object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
      val dp = new Array[Int](s.length())
      if (s.length() == 0 || s.length() == 1) {
        return s.length()
      }
      dp(0) = 1
      for (i <- 1 until s.length()) {
        breakable {
          for (j <- i - 1 until i - 1 - dp(i - 1) by -1) {
            if (s.charAt(j) == s.charAt(i)) {
              dp(i) = i - j
              break
            }
          }
          dp(i) = dp(i - 1) + 1
        }
      }
      dp.maxBy(v => {
        v
      })
    }

  }

}
