package com.supinfo.gmy.algorithm;

/** 
* @Description: 重建二叉树
* @author: gaomingyang
* @date: 2020-03-29
*/
public class Question5 {

	/*	输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
		例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。*/

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		Question5 question5 = new Question5();

		TreeNode root = question5.reConstructBinaryTree(pre, in);
		System.out.println(root);

	}

	/**
	* @Description:  前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。然后分别对左右子树递归地求解。
	* 知识点:
	* 二叉树:后面讨论二叉树分类?
	* 二叉树一定是有序的:有序是为了高效搜索，如果无须，在搜索的时候就只能遍历了
	* 考察前序遍历，中序遍历，后续遍历的规则和特点
	* 前序遍历:
	* 又叫根左右遍历，其首先访问根结点然后遍历左子树，最后遍历右子树。
	* 以及如何创建前序中序后续遍历树
	* 中序遍历:
	* 先访问左子树再访问根节点再访问右子树
	* 后续遍历:
	* 先访问左子树，再访问右子树，再访问跟节点
	* 总结:前中后的规则是根据根节点访问顺序这个目标系确定的
	*/

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return root;
	}

	// 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
	/**
	* @Description: 创建树实现类
	* @param pre 前序list
	* @param startPre 前序开始索引
	* @param endPre 前序结束索引
	* @param in 中序list
	* @param startIn 中序开始索引
	* @param endIn 中序结束索引
	* @return 新树的根节点
	*/
	private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

		if (startPre > endPre || startIn > endIn)
			return null;
		TreeNode root = new TreeNode(pre[startPre]);
		// 这里获取的startIn和endIn可以固定为0到in.length,只要能遍历数组所有元素就ok,下面的方式只是少遍历元素了
		// i - startIn就是左子树的偏移量
		for (int i = startIn; i <= endIn; i++)
			if (in[i] == pre[startPre]) {
				root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
				root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
				break;
			}

		return root;
	}

}
