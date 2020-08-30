package top.gunplan.leetcode.scala


object Problem47 {

  object Solution {

    import scala.collection.mutable.ListBuffer

    var lb = ListBuffer[List[Int]]()

    def permuteUnique0(nums: Array[Int], po: Array[Int], l: List[Int]): Unit = {
      if (l.length == nums.length) {
        if (!lb.contains(l))
          lb += l
        return
      }

      for (i <- nums.indices) {
        if (po(i) != -1) {
          po(i) = -1
          permuteUnique0(nums, po, l :+ nums(i))
          po(i) = 0
        }
      }

    }

    def permuteUnique(nums: Array[Int]): List[List[Int]] = {
      lb.clear()
      permuteUnique0(nums, new Array[Int](nums.length), List[Int]())
      lb.toList
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
