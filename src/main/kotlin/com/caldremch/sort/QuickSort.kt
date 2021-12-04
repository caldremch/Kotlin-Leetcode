package com.caldremch.sort

/**
 *
 * @author Caldremch
 *
 * @email finishmo@qq.com
 *
 * @date 2021/9/2 21:50
 *
 * @description 详细思路见notion
 *
 *
 */
object QuickSort {


    fun quickSort(array: Array<Int>){

        val n = array.size
        //分治, 一定是找个数/位置, 将数组拆为k个子问题, 主要是这个拆分的问题怎么进行拆? 关键在这里
        //排序的前提是 2个以上进行比较, 所以最小的子问题就是2个数, 为什么元素的平等拆分, 那么分割数组
        //就从中间开始, 然后中间继续按照这样的方式继续拆分下去
        val mid = n/2
        recursion(array, mid, n)
    }



    /**
     *
     *问题演算 3,2,12,23,234,1,7
     *
     * 3,2,12  =>继续分解 [3,2],[12] ==> [2,3] [12]  [得解]
     *
     * 23,234,1,7  =>继续分解[23, 234], [1,7] =>    [得解]
     *
     * 那么问题来了, 如何合并?
     *
     * [23, 234], [1,7] 加入一个子数组的最大值, 都比另外一个数组都还要小, 那么直接将整个数组插入最前面
     *
     * 假如是这种 [12,  20] [11, 15] 中情况, 怎么合并?  只能不断的从其中一个数组不断取出  对应的数, 然后把将其放入另外一个数组合适
     *
     * 的位置
     *
     *
     *
     */

    fun swap(array: Array<Int>, i:Int, j:Int){
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    //[1,2] [3,4]

    /**
     * k个子问题, 为了形象的表达出这种分支, 分为left , right
     */
    fun recursion(array: Array<Int>, mid:Int, n:Int){

        if (mid==0 || mid == 1) return

        if (mid == 2){
//            swap(array, )
        }

        //left
        recursion(array, mid/2, mid)


        //right
        recursion(array, (n - mid)/2, n - mid)

    }

    //思路是找到那个中位数, 中位数的意思就是i, 左边的元素全部 全部小于mid , 右边的全部大于mid 这就分成了类似的问题
    //重点就是将中位数找出, left < n < right这样的策略,
    //2,3,12,23,234,1,7


    @JvmStatic
    fun main(args:Array<String>){
        val array = arrayOf(2,3,12,23,234,1,7)
        val array2= arrayOf(1, 2, 3, 7, 12, 23, 234)
        InsertSort.insertSort(array)
        InsertSort.standardInsertSort(array2)
        println(array.contentToString())
        println(array2.contentToString())
    }


}