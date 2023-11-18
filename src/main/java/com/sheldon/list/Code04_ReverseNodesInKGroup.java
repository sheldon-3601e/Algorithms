package com.sheldon.list;

// 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
public class Code04_ReverseNodesInKGroup {

	public static void main(String[] args) {
		ListNode start = new ListNode(1);
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		start.next = l1;

		printListNode(start);

//		ListNode end = getKGroupEnd(start, 4);
//		reverse(start, end);
//
//		printListNode(end);

		ListNode head = reverseKGroup(start, 3);

		printListNode(head);
	}

	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode start = head;
		ListNode end = getKGroupEnd(start, k);
		if (end == null) {
			return head;
		}
		// 第一组凑齐了！
		head = end;
		reverse(start, end);
		// 上一组的结尾节点
		ListNode lastEnd = start;
		while (lastEnd.next != null) {
			start = lastEnd.next;
			end = getKGroupEnd(start, k);
			if (end == null) {
				return head;
			}
			reverse(start, end);
			lastEnd.next = end;
			lastEnd = start;
		}
		return head;
	}

	public static ListNode getKGroupEnd(ListNode start, int k) {
		while (--k != 0 && start != null) {
			start = start.next;
		}
		return start;
	}

	public static void reverse(ListNode start, ListNode end) {
		end = end.next;
		ListNode pre = null;
		ListNode cur = start;
		ListNode next = null;
		while (cur != end) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		start.next = end;
	}

	public static void printListNode(ListNode listNode){
		do {
			System.out.print(listNode.val);
			listNode = listNode.next;
		} while (listNode.next != null);
		System.out.println();
	}


}