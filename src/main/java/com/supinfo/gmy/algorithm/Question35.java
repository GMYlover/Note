package com.supinfo.gmy.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 按之字形顺序打印二叉树
 * @author gmylover
 * @date 2020-06-08
 */
public class Question35 {
	/* 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。 */
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(pRoot);
		boolean reverse = false;
		while (!queue.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<>();
			int cnt = queue.size();
			while (cnt-- > 0) {
				TreeNode node = queue.poll();
				if (node == null)
					continue;
				list.add(node.val);
				queue.add(node.left);
				queue.add(node.right);
			}
			if (reverse)
				Collections.reverse(list);
			reverse = !reverse;
			if (list.size() != 0)
				ret.add(list);
		}
		return ret;
	}
}
