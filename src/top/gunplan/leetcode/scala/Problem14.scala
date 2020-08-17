package top.gunplan.leetcode.scala

class Problem14 {

  object Solution {
    def longestCommonPrefix(strs: Array[String]): String = {
      var pr = ""
      if (strs.length == 0) {
        return pr
      }
      var c = ' '
      var min = Int.MaxValue
      var flag = true
      strs.foreach(v => {
        min = Math.min(v.length, min)
      })
      for (i <- 0 to min if flag) {
        c = strs(0).charAt(i)
        for (v <- strs) {
          if (c != v.charAt(i)) {
            flag = false
          }
        }
        if (flag) {
          pr = pr + strs(0).charAt(i)
        }
      }
      pr.substring(0, pr.length - 1)
    }
  }

}
