package com.sheldon.code05;

/**
 * @ClassName ListNode
 * @Author 26483
 * @Date 2023/12/7 18:34
 * @Version 1.0
 * @Description 很多链表题会用到的节点类
 */
public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[");
        ListNode p = this;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) {
                sb.append(",");
            }
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
