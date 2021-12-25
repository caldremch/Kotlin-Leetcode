package com.caldremch.helper

import com.caldremch.leetcode.ListNode
import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

/**
 *
 * @author Caldremch
 *
 * @email finishmo@qq.com
 *
 * @date 2021/9/4 09:41
 *
 * @description
 *
 *
 */
object AlgorithmChaos {

    //生成一个随机链表
    //生成一个随机二叉树
    //生成一个随机图
    //生成一个随机数组


    fun randomValue(size: Int = 100): Int {
        return Random().nextInt(size)
    }


    private val balanceCreateExecutors = Executors.newFixedThreadPool(2)


    fun recursionCreateTreeNode(atomicInteger: AtomicInteger, size: Int): TreeNode? {

        if (atomicInteger.get() == size) {
            return null
        }
        atomicInteger.addAndGet(1)

        val childCount = Random().nextInt(2)
        val left = Random().nextBoolean()
        val childNode = TreeNode(randomValue())
//        if (childCount == 1) {
//            if (left) {
//                childNode.left = recursionCreateTreeNode(atomicInteger, size)
//            } else {
//                childNode.right = recursionCreateTreeNode(atomicInteger, size)
//            }
//
//        } else{
////        } else if (childCount == 2) {
//            childNode.left = recursionCreateTreeNode(atomicInteger, size)
//            childNode.right = recursionCreateTreeNode(atomicInteger, size)
//        }

        childNode.left = recursionCreateTreeNode(atomicInteger, size)
        childNode.right = recursionCreateTreeNode(atomicInteger, size)

        return childNode
    }

    class WrapTreeNode(val left: Boolean, val node: TreeNode?)

    class TreeCreateTask(private val left: Boolean, private val atomicInteger: AtomicInteger, private val size: Int) :
        Callable<WrapTreeNode> {
        override fun call(): WrapTreeNode {
            return WrapTreeNode(left, recursionCreateTreeNode(atomicInteger, size))
        }

    }


    fun randomBinaryTree(size: Int = 15): TreeNode {

        val left = Random().nextBoolean()
        val childCount = Random().nextInt(2)
        val header = TreeNode(randomValue())
        val atomicInteger = AtomicInteger(1)

        val createTasks = arrayListOf<TreeCreateTask>()

//        if (childCount == 1) {
//            createTasks.add(TreeCreateTask(left, atomicInteger, size))
//        } else if (childCount == 2) {
//            createTasks.add(TreeCreateTask(true, atomicInteger, size))
//            createTasks.add(TreeCreateTask(false, atomicInteger, size))
//        }

        createTasks.add(TreeCreateTask(true, atomicInteger, size))
        createTasks.add(TreeCreateTask(false, atomicInteger, size))

        val result = balanceCreateExecutors.invokeAll(createTasks)

        result.forEach {
            val wrapTreeNode = it.get()
            if (wrapTreeNode.left) {
                header.left = wrapTreeNode.node
            } else {
                header.right = wrapTreeNode.node
            }
        }

        return header
    }


    /**
     * 随机生成[size]个元素的链表
     */
    fun randomLinkList(size: Int = 15): LinkNode {
        if (size == 1) return LinkNode(randomValue())
        var n = size
        val headNode = LinkNode(randomValue())
        n--
        var node: LinkNode = LinkNode(randomValue())
        n--
        headNode.mNext = node
        while (n-- > 0) {
            val cNode = LinkNode(randomValue())
            node.mNext = cNode
            node = cNode
        }

        return headNode
    }


    /**
     * 随机生成[size]个元素的链表
     */
    fun randomLinkListNode(size: Int = 15): ListNode {
        if (size == 1) return ListNode(randomValue())
        var n = size
        val headNode = ListNode(randomValue())
        n--
        var node: ListNode = ListNode(randomValue())
        n--
        headNode.next = node
        while (n-- > 0) {
            val cNode = ListNode(randomValue())
            node.next = cNode
            node = cNode
        }

        return headNode
    }




    @JvmStatic
    fun main(args: Array<String>) {
        randomLinkList().println()
        PrintTree.print(randomBinaryTree())
    }
}