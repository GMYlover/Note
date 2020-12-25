package com.supinfo.gmy.algorithm;

/** 
* @Description: "nowcoder. a am I"
"I am a nowcoder."
* @author: gaomingyang
* @date: 2020-12-25
*/
public class Question63 {
	private static void solutiona() {
		String haha1 = "nowcoder. a am I";
		String[] hh = haha1.split(" ");
		StringBuffer sBuffer = new StringBuffer();
		for (int i = hh.length - 1; i >= 0; i--) {
			sBuffer.append(hh[i] + " ");
		}
		System.out.println(sBuffer);
	}

	public static void main(String[] args) {
		System.out.println(ReverseSentence("nowcoder. a am I"));
	}

	public static String ReverseSentence(String haha1) {
		String[] hh = haha1.split(" ");
		StringBuffer sBuffer = new StringBuffer();
		for (int i = hh.length - 1; i >= 0; i--) {
			sBuffer.append(hh[i] + " ");
		}
		return new String(sBuffer);
	}
}
