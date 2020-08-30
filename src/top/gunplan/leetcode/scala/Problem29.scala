package top.gunplan.leetcode.scala

class Problem29 {

  object Solution {

    def nextPermutation(nums: Array[Int]): Unit = {


      val n = nums.length
      var i = n - 2
      var j = n - 1
      while (i >= 0 && nums(i + 1) <= nums(i)) {
        i -= 1
        if (i >= 0) {
          while (nums(j) <= nums(i)) {
            j -= 1
          }
          nums(i) = nums(i) ^ nums(j)
          nums(j) = nums(i) ^ nums(j)
          nums(i) = nums(i) ^ nums(j)
        }
      }
      reverseMap(nums, i + 1, nums.length - 1)
    }

    def reverseMap(nums: Array[Int], i: Int, i1: Int): Unit = {
      var s = i
      var e = i1
      while (e - s > 1) {
        nums(s) = nums(s) ^ nums(e)
        nums(e) = nums(s) ^ nums(e)
        nums(s) = nums(s) ^ nums(e)
        s += 1
        e -= 1
      }
    }
  }

}
