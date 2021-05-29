package com.caldremch.leetcode

/**
 *
 * @auther Caldremch
 *
 * @email finishmo@qq.com
 *
 * @date 2021/5/25 23:02
 *
 * @description
 *
 *
 */
object App {

    fun createNode(value:Int): ListNode {
        return ListNode(value)
    }

    @JvmStatic
    fun main(args:Array<String>){
        val app = Solution1()
        app.twoSum(intArrayOf(3,2,4), 6)
        val app2 = Solution2()
        val n1 = createNode(2)
        val n2 = createNode(4)
        val n3 = createNode(3)
        n1.next = n2
        n2.next = n3

        val n11 = createNode(5)
        val n22 = createNode(6)
        val n33 = createNode(4)
        n11.next = n22
        n22.next = n33

       val resultNode =  app2.addTwoNumbers2(n1, n11)

        var start = resultNode
        while (start!= null){
            print(start.`val`)
            start = start.next
        }
    }

}