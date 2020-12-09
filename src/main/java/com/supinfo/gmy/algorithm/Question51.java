package com.supinfo.gmy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
# 49. 丑数

[NowCoder](https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 题目描述

把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
*/
public class Question51 {

	private static int test(int source) {
		List<Integer> ugList = new ArrayList<>();
		ugList.add(1);
		int min;
		int listMin;
		while (true) {
			int a = 2;
			int b = 3;
			int c = 5;
			min = 0;
			listMin = 0;
			for (Integer var : ugList) {
				int[] aaa = new int[] { var * a, var * b, var * c };
				Arrays.sort(aaa);
				for (Integer x : aaa) {
					if (!ugList.contains(x)) {
						listMin = x;
						break;
					}
				}
				if (min == 0) {
					min = listMin;
				}
				if (min != 0 && listMin < min) {
					min = listMin;
				}
			}
			ugList.add(min);
			if (min > source) {
				break;
			}
		}
		return min;
	}
}
