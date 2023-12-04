package com.sheldon.code02;

import java.util.Iterator;

/**
 * @ClassName DoublyToroidalLinkedListSentinel
 * @Author 26483
 * @Date 2023/12/4 17:54
 * @Version 1.0
 * @Description TODO
 */
public class DoublyToroidalLinkedListSentinel implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public DoublyToroidalLinkedListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    public void removeFirst() {
        Node remove = sentinel.next;
        if (remove == sentinel) {
            throw new IllegalStateException("error");
        }
        Node b = remove.next;
        Node a = sentinel;
        a.next = b;
        b.prev = a;
    }

    public void removeLast() {
        Node remove = sentinel.prev;
        if (remove == sentinel) {
            throw new IllegalStateException("error");
        }
        Node a = remove.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

    /**
     * 根据值删除
     * @param value
     */
    public void removeByValue(int value) {
        Node node = findNode(value);
        if (node == null) {
            throw new IllegalStateException("error");
        }
        Node a = node.prev;
        Node b = node.next;
        a.next = b;
        b.prev = a;

    }

    private Node findNode(int value) {
        for (Node p = sentinel.next; p != sentinel; p = p.next) {
            if (p.value == value) {
                return p;
            }
        }
        return null;
    }
}

