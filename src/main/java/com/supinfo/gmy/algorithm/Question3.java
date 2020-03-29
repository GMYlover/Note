package com.supinfo.gmy.algorithm;

/** 
* @Description: 替换空格
* @author: gaomingyang
* @date: 2020-03-29
*/
public class Question3 {

	/*
	 将一个字符串中的空格替换成 "%20"。
	Input:
		"A B"
	
		Output:
		"A%20B"
	*/

	public static void main(String[] args) {
		StringBuffer var = new StringBuffer("A B");
		solution(var);
	}

	/**
	* @Description: 主要考察对String类的掌握程度
	* 步骤:
	* 1找到空格
	* 2替换空格为%
	* 3加2位
	* 4替换后3位
	* 5break
	* 知识点:
	* 1char用单引号，String用双引号
	* 2要增加字符串长度用stringbuffer.append或者stringbuilder
	* 3--length先减后赋值
	* 4get,set字符串某个值var.charAt(index) var.setCharAt(index,' ')
	* @param var 
	*/
	public static void solution(StringBuffer var) {
		if (null == var || 0 == var.length()) {
			return;
		}
		for (int i = 0; i < var.length(); i++) {
			if (var.charAt(i) == ' ') {
				var.setCharAt(i, '%');
				var.append("  ");
				int length = var.length();
				var.setCharAt(--length, 'B');
				var.setCharAt(--length, '0');
				var.setCharAt(--length, '2');
				break;
			}
		}
		System.out.println(var);
	}

}
