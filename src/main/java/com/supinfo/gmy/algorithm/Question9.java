package com.supinfo.gmy.algorithm;

/** 
* @Description: 矩形覆盖
* @author: gaomingyang
* @date: 2020-04-06
*/
public class Question9 {
	/*	我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
	 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
	*/
	public static void main(String[] args) {
		int result = getTotalRabbit(0);
		System.out.println(result);
	}

	/**
	* @Description: 学会归纳总结，找出规律，一定要学会数学表达，然后用代码表达出来，本质就是兔子问题
	* @param a
	* @return 
	*/
	public static int getTotalRabbit(int a) {
		if (a <= 0)
			return 0;
		if (a == 1 || a == 2) {
			return a;
		}
		return getTotalRabbit(a - 1) + getTotalRabbit(a - 2);
	}
}
