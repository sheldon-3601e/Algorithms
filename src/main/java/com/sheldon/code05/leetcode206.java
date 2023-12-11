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

    // 递归
    public ListNode reverseList03(ListNode head) {
        return null;
    }

    public static ListNode reverseList04(ListNode o1) {
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode n1 = o1;
        ListNode o2 = o1.next;

        while (o2 != null) {
            o1.next = o2.next;
            o2.next = o1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }

    public static ListNode reverseList05(ListNode o1) {
        ListNode n1 = null;

        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
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

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);

        System.out.println(l2);

        ListNode listNode = reverseList05(l2);
        System.out.println(listNode);

    }

}
