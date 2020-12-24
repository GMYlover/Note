package com.supinfo.gmy.algorithm;

/** 
* @Description: 利用二叉查找树中序遍历有序的特点。
      解题:给定一棵二叉搜索树，请找出其中的第k小的结点。
* @author: gaomingyang
* @date: 2020-12-24
*/
public class Question56 {
	private TreeNode ret;
	private int cnt = 0;

	public TreeNode KthNode(TreeNode pRoot, int k) {
		inOrder(pRoot, k);
		return ret;
	}

	private void inOrder(TreeNode root, int k) {
		if (root == null || cnt >= k)
			return;
		inOrder(root.left, k);
		cnt++;
		if (cnt == k)
			ret = root;
		inOrder(root.right, k);
	}
}
