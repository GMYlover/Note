package com.supinfo.gmy.algorithm;

/** 
* @Description: 数值的整数次方
* @author: gaomingyang
* @date: 2020-04-21
*/
public class Question17 {

	/**
	* @Description: 考察指数和底数的概念,分析掌握的情况
	* 1 底数为0和不为零
	* 2指数大于0，小于0 ，等于0
	* @param base
	* @param exponent 
	*/
	public double Power(double base, int exponent) {
		// 1底数
		if (0 == base)
			return 0;
		// 2指数
		double result = base;
		if (exponent > 0) {
			for (int i = 1; i < exponent; i++) {
				result *= base;
			}
			return result;
		} else if (exponent < 0) {
			for (int i = -1; i > exponent; i--) {
				result *= base;
			}
			return 1 / result;
		} else {
			return 1;
		}
	}

}
