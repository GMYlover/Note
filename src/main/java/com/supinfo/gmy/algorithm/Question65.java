package com.supinfo.gmy.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

/** 
* @Description: 滑动窗口的最大值
* 题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
窗口大于数组长度的时候，返回空
输入
[2,3,4,2,6,2,5,1],3
返回值
[4,4,6,6,6,5]
* @author: gaomingyang
* @date: 2021-01-01
*/
public class Question65 {

	/**
	* @Description: 暴力
	* @param num
	* @param size
	* @return 
	*/
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (size > num.length || size == 0) {
			return result;
		}
		for (int i = 0; i < num.length; i++) {
			if (i > num.length - size) {
				break;
			}
			int maxNum = 0;
			for (int k = i; k <= i + size - 1; k++) {
				if (num[k] > maxNum) {
					maxNum = num[k];
				}
			}
			result.add(maxNum);
		}
		return result;
	}

	/**
	* @Description: 双端队列
	* @param num
	* @param size
	* @return 
	*/
	public static ArrayList<Integer> maxInWindows1(int[] num, int size) {
		ArrayList<Integer> ret = new ArrayList<>();
		if (num == null) {
			return ret;
		}
		if (num.length < size || size < 1) {
			return ret;
		}

		LinkedList<Integer> indexDeque = new LinkedList<>();
		for (int i = 0; i < size - 1; i++) {
			while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
				indexDeque.removeLast();
			}
			indexDeque.addLast(i);
		}

		for (int i = size - 1; i < num.length; i++) {
			while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
				indexDeque.removeLast();
			}
			indexDeque.addLast(i);
			if (i - indexDeque.getFirst() + 1 > size) {
				indexDeque.removeFirst();
			}
			ret.add(num[indexDeque.getFirst()]);
		}
		return ret;
	}
}
