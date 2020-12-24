package com.supinfo.gmy.algorithm;

/** 
* @Description: 平衡二叉树
* 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
平衡二叉树（Balanced Binary Tree），具有以下性质：
它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
* @author: gaomingyang
* @date: 2020-12-24
*/
public class Question58 {
	private boolean isBalanced = true;

	public boolean IsBalanced_Solution(TreeNode root) {
		height(root);
		return isBalanced;
	}

	private int height(TreeNode root) {
		if (root == null || !isBalanced)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		if (Math.abs(left - right) > 1)
			isBalanced = false;
		return 1 + Math.max(left, right);
	}
}
