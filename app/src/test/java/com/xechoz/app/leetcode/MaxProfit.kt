package com.xechoz.app.leetcode

/**
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/22/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
fun maxProfit(prices: IntArray): Int {
    var sum = 0
    var buyAt: Int
    var sellAt = -1

    var info = ""

    while (true) {
        buyAt = buyAt(sellAt + 1, prices)

        if (buyAt >= 0) {
            sellAt = sellAt(buyAt + 1, prices)
        } else {
            break
        }

        if (sellAt >= 0) {
            sum += prices[sellAt] - prices[buyAt]
            info += "[${prices[buyAt]}, ${prices[sellAt]}],"
        } else {
            break
        }
    }

    println("[${prices.joinToString(",")}], info $info")
    return sum
}

/**
 * 买入点是谷底，就是第二天开始涨的点
 */
private fun buyAt(from: Int, prices: IntArray): Int {
    for (i in from until  prices.size-1) {
        if (prices[i+1] > prices[i]) {
            return i
        }
    }

    return -1
}

/**
 * 卖出点 就是峰值，就是 第二天开始降的点
 */
private fun sellAt(from: Int, prices: IntArray): Int {
    for (i in from until  prices.size) {
        if (i == prices.size-1 || prices[i+1] < prices[i]) {
            return i
        }
    }

    return -1
}