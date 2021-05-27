package com.caldremch.leetcode

import kotlin.math.abs

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
 * 123 =>0123
 * 1357
 *
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution2 {

    fun addTwoNumbers2(l1: ListNode, l2: ListNode): ListNode? {
        /**
         * 1.遍历L1链表 等到size， L2 同理等 size
         * 2.拼接 L2，形成一条链表
         * 3.跳步的形式
         */
        var next:ListNode? = l1
        var count1 = 0
        //n
        while(next != null){
            count1++
            next = next.next
        }

        var count2 = 0
        next = l2
        //n
        while(next != null){
            count2++
            next = next.next
        }

        l1.next = l2
        var count3 = 0


        val deltaCount=  if (count1>count2){
            count1-count2
        }else{
            count2-count1
        }

        next = l1
        while(next != null){
            //l1 补 0
            if (count1>count2){

            }
            count3++
            next = next.next
        }

    }

        fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode? {
        val slot1 = arrayListOf<Int>()
        val slot2 = arrayListOf<Int>()
        var next1: ListNode? = l1
        var next2: ListNode? = l2

        while (true) {
            if (next1 != null && next2 != null) {
                slot1.add(next1.`val`)
                next1 = next1.next
                slot2.add(next2.`val`)
                next2 = next2.next
            } else if (next1 != null && next2 == null) {
                next1 = next1.next
                slot2.add(0, 0)
            } else if (next1 == null && next2 != null) {
                next2 = next2.next
                slot1.add(0, 0)
            } else {
                if (slot1.size == slot2.size) {
                    var rootNode:ListNode? = null
                    var firstNode:ListNode? = null
                    for (x in slot1.size-1 downTo  0){
                        if(rootNode== null){
                            rootNode = ListNode(slot2[x]+slot1[x])
                            firstNode = rootNode
                        }else{
                            val temp = ListNode(slot2[x]+slot1[x])
                            firstNode!!.next = temp
                            firstNode = temp
                        }
                    }

                    return rootNode
                }
            }


        }
    }
}
