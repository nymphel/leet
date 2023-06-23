class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val combined = mutableListOf<Int>()

        list1?.let {
            var n1 = list1
            while (n1 != null) {
                combined.add(n1.`val`)
                n1 = n1.next
            }
        }


        list2.let {
            var n2 = list2
            while (n2 != null) {
                combined.add(n2.`val`)
                n2 = n2.next
            }
        }

        if (combined.size == 0)
            return null

        combined.sort()
        val head = ListNode(combined[0])
        var cursor = head

        for (i in 1 until combined.size) {
            val node = ListNode(combined[i])
            cursor.next = node
            cursor = node
        }

        return head
    }
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {

}
