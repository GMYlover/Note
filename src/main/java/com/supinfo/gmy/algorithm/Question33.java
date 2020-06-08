package com.supinfo.gmy.algorithm;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 从上往下打印二叉树
 * @author gmylover
 * @date 2020-06-08
 */
public class Question33 {
	/*
	 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	 * 
	 * 例如，以下二叉树层次遍历的结果为：1,2,3,4,5,6,7
	 */

	/*
	 * 1 把根放到队列中 2 遍历队列，如果队列不为空，择将队列弹出的元素放到list中 3 然后将弹出元素的左右孩子放到队列中 4 直到队列为空结束
	 */
	public class Solution {
		public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			if (root == null)
				return result;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				TreeNode temp = queue.poll();
				result.add(temp.val);
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			}
			return result;
		}
	}

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
}
