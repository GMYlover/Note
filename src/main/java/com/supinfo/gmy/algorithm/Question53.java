package com.supinfo.gmy.algorithm;

import com.supinfo.gmy.algorithm.Question23.ListNode;

/** 
* @Description: 51. 数组中的逆序对
* 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
* 并将P对1000000007取模的结果输出。
* @author: gaomingyang
* @date: 2020-12-23
*/
public class Question53 {
	public int InversePairs(int[] data) {
		int P = 0;
		if (data.length < 2)
			return P;
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j])
					P++;
			}
		}
		return P % 1000000007;
	}

	/*	设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
	当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；同样地，当访问链表 B 的指针访问到链表尾部时，
	令它从链表 A 的头部重新开始访问链表 A。
	这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。*/
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode l1 = pHead1, l2 = pHead2;
		while (l1 != l2) {
			l1 = (l1 == null) ? pHead2 : l1.next;
			l2 = (l2 == null) ? pHead1 : l2.next;
		}
		return l1;
	}

}
