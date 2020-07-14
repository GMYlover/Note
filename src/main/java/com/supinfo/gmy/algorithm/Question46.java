package com.supinfo.gmy.algorithm;

/**
 * @Description: 连续子数组的最大和
 * @author gmylover
 * @date 2020-07-14
 */
public class Question46 {
	public static int FindGreatestSumOfSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int greatestSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int val : nums) {
			sum = sum <= 0 ? val : sum + val;
			greatestSum = Math.max(greatestSum, sum);
		}
		return greatestSum;
	}

	public static void main(String[] args) {
		int[] hah=  {6, -3, -2, 7, -15, 1, 2, 2};
		FindGreatestSumOfSubArray(hah);
	}
}
