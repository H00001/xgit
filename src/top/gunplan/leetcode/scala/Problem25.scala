package top.gunplan.leetcode.scala

import scala.collection.mutable.ArrayBuffer

class Problem25 {


  object Solution {
    def reverseKGroup(index: ListNode, num: Int): ListNode = {
      var m = index

      var nodes = ArrayBuffer[ListNode]()
      for (_ <- 0 until num) {
        if (m == null) {
          return index
        } else {
          nodes += m
          m = m.next
        }
      }

      val l = reverseKGroup(m, num)
      val size = nodes.size
      val mid = size / 2
      for (i <- 0 until mid) {
        val a = nodes(i)
        nodes(i) = nodes(size - 1 - i)
        nodes(size - 1 - i) = a
      }

      nodes(size - 1).next = l

      var f: ListNode = null
      var b: ListNode = null
      for (n <- nodes) {
        if (b == null) {
          f = n
          b = n
        } else {
          b.next = n
          b = b.next
        }
      }

      f
    }
  }


}
