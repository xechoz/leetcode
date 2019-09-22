package com.xechoz.app.leetcode

fun removeDuplicates(nums: IntArray): Int {
    return nums.toMutableList().apply {
        listIterator().apply {
            var last: Int? = null
            while (hasNext()) {
                next().let {
                    if (it != last) {
                        last= it
                    } else {
                        remove()
                    }
                }
            }
        }
    }.size
}