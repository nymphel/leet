package leet.remove.nth.node.from.end;

import java.util.LinkedList;
import java.util.List;


public class Solution {

    public static void main(String[] args) {

        ListNode n1 = new ListNode();
        n1.val = 1;

        ListNode n2 = new ListNode();
        n2.val = 2;

        ListNode n3 = new ListNode();
        n3.val = 3;

        ListNode n4 = new ListNode();
        n4.val = 4;

        ListNode n5 = new ListNode();
        n5.val = 5;

        n1.next = n2;
        //n2.next = n3;
        //n3.next = n4;
        //n4.next = n5;

        Solution solution = new Solution();
        solution.removeNthFromEnd(n1, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new LinkedList<>();
        list.add(head);

        ListNode pointer = head;
        while (pointer.next != null) {
            list.add(pointer.next);
            pointer = pointer.next;
        }

        if(list.size() == 1){
            return null;
        }

        ListNode prev = null;
        if(list.size() > n){
            prev = list.get(list.size() - n - 1);
        }

        if(prev != null) {
            ListNode next = null;
            if(n > 1) {
                next = list.get(list.size() - n + 1);
            }

            prev.next = next;
        } else {
            head = head.next;
        }


        return head;


    }
}
