package top.gunplan.leetcode.scala

class Problem11 {

  object Solution {
    def maxArea(height: Array[Int]): Int = {
      var l = 0
      var r = height.length - 1
      var max = 0
      while (r != l) {
        max = Math.max(max, getResult(height(l), height(r), r - l))
        if (height(l) < height(r)) {
          l += 1
        } else {
          r -= 1
        }
      }
      max

    }

    def getResult(l: Int, r: Int, d: Int): Int = {
      Math.min(l, r) * d
    }
  }

}
