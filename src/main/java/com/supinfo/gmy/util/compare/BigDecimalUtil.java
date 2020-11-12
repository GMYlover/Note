package com.supinfo.gmy.util.compare;

import java.math.BigDecimal;

/** 
* @Description: BigDecimal比较大小工具类
* @author: gaomingyang
* @date: 2020-11-09
*/
public class BigDecimalUtil {

	private final BigDecimal value;

	private BigDecimalUtil(BigDecimal value) {
		this.value = value;
	}

	public static BigDecimalUtil of(BigDecimal value) {
		return new BigDecimalUtil(value);
	}

	// 小于
	public boolean lt(BigDecimal val) {
		return value.compareTo(val) == -1;
	}

	// 等于
	public boolean eq(BigDecimal val) {
		return value.compareTo(val) == 0;
	}

	// 大于
	public boolean gt(BigDecimal val) {
		return value.compareTo(val) == 1;
	}

	// 大于等于
	public boolean ge(BigDecimal val) {
		return value.compareTo(val) > -1;
	}

	// 小于等于
	public boolean le(BigDecimal val) {
		return value.compareTo(val) < 1;
	}

	// 区间 0<x<100
	public boolean between(BigDecimal min, BigDecimal max) {
		return gt(min) && lt(max);
	}

	// 区间 0<=x<100
	public boolean leftEqualBetween(BigDecimal min, BigDecimal max) {
		return ge(min) && lt(max);
	}

	// 区间 0<x<=100
	public boolean rightEqualBetween(BigDecimal min, BigDecimal max) {
		return gt(min) && le(max);
	}

	// 区间 0<=x<=100
	public boolean bothEqualBetween(BigDecimal min, BigDecimal max) {
		return ge(min) && le(max);
	}

}
