package com.supinfo.gmy.algorithm;

import java.util.HashMap;
import java.util.Map;

/** 
* @Description: 数组中出现次数超过一半的数字
* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
* @author: gaomingyang
* @date: 2020-07-14
* 解题:1 key和次数放在map里面 2 二次循环map找到符合条件的值
*/
public class Question41 {
	public int MoreThanHalfNum_Solution(int[] array) {
		int needNum = array.length / 2;
		Map<Integer, Integer> testMap = new HashMap<Integer, Integer>();
		for (int var : array) {
			if (!testMap.containsKey(var)) {
				testMap.put(var, 1);
			} else {
				int count = testMap.get(var);
				testMap.put(var, count + 1);
			}
		}
		for (int a : testMap.keySet()) {
			if (testMap.get(a) > needNum) {
				return a;
			}
		}
		return 0;
	}
}
