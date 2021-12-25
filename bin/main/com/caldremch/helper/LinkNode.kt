package com.caldremch.helper

/**
 *
 * @author Caldremch
 *
 * @email finishmo@qq.com
 *
 * @date 2021/9/4 11:08
 *
 * @description
 *
 *
 */
class LinkNode(var value: Int? = null, var mNext: LinkNode? = null) {

}


fun LinkNode?.println() {
    if (this == null) {
        kotlin.io.println("链表为空")
        return
    }

    var nextNode = this
    while (nextNode != null) {
        kotlin.io.print("${nextNode.value!!},")
        nextNode = nextNode.mNext
    }
    kotlin.io.println()

}

