package com.supinfo.gmy.algorithm;

/** 
* @Description: 在 O(1) 时间内删除链表节点
* @author: gaomingyang
* @date: 2020-04-23
*/
public class Question19 {
	/**
	* @Description: 分为三种情况
	* 1 如果节点只有一个
	* 2 如果节点不是尾部节点
	* 3 尾部节点
	* @param pHead
	* @param pDeleteNode 
	*/
	public static ListNode solution(ListNode pHead, ListNode pDeleteNode) {
		if (pDeleteNode.nextNode != null) {
			pDeleteNode.value = pDeleteNode.nextNode.value;
			pDeleteNode.nextNode = pDeleteNode.nextNode.nextNode;
		} else if (pHead == pDeleteNode) {
			pHead = null;
		} else {
			ListNode indexNode = pHead;
			while (indexNode.nextNode != pDeleteNode) {
				indexNode = indexNode.nextNode;
			}
			//这有疑问，为啥这里赋值能影响pHead,上面的indexNode = indexNode.nextNode却不影响
			indexNode.nextNode = null;
		}
		return pHead;
	}

	class ListNode {
		int value;
		ListNode nextNode;

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

	public static void main(String[] args) {
		ListNode ln1 = new Question19().new ListNode();
		ListNode ln2 = new Question19().new ListNode();
		ListNode ln3 = new Question19().new ListNode();
		ListNode ln4 = new Question19().new ListNode();
		ListNode ln5 = new Question19().new ListNode();
		ListNode ln6 = new Question19().new ListNode();
		ListNode ln7 = new Question19().new ListNode();
		ListNode ln8 = new Question19().new ListNode();
		ln1.nextNode = ln2;
		ln2.nextNode = ln3;
		ln3.nextNode = ln4;
		ln4.nextNode = ln5;
		ln5.nextNode = ln6;
		ln6.nextNode = ln7;
		ln7.nextNode = ln8;
		ln8.nextNode = null;
		ln1.value = 1;
		ln2.value = 2;
		ln3.value = 3;
		ln4.value = 4;
		ln5.value = 5;
		ln6.value = 6;
		ln7.value = 7;
		ln8.value = 8;

		Question19 m1 = new Question19();
		m1.solution(ln1, ln8);
		while (ln1 != null) {
			System.out.println(ln1.value);
			ln1 = ln1.nextNode;
		}
	}
}
