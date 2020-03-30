package com.supinfo.gmy.algorithm;

import java.util.HashMap;
import java.util.Map;

/** 
* @Description: 重建二叉树
* @author: gaomingyang
* @date: 2020-03-29
*/
public class Question5 {

	/*	输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
		例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。*/

	public static void main(String[] args) {

	}

	/**
	* @Description:  前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。然后分别对左右子树递归地求解。
	*/
	public static void solution() {

	}

	// 缓存中序遍历数组每个值对应的索引
	private Map<Integer, Integer> indexForInOrders = new HashMap<>();

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		for (int i = 0; i < in.length; i++)
			indexForInOrders.put(in[i], i);
		return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
	}

	private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
		if (preL > preR)
			return null;
		TreeNode root = new TreeNode(pre[preL]);
		int inIndex = indexForInOrders.get(root.val);
		int leftTreeSize = inIndex - inL;
		root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
		root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
		return root;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
