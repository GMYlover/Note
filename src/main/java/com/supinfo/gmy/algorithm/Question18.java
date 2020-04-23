package com.supinfo.gmy.algorithm;

/** 
* @Description: 打印从 1 到最大的 n 位数
* 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
* @author: gaomingyang
* @date: 2020-04-22
*/
public class Question18 {

	/* 
	 * 解题:
	 * 1 边界，先看是否小于0
	 * 2确定打印的边界,也就是到索引位数=数组长度
	 * 3先循环个位数,再循环十位数,最后循环百位
	 * */

	public static void print1ToMaxOfNDigits(int n) {
		if (n <= 0)
			return;
		char[] number = new char[n];
		print1ToMaxOfNDigits(number, 0);
	}

	/**
	* @Description: 数组计数器
	* @param number 控制位数
	* @param digit 
	*/
	private static void print1ToMaxOfNDigits(char[] number, int digit) {
		if (digit == number.length) {
			printNumber(number);
			return;
		}
		for (int i = 0; i < 10; i++) {
			number[digit] = (char) (i + '0');
			print1ToMaxOfNDigits(number, digit + 1);
		}
	}

	private static void printNumber(char[] number) {
		int index = 0;
		// 遍历数组,找到需要打印的第一位数字
		while (index < number.length && number[index] == '0')
			index++;
		// 打印每一位
		while (index < number.length)
			System.out.print(number[index++]);
		// 回车
		System.out.println();
	}

	public static void main(String[] args) {
		// print1ToN(1);
		print1ToMaxOfNDigits(2);
	}

}
