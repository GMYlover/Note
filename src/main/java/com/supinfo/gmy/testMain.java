package com.supinfo.gmy;

import java.math.BigDecimal;

import com.supinfo.gmy.util.compare.BigDecimalUtil;

public class testMain {

	public static void main(String[] args) {
		BigDecimalUtil.of(new BigDecimal(11)).between(new BigDecimal(1), new BigDecimal(22));
		BigDecimalUtil.of(new BigDecimal(11)).leftEqualBetween(new BigDecimal(1), new BigDecimal(22));
		BigDecimalUtil.of(new BigDecimal(11)).le(new BigDecimal(2));
		System.out.println(123);
		System.out.println(333);
		System.out.println(666);
 				
		System.out.println(9999);
		System.out.println(0000);

		System.out.println(7777);

	}

}
