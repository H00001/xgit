package top.gunplan.leetcode.scala

object problem18 {

  object Solution {
    def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
      val n = nums.sorted
      var ans = List[List[Int]]()
      for (i <- 0 until (n.length - 3)) {
        if (!(i > 0 && n(i) == n(i - 1))) {
          for (j <- (i + 1) until (n.length - 2)) {
            if (!(j > (i + 1) && n(j) == n(j - 1))) {
              var l = j + 1
              var r = n.length - 1
              while (l < r) {
                val d = n(i) + n(j) + n(l) + n(r)
                if (d > target) {
                  r -= 1
                } else if (d < target) {
                  l += 1
                } else {

                  ans = ans :+ List[Int](n(i), n(j), n(l), n(r))
                  r -= 1
                  l += 1
                  while (l < r && n(l) == n(l - 1)) l += 1
                  while (l < r && n(r) == n(r + 1)) r -= 1
                }
              }
            }
          }
        }
      }
      ans
    }
  }


}
