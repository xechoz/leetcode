package com.xechoz.app.leetcode

fun containsDuplicate(nums: IntArray): Boolean {
    return nums.toSet().size < nums.size
}