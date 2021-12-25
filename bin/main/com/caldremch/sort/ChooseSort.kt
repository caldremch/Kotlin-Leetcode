package com.caldremch.sort

/**
 *
 * @auther Caldremch
 *
 * @email finishmo@qq.com
 *
 * @date 2021/8/24 22:14
 *
 * @description
 *
 *
 */
object ChooseSort {



    fun ChooseSort(array: Array<Int>){

        //长度 , 开始位置i, 和开始位置j
        val n = array.size
        var i = 0
        var j= 0

        //有序数组一开始没有

        while (i < n){

            //剩余要寻找的个数
            var minIndex = i

            //思路要清晰, i的开始, 后面的无需数组的大小都会不断的见效, 减小的过程就是j的移动
            j = i //这里才符合有序数组原本为0
            while(j<n){
                if(array[j]<array[minIndex]){
                    minIndex = j
                }
                j++
            }
            val temp = array[i]
            array[i] = array[minIndex]
            array[minIndex] = temp

            i++ //i移动
        }


    }


    @JvmStatic
    fun main(args:Array<String>){
        val array = arrayOf(2,3,12,23,234,1,7)
        val array2= arrayOf(1, 2, 3, 7, 12, 23, 234)
        ChooseSort(array)
        ChooseSort(array2)
        println(array.contentToString())
        println(array2.contentToString())
    }
}