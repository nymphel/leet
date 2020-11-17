package leet.merge.k.sorted;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        //[[1,4,5],[1,3,4],[2,6]]
        ListNode[] nodes = new ListNode[3];

        nodes[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        nodes[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        nodes[2] = new ListNode(2, new ListNode(6));

        ListNode listNode = new Solution().mergeKLists(nodes);
        System.out.println(listNode);

    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        List<Integer> allValues = new ArrayList<>();
        for (ListNode listNode : lists) {
            if(listNode == null)
                continue;
            ListNode pointer = listNode;
            allValues.add(pointer.val);
            while (pointer.next != null) {
                allValues.add(pointer.next.val);
                pointer = pointer.next;
            }
        }
        
        if(allValues.size() == 0) {
            return null;
        }

        Collections.sort(allValues);

        ListNode head = new ListNode(allValues.get(0));
        ListNode pointer = head;
        for (int i =1; i<allValues.size(); i++) {
            pointer.next = new ListNode(allValues.get(i));
            pointer = pointer.next;
        }

        System.out.println(allValues);


        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}