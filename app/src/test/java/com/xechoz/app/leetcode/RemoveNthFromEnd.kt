package com.xechoz.app.leetcode

class RemoveNthFromEnd {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        var count = 0

        var targetNode: ListNode? = null
        var next = head
        var moveStep = 0

        while (next != null) {
            next = next.next
            count++

            if (count >= n) {
                moveStep++
            }
        }

        next = head
        while (moveStep > 0 && next != null) {
            moveStep--

            if (moveStep == 0) {
                next.next = next.next?.next
                break
            } else {
                next = next.next
            }
        }

        return head
    }
}