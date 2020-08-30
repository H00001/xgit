package top.gunplan.leetcode.scala

class Problem27 {

  object Solution {

    def removeElement(nums: Array[Int], `val`: Int): Int = {
      var l = 0
      var p = nums.length - 1
      var k = 0

      nums.foreach(w => if (w == `val`) k += 1)

      for (i <- nums.indices) {
        if (nums(i) == `val`) {
          while (nums(p) == `val`) {
            p -= 1
          }
          change(nums, i, p)
        }
        if (p == nums.length - k) {
          return nums.length - k
        }
      }
      nums.length - k
    }

    def change(nums: Array[Int], i: Int, p: Int): Unit = {
      nums(i) = nums(p)
    }
  }

}
