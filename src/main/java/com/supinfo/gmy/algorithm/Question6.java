package com.supinfo.gmy.algorithm;

/** 
* @Description: 二叉树的下一个结点
* @author: gaomingyang
* @date: 2020-03-31
*/
public class Question6 {
	/*
	 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回 。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
	
	public class TreeLinkNode {
	
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null; // 指向父结点的指针
	
	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	*/

	/*	思路：
	 * 
	 *  		 A
	 *  	   /   \
	 *  	 B      C
	 *     /   \   /  \
	 *    D	   E   F   G
	 *        /  \
	 *        H  I 
	 * 
		（1） 若该节点存在右子树：则下一个节点为右子树最左子节点（如图节点 B ）
	
		（2） 若该节点不存在右子树：这时分两种情况：
	
		2.1 该节点为父节点的左子节点，则下一个节点为其父节点（如图节点 D ）
	
		2.2 该节点为父节点的右子节点，则沿着父节点向上遍历，知道找到一个节点的父节点的左子节点为该节点，则该节点的父节点下一个节点（如图节点 I ，沿着父节点一直向上查找找到 B （ B 为其父节点的左子节点），则 B 的父节点 A 为下一个节点）。*/

	/*	public class Solution {
		    public TreeLinkNode GetNext(TreeLinkNode pNode) {
		        if (pNode == null)
		            return pNode;
		        if (pNode.right != null) { // 节点有右子树
		            pNode = pNode.right;
		            while (pNode.left != null) {
		                pNode = pNode.left;
		            }
		            return pNode;
		        } else if ( pNode.next != null && pNode.next.left == pNode) { // 节点无右子树且该节点为父节点的左子节点
		            return pNode.next;
		        } else if (pNode.next != null && pNode.next .right == pNode) { // 节点无右子树且该节点为父节点的右子节点
		            while(pNode.next != null && pNode .next .left != pNode){
		                pNode = pNode.next ;
		            }
		            return pNode.next ;
		        }else{
		            return pNode.next ;//节点无父节点 ，即节点为根节点
		        }
		    }
		}*/
	/** 
	* @Description: 
	* 知识点:二叉树如何用中序遍历表示,以及中序遍历对数据的查找
	* 1 先创建一个中序树
	* 2 找到该节点
	* 3 找到该节点的下一个节点
	* @author: gaomingyang
	* @date: 2020-03-31
	*/
	public static class Solution {

		public TreeLinkNode GetNext(TreeLinkNode pNode) {
			if (pNode == null)
				return null;
			TreeLinkNode res;
			if (pNode.right == null) {
				res = pNode;
				while (res.next != null && res.next.right == res) {
					res = res.next;
				}
				return res.next;
			}
			res = pNode.right;
			while (res.left != null) {
				res = res.left;
			}
			return res;
		}

	}

	public static class TreeLinkNode {

		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null; // 指向父结点的指针

		TreeLinkNode(int val) {
			this.val = val;
		}
	}

	/*
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;
	
	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	*/

	public class Solution2 {
		boolean flag = false;
		TreeLinkNode result = null;

		public TreeLinkNode GetNext(TreeLinkNode pNode) {
			if (pNode == null)
				return null;
			TreeLinkNode head = pNode;
			while (head.next != null) {
				head = head.next;
			}
			midOrder(head, pNode);
			return result;
		}

		private void midOrder(TreeLinkNode tree, TreeLinkNode pNode) {
			if (tree.left != null) {
				midOrder(tree.left, pNode);
			}
			if (flag && result == null) { // 判断result==null非常重要 防止上层修改result的值
				result = tree;
				return;
			}
			if (tree.val == pNode.val && tree.left == pNode.left && tree.right == pNode.right
					&& tree.next == pNode.next) {
				flag = true;
			}
			if (tree.right != null) {
				midOrder(tree.right, pNode);
			}
		}
	}

}
