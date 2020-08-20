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
      for (i <- s.length - 1 to 0 by -1) {
        res = (s.charAt(i).toInt - '0') * Math.pow(10, i) + res
      }
      if (res > Int.MaxValue || res < (-Int.MaxValue)) return 0
      if (flag) -res.toInt else res.toInt
    }
  }

}
