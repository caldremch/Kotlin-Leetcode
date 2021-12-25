package com.caldremch.leetcode

import kotlin.math.max

/**
 *
 * @auther Caldremch
 *
 * @email finishmo@qq.com
 *
 * @date 2021/5/30 23:45
 *
 * @description
 *
 *
 */

class Solution3 {

    fun lengthOfLongestSubstring(s: String): Int {

        if (s.isEmpty()) return 0

        if (s.length == 1) return 1

        val chars = s.toCharArray()
        val map = HashMap<Char, Boolean>(s.length)
        var currentMaxCount = 0
        var everyMaxCount = 0
        chars.forEach {
            if (map.containsKey(it)) {
                if (currentMaxCount < everyMaxCount) {
                    currentMaxCount = everyMaxCount
                    everyMaxCount = 1
                }

            } else {
                map[it] = true
                everyMaxCount++
            }
        }

        return currentMaxCount
    }


    fun fuck(input: String): Int {
        val charArray = input.toCharArray()
        var lastChar: Char? = null
        val map = LinkedHashMap<Char, Int>(input.length)
        var currentMaxWidth: Int = 0

        //记住char个下标, 用于清楚某个重复元素之前的元素
        val charIndexMap = HashMap<Int, Char>(input.length)
        //charIndexMap.put(index, it)

        //n*logN*n
        var totalRemove: Int = 0
        charArray.forEachIndexed { index, it ->
            if (it == lastChar) {
                //统计当前宽度
                if (map.size > currentMaxWidth) {
                    currentMaxWidth = map.size
                }
                //请款bucket的所有值
                map.clear()
                //然后保留一个当前重复的char
                map[it] = 0
            } else {

                //判断是否已经存在Char
                if (map.containsKey(it)) {
                    //互换位置继续
                    //统计当前的最大值
                    if (map.size > currentMaxWidth) {
                        currentMaxWidth = map.size
                    } else {
                        //继续存放下一个bucket
                    }

                    //做char的位置切换, 并清除之前重复元素之前的char
                    val targetIndex = map[it]!! - totalRemove
                    //已经移除的index, 到下次的时候, 再次移除, 会有下标的问题, 所以不应该从下标来考虑,
                    //而是从char的角度去考虑, 遇到target char , 就暂停
                    charArray.forEachIndexed { keyIndex, key ->
                        if (keyIndex <= targetIndex) {
                            totalRemove++
                            map.remove(key)
                        }
                    }
                    //放入bucket
                    map[it] = index
                    lastChar = it
                    return@forEachIndexed
                }
                //放入bucket
                map[it] = index
                lastChar = it
            }
        }
        if (map.size > currentMaxWidth) {
            currentMaxWidth = map.size
        }
        println("max=$currentMaxWidth")
        return currentMaxWidth
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution3()
            println(lengthOfLongestSubstring("bpfbhmipx"))
            println(lengthOfLongestSubstring("abcabcbb"))
            println(lengthOfLongestSubstring("bbbbb"))
            println(lengthOfLongestSubstring("pwwkew"))
            println(lengthOfLongestSubstring(""))
            println(lengthOfLongestSubstring("cdd"))
            println(lengthOfLongestSubstring("abba"))
//           println( s.lengthOfLongestSubstring(" 12 345  "))
            //" 12 345  " --->
            //"abcabcbb"

        }
    }
}

/**
 * 分析
 *
 * bpfbhmipx 时间遍历:n
 *
 * 链表的删除是1, 但是找到的链表target需要n  ===>最终时间还是n2 ,
 *
 * 如果能减少查找, 就很好了, 如果要拿最终的字符串结果, 就永远避不开查找,
 * 但是如果只是需要数字的话, 不需要关注到字符本身
 *
 *
 * 012345678
 * bpfbhmipx
 *
 * 0123-->3
 * bpfb-->
 *
 * 0123456-->6
 * bpfbhmi-->
 *
 * 012345678--> 7
 * bpfbhmipx--> 7
 *
 *
 * bpf-->入列, 此时遇到b
 *
 *
 *
 * abcabcbb
 *
 *
 *
 * abcdc12345
 * 4-1 = 3
 *
 * 如果1不是第一个 , 那就 那就再-2 2
 *
 *
 * 应该关注的是数字
 * 永远保持第一个元素从0 开始, 并且后面都是组件按 1递增的
 *
 * [pwwkew]
 * [pwpkew]
 * 遇到重复的时候,记一次pww -->计数 2
 * 减少个数 pww w 重复, w的下标1 减少01下标的元素 , 此时剩下w
 *
 * wke==>计数3 遇到w , 减掉0, 此时 kew. 如果当前是最后一个元素, 则计数最大值
 *
 *
 *
 *
 *
 */

fun lengthOfLongestSubstring(input: String): Int {

    if (input.isEmpty()) return 0
    var maxLen = 0
    val charArray = input.toCharArray()
    val size = input.length
    val map = LinkedHashMap<Char, Int>(size)
    var count = 0 //代表当前有效的序列
    var totalSub = 0 //被减掉的个数
    //[pwwkew]
    charArray.forEachIndexed { index, it ->
        if (map.containsKey(it)) {
            //记录子串的长度
            if (count > maxLen) {
                maxLen = count
            }
            count++
            val index = map.get(it)!!
            if (index<totalSub){
                //如果是已经被剪掉的元素, 则当做不包含处理
            }else{
                //计算出当前需要被剪掉的个数
                val needSub = index - totalSub

                //根据下标的规则, 需要将下标+1
                count -= (needSub + 1)
                //统计总减数
                totalSub += needSub + 1
                if (count > maxLen) {
                    maxLen = count
                }
            }


        }else{
            count++
        }
        map[it] = index //直接覆盖
        if (index == size - 1) {
            if (count > maxLen) {
                maxLen = count
            }
        }
    }
    return maxLen
}
