package com.sheldon.code02;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @ClassName DoublyLinkedListSentinel
 * @Author 26483
 * @Date 2023/12/4 12:33
 * @Version 1.0
 * @Description 双向链表+哨兵
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {

    static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedListSentinel() {
        this.head = new Node(null, -1, null);
        this.tail = new Node(null, -1, null);
        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;

    }

    private static void extracted(int index) {
        throw new IllegalArgumentException(
                String.format("index error:%d", index));
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int value) {
        Node lastNode = tail.prev;
        Node newNode = new Node(lastNode, value, tail);
        lastNode.next = newNode;
        tail.prev = newNode;

    }

    public void removeLast() {
        Node remove = tail.prev;
        if (remove == head) {
            extracted(0);
        }
        Node prev = remove.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            extracted(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            extracted(index);
        }
        Node remove = prev.next;
        if (remove == tail) {
            extracted(index);
        }
        Node next = remove.next;
        prev.next = next;
        next.prev = prev;
    }

    public void loop1(Consumer<Integer> consumer) {
        for (Node p = head.next; p != tail; p = p.next) {
            consumer.accept(p.value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
