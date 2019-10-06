package com.xechoz.app.leetcode.array

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/25/
 *
 * https://leetcode.com/problems/single-number/solution/
 */
fun singleNumber(nums: IntArray): Int {
    var num = 0

    nums.forEach {
        num = num.xor(it)
    }

    return num
}