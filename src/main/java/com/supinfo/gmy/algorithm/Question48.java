package com.supinfo.gmy.algorithm;

import java.util.Arrays;

/**
 * @Description: 把数组排成最小的数 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，应该比较的是 S1+S2 和
 *               S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
 * @author gmylover
 * @date 2020-07-19
 */
public class Question48 {
	public static String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			return "";
		int n = numbers.length;
		String[] nums = new String[n];
		for (int i = 0; i < n; i++)
			nums[i] = numbers[i] + "";
		Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
		String ret = "";
		for (String str : nums)
			ret += str;
		return ret;
	}

	public static void main(String[] args) {
		int[] ff = { 3, 32, 321 };
		PrintMinNumber(ff);
	}
}
