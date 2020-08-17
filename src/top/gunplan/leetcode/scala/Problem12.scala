package top.gunplan.leetcode.scala

class Problem12 {

  object Solution {
    def intToRoman(num: Int): String = {
      var num1 = num
      var re = ""
      val op = Array("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M")
      val Num = Array(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000)
      var i = 12
      while (i >= 0) {
        if (num1 >= Num(i)) {
          num1 = num1 - Num(i)
          re += op(i)
        }
        else {
          i = i - 1
        }
      }
      re

    }
  }


}
