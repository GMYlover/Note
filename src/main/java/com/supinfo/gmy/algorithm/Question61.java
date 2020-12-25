package com.supinfo.gmy.algorithm;

import java.util.ArrayList;
import java.util.List;

/** 
* @Description: 和为 S 的连续正数序列
* 输出所有和为 S 的连续正数序列。
     例如和为 100 的连续序列有：
* @author: gaomingyang
* @date: 2020-12-25
*/
public class Question61 {
	public int[][] findContinuousSequence(int target) {
		// 存放最终的结果集
		List<int[]> result = new ArrayList<>();

		// n：低位数字 m：高位数字
		int n = 1, m = 2;

		/**
		 * sum < target 的话，说明m可以往后移动，来增大sum
		 * sum > target 的话，需要n往后移动来减少元素个数，减少sum的值
		 * sum = target 的话，把 n 到 m 之间的数枚举出来
		 * 结束条件为 n< m
		 */
		while (n < m) {
			// 等差数列求和
			int sum = ((n + m) * (m - n + 1)) / 2;
			if (sum == target) {
				// 枚举 n 到 m 之间的元素
				int[] temp = new int[m - n + 1];
				int j = n;
				for (int i = 0; i < temp.length; i++) {
					temp[i] = j;
					j++;
				}
				result.add(temp);
				// 前指针向前移动
				n++;
			} else if (sum < target) {
				m++;
			} else {
				n++;
			}
		}
		return result.toArray(new int[0][0]);
	}

}
