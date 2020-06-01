package com.supinfo.gmy.algorithm;

/*操作给定的二叉树，将其变换为源二叉树的镜像。*/
public class Question27 {
	/*	二叉树的镜像定义：源二叉树 
	     8
	   /  \
	  6   10
	 / \  / \
	5  7 9 11
	镜像二叉树
	     8						
	   /  \
	  10   6
	 / \  / \
	11 9 7  5
	{8,6,10,5,7,9,11}
	8,10,6,11,9,7,5
	*/

	public class Solution {
		public void Mirror(TreeNode root) {
			if (root != null) {
				Mirror(root.left);
				Mirror(root.right);
				TreeNode temp = root.left;
				root.left = root.right;
				root.right = temp;
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);

		System.out.println("123");
	}

}
