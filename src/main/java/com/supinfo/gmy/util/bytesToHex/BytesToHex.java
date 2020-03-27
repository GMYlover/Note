package com.supinfo.gmy.util.bytesToHex;

/** 
* @Description: byte转换为16进制
* byte取值范围127到-128
* 前7位表示数值，第8位是符号位（0为正，1为负）
* 1=00000001  -1=10000001
* 00000000=0
* 10000000=-128(多出来一位，认为定义为-128)
* @author: gaomingyang
* @date: 2020-03-27
*/
public class BytesToHex {
	public static void main(String[] args) {
		byte b = 127;
		b += 1;
		System.out.println(b);
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuffer md5str = new StringBuffer();
		// 把数组每一字节换成16进制连成md5字符串
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			digital = bytes[i];
			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
		}
		return md5str.toString().toUpperCase();
	}

}
