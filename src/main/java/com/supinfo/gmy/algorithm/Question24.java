package com.supinfo.gmy.algorithm;

import com.supinfo.gmy.algorithm.Question23.ListNode;

/**
 * @Description: 链表中环的入口结点
 * @author gmylover
 * @date 2020-05-23
 */
public class Question24 {
	/* 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。 */
	public ListNode EntryNodeOfLoop(ListNode pHead) {

		ListNode fast, slow;
		fast = slow = pHead;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}

		if (fast == null || fast.next == null)
			return null;
		ListNode slow2 = pHead;
		while (slow2 != slow) {
			slow2 = slow2.next;
			slow = slow.next;
		}
		return slow2;
	}
}
