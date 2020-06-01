package com.supinfo.gmy.algorithm;

import com.supinfo.gmy.algorithm.Question23.ListNode;

/**
 * @Description: 链表反转
 * @author gmylover
 * @date 2020-05-23
 */
public class Question25 {

	/* 输入一个链表，反转链表后，输出新链表的表头。 */
	public ListNode ReverseList(ListNode head) {
		
		ListNode next,pre;
		next=pre=null;
		while (head!=null) {
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		return pre;
	}

}
