package top.gunplan.leetcode.scala


object Problem47 {

  object Solution {

    import scala.collection.mutable.ListBuffer

    var lb = ListBuffer[List[Int]]()

    def permuteUnique0(nums: Array[Int], s: String): Unit = {
      if (s.length == nums.length) {
        var ch = new ListBuffer[Int]()
        for (k <- s.toCharArray) {
          ch += (k - '0')
        }
        lb += ch.toList
        return
      }

      for (i <- nums.indices) {
        if (nums(i) != -1) {
          val k = nums(i)
          nums(i) = -1
          permuteUnique0(nums, s + k.toString)
          nums(i) = k
        }
      }

    }

    def permuteUnique(nums: Array[Int]): List[List[Int]] = {
      lb.clear()
      permuteUnique0(nums, "")
      lb.distinct.toList
    }
  }


  object Solution1 {
    def permuteUnique(nums: Array[Int]): List[List[Int]] = {
      solver(List((List[Int](), nums.sorted.toList))) map (x => x._1)
    }

    @scala.annotation.tailrec
    def solver(l: List[(List[Int], List[Int])]): List[(List[Int], List[Int])] = {
      if (l forall (x => x._2 == Nil)) l
      else solver(l flatMap f)
    }

    def f(x: (List[Int], List[Int])): List[(List[Int], List[Int])] = x._2 match {
      case Nil => List(x)
      case _ => g(x._1)(Nil, x._2, Nil)
    }

    @scala.annotation.tailrec
    def g(x: List[Int])(xs1: List[Int], xs2: List[Int], acc: List[(List[Int], List[Int])]): List[(List[Int], List[Int])] = xs2 match {
      case Nil => acc distinct
      case h :: t => g(x)(xs1 :+ h, t, (h :: x, xs1 ++ t) :: acc)
    }
  }


}
