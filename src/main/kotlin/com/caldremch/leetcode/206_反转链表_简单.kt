package com.caldremch.leetcode

import com.caldremch.helper.AlgorithmChaos.randomLinkList
import com.caldremch.helper.AlgorithmChaos.randomLinkListNode
import com.caldremch.helper.println

/**
 *
 * @author Caldremch
 *
 * @email finishmo@qq.com
 *
 * @date 2021/12/9 22:20
 *
 * @description
 *
 *
 */


class Solution206 {


    //O(n)解法
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null;
        if (head.next == null) return head
        var returnNode: ListNode? = null
        var returnPtr: ListNode? = null
        //暴力破解
        var ptr = head;
        while (ptr != null) {
            if (returnPtr == null) {
                returnPtr = ListNode(ptr.`val`)
            } else {
                val temp = returnPtr;
                returnPtr = ListNode(ptr.`val`)
                returnPtr.next = temp
            }
            returnNode = returnPtr
            ptr = ptr.next
        }

        return returnNode;
    }

    //递归解法

    fun  reverseListrRecursion(head: ListNode?):ListNode?{
        if(head?.next == null){
            return head
        }
        val newHeader:ListNode? = reverseList(head);
        head?.next?.next = head; //让自己的下一个的下一个指向自己, 自己的下一个指向null
        head.next = null
        return newHeader //返回新的头, 继续
    }


    //非递归遍历
    fun reverseListrNonRecursion(head: ListNode?):ListNode?{
        var pre:ListNode? = null
        var curr  = head
        while (curr != null){
            val next = curr.next
            curr.next = pre //当前节点指向之前的节点
            pre = curr //pre存储当前的节点
            curr = next //curr移动到下一个节点
        }
        return pre

    }


}

fun main(args: Array<String>) {

    val solution206 = Solution206()

    val head  = randomLinkListNode(5);
    head.println()

//    val reverse = solution206.reverseList(head);
//    reverse.println()
//
//    val reverse2 = solution206.reverseListrRecursion(head);
//    reverse2.println()

    val reverse3= solution206.reverseListrNonRecursion(head);
    reverse3.println()
}