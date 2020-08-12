package top.gunplan.leetcode.scala

class Problem8 {

  object Solution {
    def myAtoi(str: String): Int = {
      val x = str.toInt
      var s = str.reverse
      val flag = x < 0
      var res = 0.0
      if (flag) {
        s = s.substring(1, s.length)
      }
      for (i <- 0 until s.length by 1) {
        res = (s.charAt(i).toInt - '0') * Math.pow(10, i) + res
      }
      if (flag) -res.toInt else res.toInt
    }
  }

}
