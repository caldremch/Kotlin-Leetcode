package com.caldremch.leetcode

import com.caldremch.helper.LinkNode

/**
 *
 * @auther Caldremch
 *
 * @email finishmo@qq.com
 *
 * @date 2021/5/25 23:45
 *
 * @description
 *
 *
 */

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 *
 *
 * 分析
 * 1234=>1234
 * 123 =>1230  ==>2464
 * 1357
 *
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun ListNode?.println() {
    if (this == null) {
        kotlin.io.println("链表为空")
        return
    }

    var nextNode = this
    while (nextNode != null) {
        kotlin.io.print("${nextNode.`val`!!},")
        nextNode = nextNode.next
    }
    kotlin.io.println()

}

class Solution2 {


    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode? {
        var insteadL1 = l1
        var insteadL2 = l2
        var l1Tail: ListNode? = null
        var l1Tai2: ListNode? = null
        var next: ListNode? = l1
        var count1 = 0
        //n
        while (next != null) {
            l1Tail = next
            count1++
            next = next.next
        }

        var count2 = 0
        next = l2
        //n
        while (next != null) {
            l1Tai2 = next
            count2++
            next = next.next
        }

        if (count1 > count2) {
            val deltaCount = count1 - count2
            var head = l1Tai2
            for (x in 0 until deltaCount) {
                val temp = ListNode(0)
                head!!.next = temp
                head = temp
            }
        } else {
            val deltaCount = count2 - count1
            var head = l1Tail
            for (x in 0 until deltaCount) {
                val temp = ListNode(0)
                head!!.next = temp
                head = temp
            }
        }

        App.printNode(l1)
        App.printNode(l2)


        var nextNode: ListNode? = insteadL1
        var nextNode2: ListNode? = insteadL2
        var resultTail: ListNode? = null
        var resultRoot: ListNode? = null
        var isNextIn = false

        while (nextNode != null || isNextIn) {

            if (nextNode == null) {
                isNextIn = false
                val temp = ListNode(1)
                resultTail!!.next = temp
                resultTail = temp
                continue
            }

            //l1 补 0
            val v1 = nextNode.`val`
            val v2 = nextNode2!!.`val`
            val sum = v1 + v2

            val valueWithLastAdd = sum % 10 + if (isNextIn) {
                isNextIn = false
                1
            } else 0


            if (sum >= 10) {
                isNextIn = true
            }

            val temp = ListNode(valueWithLastAdd % 10)

            if (valueWithLastAdd >= 10) {
                isNextIn = true
            }

            if (resultTail == null) {
                resultTail = temp
                resultRoot = resultTail
            } else {
                resultTail.next = temp
                resultTail = temp
            }
            nextNode = nextNode.next
            nextNode2 = nextNode2.next
        }

        return resultRoot
    }
}
