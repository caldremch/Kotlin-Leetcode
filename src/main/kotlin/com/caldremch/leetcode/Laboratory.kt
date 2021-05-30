package com.caldremch.leetcode

/**
 *
 * @auther Caldremch
 *
 * @email finishmo@qq.com
 *
 * @date 2021/5/30 10:52
 *
 * @description
 *
 *
 */
object Laboratory {
    fun addTwoNumbers3(l1: ListNode, l2: ListNode): ListNode? {

        var insteadL1 = l1
        var insteadL2 = l2

        var l1Tail:ListNode? = null
        var l1Tai2:ListNode? = null
        /**
         * 1.遍历L1链表 等到size， L2 同理等 size
         * 2.拼接 L2，形成一条链表
         * 3.跳步的形式
         */
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
        var isNextIn = false

        while (nextNode != null || isNextIn) {

            if(nextNode == null){
                println("in=1")
                isNextIn = false
                val temp = ListNode(1)
                temp.next = resultTail
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

            println("in=${valueWithLastAdd%10}")

            val temp = ListNode(valueWithLastAdd%10)

            if (valueWithLastAdd >= 10) {
                isNextIn = true
            }

            if (resultTail == null) {
                resultTail = temp
            } else {
                temp.next = resultTail
                resultTail = temp
            }
            nextNode = nextNode.next
            nextNode2 = nextNode2.next
        }

        return resultTail
    }
}