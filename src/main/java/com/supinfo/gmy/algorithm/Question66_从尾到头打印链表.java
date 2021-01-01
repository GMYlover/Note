package com.supinfo.gmy.algorithm;

import java.util.ArrayList;

/** 
* @Description: 
* 题目描述
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
示例1
输入
{67,0,24,58}

返回值
[58,24,0,67]
* @author: gaomingyang
* @date: 2021-01-01
*/
public class Question66_从尾到头打印链表 {
	static ArrayList<Integer> arrayList = new ArrayList<Integer>();

	/**
	* @Description: 递归到最底层
	* @param listNode
	* @return 
	*/
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode != null) {
			printListFromTailToHead(listNode.next);
			arrayList.add(listNode.val);
		}
		return arrayList;
	}
	
}
