package com.supinfo.gmy.algorithm;

import com.supinfo.gmy.algorithm.Question23.ListNode;

/** 
* @Description:  两个链表的第一个公共结点
* 可以看到两个链表中有一个公共节点，其中橙色的节点就是这两个链表的公共节点。  
看到这个题目，容易想到的方法是使用蛮力法解决：在第一个链表上顺序遍历每一个节点，每遍历到一个节点，就在第二个链表上顺序遍历每个节点。如果在第二个链表上有一个节点与第一个链表上的节点一样，则说明两个链表在这个节点上重合，于是就找到了他们的公共节点。
如果第一个链表的长度为m，第二个链表的长度为n，那么，显然该方法的时间复杂度是O（mn）。
通常蛮力法不会是最好的方法，我们接下来试着分析有公共节点的两个链表有哪些特点。从链表节点的定义可以看出，这两个链表是单向链表。如果两个单向链表有公共的节点，那么这两个链表从某一节点开始，他们的next都指向同一个节点。但由于是单向链表的节点，每个节点只有一个next，因此从第一个公共节点开始，之后他们的所有节点都是重合的，不可能再出现分叉。所以两个有公共节点而部分重合的链表，其拓扑形状看起来像一个Y，而不可能像一个X，如下图所示。
经过分析我们发现，如果两个链表有公共结点，那么公共结点出现在两个链表的尾部。如果我们从两个链表的尾部开始往前比较，那么最后一个相同的结点就是我们要找的结点。可问题是，在单向链表中，我们只能从头结点开始按顺序遍历，最后才能到达尾节点。最后到达的尾节点却要最先被比较，这听起来是不是像“后进先出”？于是我们就能想到用栈的特点来解决这个问题：分别把两个链表的结点放入两个栈里，这样两个链表的尾节点就位于两个栈的栈顶，接下来比较两个栈顶的结点是否相同。如果相同，则把栈顶弹出接着比较下一个栈顶，直到找到最后一个相同的节点。
在上述思路中，我们需要用两个辅助栈。如果链表的长度分别为m和n，那么空间复杂度是O(m+n)。这种思路的时间复杂度也是O(m+n）。和最开始的蛮力法相比，时间效率得到了提高，相当于是用空间消耗换取了时间效率。
之所以需要用到栈，是因为我们想同时遍历到达两个栈的尾节点。当两个链表的长度不相同时，如果我们从头开始遍历到达两个栈的尾节点的时间就不一致。其实解决这个问题还有一个更简单的办法：首先遍历两个链表得到他们的长度，就能知道哪个链表比较长，以及长的链表比短的链表多几个结点。在第二次遍历的时候，在较长的链表上先走若干步，接着同时在两个链表上遍历，找到的第一个相同的结点就是他们的第一个公共结点。
第三种思路比第二种思路相比，时间复杂度为O(m+n)，但我们不在需要辅助栈，因此提高了空间效率。当我们理清了解决问题的思路决定使用第三种方法查找两个链表的第一个公共节点的时候，就可以动手写代码了。
* @author: gaomingyang
* @date: 2020-12-24
*/
public class Question54 {

	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		int count1 = 0;
		int count2 = 0;
		ListNode commonNode = null;
		ListNode pNode1 = pHead1;
		ListNode pNode2 = pHead2;
		// 得到链表1的长度
		while (pNode1 != null) {
			count1++;
			pNode1 = pNode1.next;
		}
		// 得到链表2的长度
		System.out.println("List1的长度为：" + count1);
		while (pNode2 != null) {
			count2++;
			pNode2 = pNode2.next;
		}
		System.out.println("List1的长度为：" + count2);
		// 令pNode1和pNode2重新指向头结点
		pNode1 = pHead1;
		pNode2 = pHead2;
		int sub = count1 - count2;
		System.out.println("两个List相差" + sub + "个节点");
		// 先在长链表上走几步，再同时在两个链表上遍历
		if (sub > 0) {
			for (int i = 0; i < sub; i++) {
				pNode1 = pNode1.next;
			}
		} else {
			for (int i = 0; i < Math.abs(sub); i++) {
				pNode2 = pNode2.next;
			}
		}
		System.out.println("List1从" + pNode1.val + "开始比较，List2从" + pNode2.val + "开始比较");
		// 得到第一个公共节点
		while (pNode1 != null && pNode2 != null) {
			if (pNode1 != pNode2) {
				pNode1 = pNode1.next;
				pNode2 = pNode2.next;
			} else {
				commonNode = pNode1;
				return commonNode;
			}
		}
		return commonNode;
	}

}
