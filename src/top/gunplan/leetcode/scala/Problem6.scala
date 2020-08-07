package top.gunplan.leetcode.scala

class Problem6 {

  object Solution {


    def convert(s: String, numRows: Int): String = {
      if (numRows == 1) return s
      val ret = new StringBuilder()
      val n = s.length
      val temp = 2 * numRows - 2
      var i = 0
      while (i < numRows) {
        var k = 0
        while (k + i < n) {
          ret.append(s.charAt(k + i))
          if (i != 0 && i != numRows - 1 && k + temp - i < n) ret.append(s.charAt(k + temp - i))
          k += temp
        }
        i += 1
      }
      ret.toString
    }

  }

}
