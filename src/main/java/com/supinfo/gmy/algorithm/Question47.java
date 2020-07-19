package com.supinfo.gmy.algorithm;

/**
 * @Description: 数字序列中某一位的数字
 *               数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * @author gmylover
 * @date 2020-07-19
 */

public class Question47 {
	public static int findNthDigit(int n) {
		int digit = 1; // n所在数字的位数
		long start = 1; // 数字范围开始的第一个数
		long count = 9; // 占多少位
		while (n > count) {
			n -= count;
			digit++;
			start *= 10;
			count = digit * start * 9;
		}
		long num = start + (n - 1) / digit;
		return Long.toString(num).charAt((n - 1) % digit) - '0';// 50-48(ascii)=2
	}

	public static void main(String[] args) {
		System.out.println(findNthDigit(2901)); // 2
	}

}
