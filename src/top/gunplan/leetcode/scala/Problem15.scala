package top.gunplan.leetcode.scala

import scala.collection.mutable.ListBuffer

class Problem15 {

  object Solution {
    def threeSum(nums: Array[Int]): List[List[Int]] = {
      val res = nums.sortWith(_ > _)
      val result = ListBuffer[List[Int]]()
      for (p0 <- res.indices) {
        var p1 = p0 + 1
        var p2 = res.length - 1
        while (p2 > p1) {
          val v = res(p0) + res(p1) + res(p2)
          if (v < 0) {
            p1 += 1
          } else if (v > 0) {
            p2 -= 1
          } else {
            val k = List[Int](res(p0), res(p1), res(p2))
            if (!result.contains(k)) {
              result +: k
            }
            p1 += 1
          }
        }
      }
      result.toList
    }
  }

}