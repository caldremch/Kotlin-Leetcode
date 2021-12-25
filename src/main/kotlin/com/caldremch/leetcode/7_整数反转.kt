package com.caldremch.leetcode

import kotlin.math.pow


/**
 * 第一个公式:
 * mod = 10(m次方) m从1开始
 * y=f(x%mod)
 *y=f(y*10) +y
 */
class Solution7 {


    fun reverse(x: Int): Int {

        if (x > Int.MAX_VALUE || x < Int.MIN_VALUE || x==0) {
            return 0
        }

        var result: Long = 0
        var perMod:Long= 1
        var perDivide:Long= 0L
        var perCal:Long = 0L

        while (true) {



            perMod *= 10
             perDivide  = if(perDivide == 0L) 1L else perDivide*10L
            //计算结果为0

            if(x>0 && x < perDivide) break
            if(x<0 && x > -perDivide) break

            val bo = if(x>0){
                x %perMod < ( perMod/10)
            }else{
                x %perMod > ( perMod/10)
            }

            if(bo && ((x %perMod)/perDivide )==0L){
                perCal = 0L
//                println("reverse: ($x%$perMod) /$perDivide  = $perCal")
                result = (result * 10 + perCal).toLong()
                continue
            }else{
                perCal = ((x %perMod) /perDivide ).toLong()
//                println("reverse: ($x%$perMod) /$perDivide  = $perCal")
            }


            result = (result * 10 + perCal).toLong()
        }

        if (result > Int.MAX_VALUE || result < Int.MIN_VALUE) {
            return 0
        }

        return result.toInt()
    }
}

fun main(args: Array<String>) {
    val solution2 = Solution7()
    println(solution2.reverse(123232223))
    println(solution2.reverse(123))
    println(solution2.reverse(-123))
    println(solution2.reverse(2147483647))
    println(solution2.reverse(12012))
    println(solution2.reverse(10))
    println(solution2.reverse(100))
    println(solution2.reverse(2100))
    println(solution2.reverse(20000001))
    println(solution2.reverse(-2147483647))
    println(solution2.reverse(0))
    println(solution2.reverse(0))

    println(solution2.reverse(-123))
}