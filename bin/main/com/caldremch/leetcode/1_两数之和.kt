package com.caldremch.leetcode

//nums = [2,7,11,15], target = 9
/**
 * 2-->0    9
 * 11-->1    9
 * 7-->2    9
 * 15-->3   9
 *
 *
 *
 * 分析
 *
 */
class Solution1 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, value ->
            if (map[target-value] == null){
                map[value] = index
            }else{
                return intArrayOf(index, map[target-value]!!)
            }
        }
        return intArrayOf(0,0)
    }

    fun twoSumZY(nums: IntArray, target: Int): IntArray {
        var result = IntArray(2)
        val map = HashMap<Int, Int>(nums.size * 2)
        for (i in nums.indices) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map[target - nums[i]]!!
                result[1] = i
                return result
            }
            map[nums[i]] = i
        }
        return result
    }
}