package com.sheldon.code02;

import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * @ClassName singlyLinkedList
 * @Author 26483
 * @Date 2023/12/4 12:01
 * @Version 1.0
 * @Description 单向链表（LinkedList
 */
public class singlyLinkedList {

    private Node head = new Node(-1, null);	// 头指针

    // 内部类
    private static class Node {
        int value;
        Node next;
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    // 向链表头部添加
    public void addFirst(int value) {
        // null
        // head = new Node(value,null);
        // not null
        // head = new Node(value, head);
        insert(0, value);
    }

    private Node findLast() {

        Node p;
        for(p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    // 向链表的尾部添加
    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    // 遍历链表
    public void loop(Consumer<Integer> consumer) {
        Node p = head.next;		// point
        while(p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    // 根据索引获取节点
    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    // 根据索引获取值
    public int get(int index) {
        Node node = findNode(index);
        if (node ==null) {
            extracted(index);
        }
        return node.value;
    }

    private static void extracted(int index) {
        throw new IllegalArgumentException(
                String.format("index error:%d", index));
    }

    // 向索引位置插入值
    public void insert(int index, int value) {

        Node prev = findNode(index - 1);
        if(prev == null) {
            extracted(index);
        }
        prev.next = new Node(value, prev.next);
    }

    // 删除头部
    public void removeFirst() {
        // if (head == null) {
        // 	throw new IllegalArgumentException();
        // }
        // head = head.next;
        remove(0);
    }

    // 删除索引位置元素
    public void remove(int index) {

        Node prev = findNode(index - 1);	//找到上一个节点
        if (prev == null) {
            extracted(index);
        }
        Node remove = prev.next;	// 被删除节点
        if (remove == null) {
            extracted(index);
        }
        prev.next = remove.next;
    }

}
