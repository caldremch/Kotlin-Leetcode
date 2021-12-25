package com.caldremch.helper

/**
 * @author Caldremch
 * @email finishmo@qq.com
 * @date 2021/9/6 22:26
 * @description  https://www.awaimai.com/2607.html
 */
object PrintTree {
    // Helper function to print branches of the binary tree
    private fun showTrunks(p: Trunk?) {
        if (p == null) return
        showTrunks(p.prev)
        print(p.str)
    }

    // 使用中序遍历方式打印二叉树
    private fun traversalPrint(root: TreeNode?, prev: Trunk?, isLeft: Boolean) {
        if (root == null) return
        val ROOT_PREV = "   "
        val CHILD_PREV = "    "
        val LEFT_CHILD_CURVED_EDGE = ".---"
        val LEFT_CHILD_STRAIGHT_EDGE = "   |"
        val RIGHT_CHILD_CURVED_EDGE = "`---"
        val RIGHT_CHILD_STRAIGHT_EDGE = "   |"
        var prev_str = CHILD_PREV
        val trunk = Trunk(prev, prev_str)

        // 遍历左子树
        traversalPrint(root.left, trunk, true)
        if (prev == null) trunk.str = ROOT_PREV else if (isLeft) {
            trunk.str = LEFT_CHILD_CURVED_EDGE
            prev_str = LEFT_CHILD_STRAIGHT_EDGE
        } else {
            trunk.str = RIGHT_CHILD_CURVED_EDGE
            prev.str = prev_str
        }
        showTrunks(trunk)

        // 打印当前节点
        println(root.value)
        if (prev != null) prev.str = prev_str
        trunk.str = RIGHT_CHILD_STRAIGHT_EDGE

        // 遍历右子树
        traversalPrint(root.right, trunk, false)
    }

    fun print(root: TreeNode?) {
        traversalPrint(root, null, false)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("哈哈哈")
    }

    private class Trunk  constructor(var prev: Trunk?, var str: String)
}