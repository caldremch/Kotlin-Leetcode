package com.caldremch.leetcode

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
                    var connectNode:ListNode? = null
                    for (x in slot1.size-1 downTo  0){

                        val temp = rootNode?.next
                        temp?.next = ListNode(slot2[x]+slot1[x])
                        temp?.next = temp

                    }

                    return rootNode
                }
            }


        }
    }
}
