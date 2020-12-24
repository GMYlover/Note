package com.supinfo.gmy.algorithm;

/** 
* @Description: 二叉树的深度
* 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
* @author: gaomingyang
* @date: 2020-12-24
*/
public class Question57 {

	public int TreeDepth(TreeNode root) {
		return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
	}
}
