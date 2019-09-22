package com.xechoz.app.leetcode

/**
 *
Given a string, find the length of the longest substring without repeating characters.
Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
fun lengthOfLongestSubstring(s: String): Int {
   return slideOfString(s).length()
}

fun slideOfString(s: String): SlideInfo {
    if (s.isEmpty()) {
       return SlideInfo(s, -1, -1)
    } else if (s.length == 1) {
        return SlideInfo(s, 0, 0)
    }

    val slide = SlideInfo(s, 0, 0)
    var longestInfo: SlideInfo = SlideInfo.from(slide)

    s.forEachIndexed { index, char ->
        val indexOfChar = slide.indexOf(char)

        // 特殊情况优化. 无论后面怎么加，都不可能有更长的substring 了
        if (s.length - slide.from < longestInfo.length()) {
            return@forEachIndexed
        }

        // 核心逻辑
        if (index != 0 && indexOfChar >= 0) {
            // update sliding info, slide is cut to less
            when (indexOfChar) {
                slide.from -> {
                    // 往右移动 1
                    slide.from++
                    slide.to = index
                }
                slide.to -> {
                    // 剩下最后一个
                    slide.from = index
                    slide.to = index
                }
                else -> {
                    // 把左边的剪掉
                    slide.from = indexOfChar+1
                    slide.to = index
                }
            }
        } else {
            slide.to = index

            // update longest info if sliding is longer
            // 大于才更新
            if (slide.length() > longestInfo.length()) {
                longestInfo = SlideInfo.from(slide)
            }
        }
    }

    return longestInfo
}

/**
 * 要得到 SubString，要有元数据，开始index，结束index
 * @param from 元数组的开始index. include
 * @param to 元数组的结束index. include
 */
data class SlideInfo(val originStr: String,
                     var from: Int = 0,
                     var to: Int = 0) {
    companion object {
        fun from(info: SlideInfo): SlideInfo {
            return SlideInfo(info.originStr, info.from, info.to)
        }
    }

    fun contains(char: Char): Boolean {
        return indexOf(char) >= 0
    }

    fun indexOf(char: Char): Int {
        for (index in IntRange(from, to)) {
            if (originStr[index] == char) {
                return index
            }
        }

        return -1
    }

    fun length(): Int {
        return if (from < 0 || to < 0) {
            0
        } else {
            to - from + 1
        }
    }

    override fun toString(): String {
        return "$originStr, from=$from, to=$to, subStr=${originStr.substring(from, to+1)}"
    }
}