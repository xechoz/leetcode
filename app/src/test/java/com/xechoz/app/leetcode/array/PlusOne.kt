package com.xechoz.app.leetcode.array

fun plusOne(digits: IntArray): IntArray {
    var lastOne = 1

    for (i in digits.size-1 downTo 0) {
        val newValue = digits[i] + lastOne
        digits[i] = newValue % 10
        lastOne = if (newValue >= 10) 1 else 0

        if (lastOne <= 0) {
            break
        }
    }

    return if (lastOne == 1) {
        val result = IntArray(digits.size+1)
        result[0] = 1
        digits.copyInto(result, 1, 0)
        result
    } else {
        digits
    }
}