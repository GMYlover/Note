package com.supinfo.gmy.algorithm;

/** 
* @Description: 斐波那契函数，黄金分割，兔子数列
* @author: gaomingyang
* @date: 2020-04-06
*/
public class Question8 {
	/*考察如何用java表达斐波那契额函数,斐波那契额的思想*/
	public static void main(String[] args) {
		int result = getTotalRabbit(0);
		System.out.println(result);
	}

	/**
	* @Description: 递归思想，核心是f(n)=f(n-1)+f(n-2) 
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
