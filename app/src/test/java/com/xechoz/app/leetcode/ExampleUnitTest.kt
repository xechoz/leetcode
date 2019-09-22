package com.xechoz.app.leetcode

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addTwo() {
        val left = ListNode(5)
        val right = ListNode(5)
        val desire = ListNode(0, ListNode(1))
        val result = addTwoNumbers(left, right)
        assertEquals(desire, result)
    }

    @Test
    fun remove() {
        val list = intArrayOf(1, 1, 2)
        val size = removeDuplicates(list)
        assertEquals(2, size)
    }

    @Test
    fun lengthOfLongestSubstring() {
        var str = "a"
        var expected = SlideInfo(str, 0, 0)
        var actual = slideOfString(str)
        println("$str, \nexpected: $expected, \nactual: $actual")
        assertEquals("lengthOfLongestSubstring", expected, actual)

        str = "ab"
        expected = SlideInfo(str, 0, 1)
        actual = slideOfString(str)
        println("$str, \nexpected: $expected, \nactual: $actual")
        assertEquals("lengthOfLongestSubstring", expected, actual)

        str = "aab"
        expected = SlideInfo(str, 1, 2)
        actual = slideOfString(str)
        println("$str, \nexpected: $expected, \nactual: $actual")
        assertEquals("lengthOfLongestSubstring", expected, actual)

        str = "dvdf"
        expected = SlideInfo(str, 1, 3)
        actual = slideOfString(str)
        println("$str, \nexpected: $expected, \nactual: $actual")
        assertEquals("lengthOfLongestSubstring", expected, actual)

        str = "ckilbkd"
        expected = SlideInfo(str, 2, 6)
        actual = slideOfString(str)
        println("$str, \nexpected: $expected, \nactual: $actual")
        assertEquals("lengthOfLongestSubstring", expected, actual)

        str =  "bbtablud"
        expected = SlideInfo(str, 2, 7)
        actual = slideOfString(str)
        println("$str, \nexpected: $expected, \nactual: $actual")
        assertEquals("lengthOfLongestSubstring", expected, actual)
    }
}