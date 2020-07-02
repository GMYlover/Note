package com.supinfo.gmy.util.money;

import java.math.BigDecimal;

public class BizUtils {

	/**
	* @Description: 分转元
	* @param fenStr
	* @return 
	*/
	public static BigDecimal fenToYuan(String fenStr) {
		return new BigDecimal(fenStr).divide(BigDecimal.valueOf(100L));
	}

	/**
	* @Description: 元转分
	* @param yuan
	* @return 
	*/
	public static String yuanToFen(BigDecimal yuan) {
		if (yuan != null) {
			return yuan.multiply(new BigDecimal(100)).toString();
		} else {
			return BigDecimal.ZERO.toString();
		}
	}

	/**
	* @Description: 元转分
	* @param yuan
	* @return 
	*/
	public static BigDecimal yuan2Fen(BigDecimal yuan) {
		if (yuan != null) {
			return yuan.multiply(new BigDecimal(100));
		} else {
			return BigDecimal.ZERO;
		}
	}

}
