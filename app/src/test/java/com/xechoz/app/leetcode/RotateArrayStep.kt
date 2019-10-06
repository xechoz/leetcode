package com.xechoz.app.leetcode

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
fun rotate(nums: IntArray, k: Int) {
    if (nums.size > 1) {
        val input = k % nums.size
        rotateTwoStep(nums, input)
    }
}

/**
 * 分3步，
 * 1. 把后面 k 个数保存
 * 2. 移动前面的 [0, n-k]
 * 3. 把保存的 [n-(k-1), n-1] 放到前面
 */
fun rotateTwoStep(nums: IntArray, k: Int) {
    val holder = nums.copyOfRange(nums.size-k, nums.size)

    for (i in nums.size-1 downTo k) {
        nums[i] = nums[i - k]
    }

    for (i in k-1 downTo 0) {
        nums[i] = holder[i]
    }
}

/**
 * 从n-1后往钱挪，直到挪到回到 n-1
 */
fun rotateLoop() {

}