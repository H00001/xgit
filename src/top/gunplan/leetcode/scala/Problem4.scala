package top.gunplan.leetcode.scala

import scala.util.control.Breaks._

class Problem4 {

  object Solution {
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
      val ls = nums1.length
      val rs = nums2.length
      if (ls > rs) {
        return findMedianSortedArrays(nums2, nums1)
      }

      var Lmax1 = 0
      var Rmin1 = 0
      var Lmax2 = 0
      var Rmin2 = 0
      var l = 0
      var r = 2 * ls

      breakable {
        while (l <= r) {
          val c1 = (l + r) / 2
          val c2 = ls + rs - c1
          Lmax1 = if (c1 == 0) Int.MinValue
          else nums1((c1 - 1) / 2)
          Rmin1 = if (c1 == ls * 2) Int.MaxValue
          else nums1(c1 / 2)
          Lmax2 = if (c2 == 0) Int.MinValue
          else nums2((c2 - 1) / 2)
          Rmin2 = if (c2 == rs * 2) Int.MaxValue
          else nums2(c2 / 2)
          if (Lmax1 > Rmin2) r = c1 - 1
          else if (Lmax2 > Rmin1) l = c1 + 1
          else break
        }
      }

      (Math.max(Lmax1, Lmax2) + Math.min(Rmin1, Rmin2)) / 2.0
    }
  }

}