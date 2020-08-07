package top.gunplan.leetcode.scala

class Problem5 {

  object Solution {

    def longestPalindrome2(s: String): String = {
      var len = s.length
      if (len < 2) {
        return s
      }
      var maxLen = 1
      var begin = 0
      //dp(i)(j) => s[i,j]是否回文串
      var dp = Array.ofDim[Boolean](s.length, s.length)
      for (i <- 0 until s.length) {
        //对角线的表示单个字符，肯定是回文串，置为true
        dp(i)(i) = true
      }
      //在对角线上方操作，即i<j
      for (j <- 1 until s.length) {
        for (i <- 0 until j) {
          if (s.charAt(i) != s.charAt(j)) {
            //不想等则一定不是回文串
            dp(i)(j) = false
          } else {
            //相等
            if (j - i < 3) {
              //距离小于三，表示中间最多只可能有一个字符，则在相等情况下，一定是回文串
              dp(i)(j) = true
            } else {
              //中间有>=2个字符，需要移动i，j到里面判断下一个是否是回文，
              //dp(i+1)(j-1)再上一轮循环已经赋值了
              dp(i)(j) = dp(i + 1)(j - 1)
            }
          }
          //如果是回文串，且长度大于临时值，则替换
          if (dp(i)(j) && j - i + 1 > maxLen) {
            maxLen = j - i + 1
            begin = i
          }
        }
      }
      s.substring(begin, begin + maxLen)

    }
  }

}