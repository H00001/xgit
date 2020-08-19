package top.gunplan.leetcode.scala

object Problem16 {


  object Solution {
    def threeSumClosest(nums: Array[Int], target: Int): Int = {
      val res = nums.sortWith(_ < _)
      var result = 0
      var min = Int.MaxValue
      for (p0 <- res.indices) {
        var p1 = p0 + 1
        var p2 = res.length - 1
        while (p2 > p1) {
          val v = res(p0) + res(p1) + res(p2)
          if (v < target) {
            p1 += 1
          } else if (v > target) {
            p2 -= 1
          } else {
            return target
          }
          if (Math.abs(target - v) < min) {
            result = v
            min = Math.abs(target - v)
          }
        }

      }
      result
    }

  }


}
