package com.supinfo.gmy.algorithm;

/**
 * @Description: 链表中倒数第 K 个结点
 * @author gmylover
 * @date 2020-05-20
 */
public class Question23 {
	/* 输入一个链表，输出该链表中倒数第k个结点。 */
	public ListNode FindKthToTail(ListNode head, int k) {
		// 假设有m个节点 输出第k个,需要先知道总共多少个，遍历多有节点获取总数 打印m-k
		ListNode forCount = head;

		int i = 1;
		while (forCount.next != null) {
			forCount = forCount.next;
			i++;
		}
		int p = 0;

		while (head.next != null) {
			if (i - k == p) {
				return head;
			}
			head = head.next;
			p++;
		}
		return null;
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
