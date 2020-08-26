package top.gunplan.leetcode.scala

class Problem111 {

  object Solution {
    def minDepth(root: TreeNode): Int = {
      if (root == null) {
        return 0
      }
      if (root.left == null && root.right == null) {
        return 1
      }
      minDepth(root, 1)
    }

    def minDepth(root: TreeNode, now: Int): Int = {
      if (root == null) {
        return now
      }
      Math.min(minDepth(root.left, now), minDepth(root.right, now)) + 1
    }
  }

}
