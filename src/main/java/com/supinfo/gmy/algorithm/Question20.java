package com.supinfo.gmy.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.White;

/** 
* @Description: 删除链表中重复的节点
* 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
* @author: gaomingyang
* @date: 2020-04-24
*/
public class Question20 {

	public void solution(ListNode head) {

		System.out.println(head.value);
		ListNode walkNode = head;
		while (walkNode.nextNode != null) {
			if (walkNode.value == walkNode.value) {
				
			}
			walkNode = walkNode.nextNode;
			System.out.println(walkNode.value);
		}

	}

	class ListNode {
		private int value;
		public ListNode nextNode;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public ListNode getNextNode() {
			return nextNode;
		}

		public void setNextNode(ListNode nextNode) {
			this.nextNode = nextNode;
		}

	}
}
