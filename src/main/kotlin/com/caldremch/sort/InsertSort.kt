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
object InsertSort {

    //5,1,6,2,4
    fun insertSort(array: Array<Int>){
        var i = 1;
        var j = 1
        //i为无序数组的开始
        while (i<array.size){
            //j有序数组的个数
            for (k in 0 until j){
                if (array[i]< array[k]){
                    val temp = array[k]
                    array[k] = array[i]
                    array[i] = temp
                }
            }
            j++
            i++

        }
    }


    /**
     * 算法心得:元素的移动模板可以先写出来,这样可以清晰的知道元素的移动和走向是如何的
     */
    fun standardInsertSort(array: Array<Int>){
        val n = array.size
        var i = 1
        var j = 0
        while (i < n){
            //3,1,2
            val num = array[i]
            //将无序数组插入有序数组, 注意: 是寻找合适的位置
            j = i-1
            while (j>=0 && array[j] > num){
                array[j+1]  = array[j] //后移一个位置, 主要是为了找合适的index
                //有序数组继续往前移动找最合适的
                --j
            }
            //当遇到j的值<当前的num值的时候, 就可以插入位置, 而且插入的肯定是在j后面
            array[j+1] = num
            //继续走下一个
            ++i

        }

    }


    @JvmStatic
    fun main(args:Array<String>){
        val array = arrayOf(2,3,12,23,234,1,7)
        val array2= arrayOf(1, 2, 3, 7, 12, 23, 234)
        insertSort(array)
        standardInsertSort(array2)
        println(array.contentToString())
        println(array2.contentToString())
    }
}