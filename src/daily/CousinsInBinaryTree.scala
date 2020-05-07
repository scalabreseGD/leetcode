package daily

import daily.CousinsInBinaryTree.Solution.isCousins

object CousinsInBinaryTree {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  object Solution {
    def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
      def findDepth(toFind: Int, parent: Int, node: TreeNode, actualDepth: Int): Option[(Int, Int)] = {
        if (toFind == node.value) Some(actualDepth, parent)
        else {
          Option(node.left).flatMap(findDepth(toFind, node.value, _, actualDepth + 1))
            .orElse(Option(node.right).flatMap(findDepth(toFind, node.value, _, actualDepth + 1)))
        }
      }

      findDepth(x, root.value, root, 0)
        .zip(findDepth(y, root.value, root, 0))
        .exists(pair => pair._1._2 != pair._2._2 && pair._1._1 == pair._2._1)
    }
  }

  def main(args: Array[String]): Unit = {
    val tree = new TreeNode(1,
      new TreeNode(2, null, new TreeNode(4)),
      new TreeNode(3, null, new TreeNode(5))
    )
    val tree2 = new TreeNode(1,
      new TreeNode(2, null, new TreeNode(4)),
      new TreeNode(3, null, null)
    )
    assert(isCousins(tree, 5, 4))
    assert(!isCousins(tree2, 2, 3))
  }

}
