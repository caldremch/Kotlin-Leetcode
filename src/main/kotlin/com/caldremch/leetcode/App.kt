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

    fun createNode(list:IntArray): ListNode {
        var root:ListNode? = null
        var head:ListNode?= null
        list.forEach {
        val temp = createNode(it)
            if (head == null){
                head = temp
                root = head
            }else{
                head!!.next = temp
                head = temp
            }
        }
        return root!!
    }


    /**
     * 9,9,9,9,9,9,9
     * 9,9,9,9,0,0,0 ==>199
     *
     * 9999999
     * 0009999 ==> 10009998
     *
     * 9,9,9,9,9,9,9
     * 9,9,9,9,0,0,0 ==>89990001
     *
     *
     */
    @JvmStatic
    fun main(args:Array<String>){
        val app = Solution1()
        app.twoSum(intArrayOf(3,2,4), 6)
        val app2 = Solution2()
        val n1 = createNode(intArrayOf(2,9))
//        val n2 = createNode(4)
//        val n3 = createNode(3)
//        n1.next = n2
//        n2.next = n3


//        [1,9] ===> 92
//       yhhhhhhhhhhh [1]
        val n11 = createNode(intArrayOf(11))
//        val n22 = createNode(6)
//        val n33 = createNode(4)
//        n11.next = n22
//        n22.next = n33
//        printNode(n1)
//        printNode(n11)
        val resultNode =  Laboratory.addTwoNumbers3(n1, n11)
        printNode(resultNode)

    }

     fun printNode(node:ListNode?){
        var start = node
        while (start!= null){
            print(start.`val`)
            start = start.next
        }
        println()
    }

}