package com.supinfo.gmy.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author gmylover
 * @date 2020-06-08
 */
public class QuestIon34 {
	/*
	 * 然后发现这题就是在从上往下打印基础上多了个层次问题。在while中加个int size = queue.size();就vans了
	 */
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> thelist = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null)
			return thelist; // 这里要求返回thelist而不是null
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(pRoot);
		while (!queue.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				list.add(temp.val);
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			}
			thelist.add(list);
		}
		return thelist;
	}
}
