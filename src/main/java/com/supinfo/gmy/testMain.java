package com.supinfo.gmy;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

public class testMain {

	public static void main(String[] args) {

		int a = 99;
		a &= -a;
		System.out.println(a);
	}

	private static StringBuffer createNonceStr() {
		String strPol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 16; i++) {
			sb.append(strPol.charAt(new Random().nextInt(15)));
		}
		System.out.println(sb);
		return sb;
	}

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		int i = 0, j = array.length - 1;
		while (i < j) {
			int cur = array[i] + array[j];
			if (cur == sum)
				return new ArrayList<>(Arrays.asList(array[i], array[j]));
			if (cur < sum)
				i++;
			else
				j--;
		}
		return new ArrayList<>();
	}

	/*	Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("appId", "62597");
		paramMap.put("nonceStr", "FGMFLLMLEJLLLKJM");
		paramMap.put("secret", "af906d9669facbcb");
		paramMap.put("timestamp", "1607911422");
					buffer.append(entry.getKey()).append(JOINEQUAL).append(entry.getValue()).append(JOINAND);
	
		*/

	private static void getStringa() {
		// TODO Auto-generated method stub
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("appId").append("=").append("dc3eecdcf9e7418ab01bbf59db300f59").append("&").append("nonceStr")
				.append("=")
				.append("HKEHMJLJMFMJDMKE").append("&").append("secret").append("=")
				.append("36285d93b8874b4ab741e2176fcce4b9")
				.append("&").append("timestamp").append("=").append("1607918076");
		// DigestUtils.sha256(new String(sBuffer));
		System.out.println(DigestUtils.sha256Hex(new String(sBuffer).getBytes()));
	}

	public static String sha256(byte[] data) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			return bytesToHex(md.digest(data));
		} catch (Exception ex) {
			return null;
		}
	}

	public static String bytesToHex(byte[] bytes) {
		String hexArray = "0123456789abcdef";
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) {

			int bi = b & 0xff;
			sb.append(hexArray.charAt(bi >> 4));
			sb.append(hexArray.charAt(bi & 0xf));
		}
		return sb.toString();
	}
}
