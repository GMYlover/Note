package com.supinfo.gmy.algorithm;

/** 
* @Description: 数组中重复的数字
* @author: gaomingyang
* @date: 2020-03-28
*/
public class Question1 {

	/* 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
	 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
	 * Input:
	 * {2, 3, 1, 0, 2, 5}
	 * 还是不明白相关原理没有思考，
	 * 1对数据声明没有掌握
	 * 2根本没想明白如何实现，就去写代码，所以写不出来也正常
	 * 
	 * 解体:
	 * 1 首先判断当前索引对应的值是否等于当前索引等于则跳过当前索引
	 * 2 如果不等则判断此索引上的值是否已经有了且对应，如果对应则返回，否则交换
	 * 3 换完继续换直到index上的值等于当前index
	Output:
	2
	*/
	public static void main(String[] args) {
		int[] haha = new int[] { 2, 3, 1, 0, 2, 5 };
		solution(haha);
	}

	public static boolean solution(int[] args) {
		for (int index = 0; index < args.length; index++) {
			while (index != args[index]) {
				if (args[index] == args[args[index]]) {
					System.out.println(args[index]);
					return true;
				}
				swap(args, index, args[index]);
			}

		}
		return false;
	}

	public static void swap(int[] args, int first, int second) {
		int temp = args[first];
		args[first] = args[second];
		args[second] = temp;
	}

}
