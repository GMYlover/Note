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

	/*方法一就是递归思想,最后结果等于前一个和前2个*/
	public static int getTotalRabbit(int a) {
		if (a <= 0)
			return 0;
		if (a == 1 || a == 2) {
			return a;
		}
		return getTotalRabbit(a - 1) + getTotalRabbit(a - 2);
	}

}
