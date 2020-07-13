package com.supinfo.gmy.algorithm;

/** 
* @Description: 序列化二叉树
* @author: gaomingyang
* @date: 2020-07-13
*/
public class Question40 {
	private String deserializeStr;

	/**
	* @Description: 序列化
	* @param root
	* @return 
	*/
	public String Serialize(TreeNode root) {
		if (root == null)
			return "#";
		return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
	}

	/**
	* @Description: 反系列化
	* @param str
	* @return 
	*/
	public TreeNode Deserialize(String str) {
		deserializeStr = str;
		return Deserialize();
	}

	private TreeNode Deserialize() {
		if (deserializeStr.length() == 0)
			return null;
		int index = deserializeStr.indexOf(" ");
		String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
		deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
		if (node.equals("#"))
			return null;
		int val = Integer.valueOf(node);
		TreeNode t = new TreeNode(val);
		t.left = Deserialize();
		t.right = Deserialize();
		return t;
	}
}
