package com.xechoz.app.leetcode

private const val RADIUS = 10
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var left: ListNode? = l1
    var right: ListNode? = l2
    val head = ListNode(0)
    var next: ListNode = head

    // add head
    while (left != null || right != null) {
        add(left, right, next)

        left = left?.next
        right = right?.next

        if (left == null && right == null) {
            if (next.next?.`val` == 0) {
                next.next = null
            }

            break
        } else {
            next = next.next!!
        }
    }
    return head
}

private fun add(left: ListNode?, right: ListNode?, node: ListNode) {
    val temp = node.`val` + if (left == null) {
        right?.`val` ?: 0
    } else {
        left.`val` + (right?.`val` ?: 0)
    }

    if (temp >= RADIUS) {
        node.`val` = temp - RADIUS
        node.next = ListNode(1)
    } else {
        node.`val` = temp
        node.next = ListNode(0)
    }
}


class ListNode(var `val`: Int) {
    constructor(value: Int, node: ListNode?) : this(value) {
        next = node
    }

    var next: ListNode? = null

    override fun equals(other: Any?): Boolean {
        (other as? ListNode)?.let {
            return `val` == it.`val` && (if (next == null) (other.next == null) else next?.equals(other.next) == true)
        }

        return super.equals(other)
    }

    override fun toString(): String {
        var result = "$`val`"
        var temp = next

        while (temp != null) {
            result += "->${temp.`val`}"
            temp = temp.next
        }

        return result
    }
}