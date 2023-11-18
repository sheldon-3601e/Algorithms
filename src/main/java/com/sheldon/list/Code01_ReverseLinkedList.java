package com.sheldon.list;

/**
 * @ClassName ReverseLinkedList
 * @Author 26483
 * @Date 2023/11/16 12:00
 * @Version 1.0
 * @Description
 */
public class Code01_ReverseLinkedList {

    public static class Node{
        Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    // 单链表的反转
    public static Node reverseLinkList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 双链表的反转
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode next  = null;
        DoubleNode pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;

        }
        return pre;
    }

    public static void printList(Node node){
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        printList(node);
        node = reverseLinkList(node);
        printList(node);
    }
}
