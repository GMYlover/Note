package com.supinfo.gmy.algorithm;

import java.util.HashMap;
import java.util.Map;

/*最长不含重复字符的子字符串
输入一个字符串（只包含 a\~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
*/
public class Question50 {
	public static int longestSubStringWithoutDuplication(String str) {
		int length = 0;
		char[] hahas = str.toCharArray();
		for (int i = 0; i < hahas.length; i++) {
			Map<Character, String> map = new HashMap<Character, String>();
			int lengthLocal = 0;
			for (int j = i; j < hahas.length; j++) {
				char a = hahas[j];
				if (map.containsKey(a)) {
					if (lengthLocal < length) {
						break;
					} else {
						length = lengthLocal;
						break;
					}
				} else {
					map.put(a, "");
					if (hahas.length - i == map.size() && map.size() > length) {
						length = map.size();
					}
					lengthLocal++;
				}
			}
		}
		return length;
	}
}
