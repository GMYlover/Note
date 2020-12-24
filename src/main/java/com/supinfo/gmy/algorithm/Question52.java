package com.supinfo.gmy.algorithm;

/** 
* @Description: 第一个只出现一次的字符位置
* 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
* [NowCoder](https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
* charAt转换为整型就是ascii码，转换为字符串就是对应的字符值
* @author: gaomingyang
* @date: 2020-12-23
*/
public class Question52 {
	public int solution(String str) {
		int[] word = new int[256];
		for (int i = 0; i < str.length(); i++) {
			word[str.charAt(i)] = i++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (word[str.charAt(i)] == 1) {
				return i;
			}
		}
		return -1;
	}

}
