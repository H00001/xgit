package top.gunplan.leetcode.scala

class Problem1 {

  object Solution {


    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
      val arr = new Array[Int](100)
      for (i <- nums.indices) {
        arr(nums(i)) = i
      }
      for (i <- nums.indices) {
        if (arr(target - nums(i)) != 0) {
          return Array(i, arr(target - nums(i)))
        }
      }
      null
    }
  }

}
