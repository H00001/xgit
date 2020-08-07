package top.gunplan.leetcode.scala

class Problem7 {

  object Solution {
    def reverse(x: Int): Int = {
      var res = 0.0
      var s = x.toString
      val flag = x < 0
      if (flag) {
        s = s.substring(1, s.length)
      }
      for (i <- s.length to 1 by -1) {
        res = (s.charAt(i - 1).toInt - '0') * Math.pow(10, i) + res
      }
      if (flag) -res.toInt else res.toInt
    }
  }

}
