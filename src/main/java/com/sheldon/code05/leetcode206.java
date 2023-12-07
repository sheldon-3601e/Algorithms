package com.sheldon.code05;

/**
 * @ClassName leetcode206
 * @Author 26483
 * @Date 2023/12/7 18:33
 * @Version 1.0
 * @Description 反转单链表
 */
public class leetcode206 {

    public ListNode reverseList01(ListNode o1) {
        ListNode n1 = null;
        ListNode p = o1;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;

    }

    public ListNode reverseList02(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);
        while (true) {
            ListNode first = list1.removeFirst();
            if (first == null) {
                break;
            }
            list2.addFirst(first);
        }
        return list2.head;
    }

    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (head != null) {
                head = first.next;
            }
            return first;
        }
    }

}
