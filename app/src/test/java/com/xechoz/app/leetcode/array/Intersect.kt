package com.xechoz.app.leetcode.array

/**
* Given two arrays, write a function to compute their intersection.
*
* Example 1:
*
* Input: nums1 = [1,2,2,1], nums2 = [2,2]
* Output: [2,2]
* Example 2:
*
* Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
* Output: [4,9]
* Note:
*
* Each element in the result should appear as many times as it shows in both arrays.
* The result can be in any order.
* Follow up:
*
* What if the given array is already sorted? How would you optimize your algorithm?
* What if nums1's size is small compared to nums2's size? Which algorithm is better?
* What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
**/
fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val result = mutableListOf<Int>()
    val countMap = mutableMapOf<Int, Int>()

    // size 较长的 array
    val longer = if (nums1.size >= nums2.size) nums1 else nums2
    // size 较短的 array
    val shorter = if (nums1.size >= nums2.size) nums2 else nums1

    // step: 1
    // 记录短数组里每个元素的出现次数，因为子集的元素是可能重复的
    // 用 map 是为了 在 step 2 的遍历避免 shorter 的查找
    shorter.forEach {
        countMap[it] = 1 + (countMap[it] ?: 0)
    }

    // step: 2
    longer.forEach {
        // 特殊情况处理，提前结束遍历. 最终结果可能是 shorter 的 子集, size 一定是 <= shorter.zie
        if (result.size >= shorter.size) {
            return@forEach
        }

        // 这里用 map 的代替 数组的查找
        val count = countMap[it]

        if (count != null && count >= 1) {
            result.add(it)
            countMap[it] = count - 1
        }
    }

    return result.toIntArray()
}