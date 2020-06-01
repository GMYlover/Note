package com.supinfo.gmy.algorithm;

/**
 * @Description: 对称的二叉树
 * @author gmylover
 * @date 2020-06-01
 */
public class Question29 {
	/*请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。*/
	// 先假设左右子树下面都符合条件，然后比较左右子树，再往下比较
	public class Solution {
		boolean isSymmetrical(TreeNode pRoot) {
			if (pRoot == null) {
				return true;
			}
			return comRoot(pRoot.left, pRoot.right);
		}

		private boolean comRoot(TreeNode left, TreeNode right) {
			// TODO Auto-generated method stub
			if (left == null)
				return right == null;
			if (right == null)
				return false;
			if (left.val != right.val)
				return false;
			return comRoot(left.right, right.left) && comRoot(left.left, right.right);
		}
	}
}
