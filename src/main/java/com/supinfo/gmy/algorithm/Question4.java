package com.supinfo.gmy.algorithm;

import java.util.Stack;

/** 
* @Description: 从尾到头打印链表
* @author: gaomingyang
* @date: 2020-03-29
*/
public class Question4 {

	/*
	 从尾到头反过来打印出每个结点的值。
	Input:1,2,3
	Output:3,2,1
	*/

	public static void main(String[] args) {
		Node node = new Node(1);
		node.setNext(new Node(2));
		node.next.setNext(new Node(3));
		solution2(node);
	}

	/**
	* @Description: 
	* 解题:
	* 1 新建stack
	* 2遍历node并赋值到stack中
	* 3遍历stack
	* 知识点:
	* 1单向链表的基本数据结构
	* 2单向链表的赋值和遍历
	* 3其他基本数据类型的掌握程度比如arraylist和stack
	* 4递归的了解程度
	* 5头部插入法
	* @param node 
	*/
	public static void solution(Node node) {
		Stack<Integer> haha = new Stack<>();
		while (node.getNext() != null) {
			haha.add(node.value);
			node = node.next;
		}
		haha.add(node.value);
		for (Integer integer : haha) {
			System.out.println(integer);
		}
	}

	/**
	* @Description: 头部插入法
	* @param node 
	*/
	public static void solution2(Node node) {

	}

	/**
	* @Description: 递归法
	* @param node 
	*/
	public static void solution3(Node node) {
	}

	/** 
	* @Description: 静态内部类
	* 使用方式:
	* 1类上加static
	* 2先声明外部类,再声明内部类
	* 	Question4 question4 = new Question4();
	*	Node node = question4.new Node();
	* @author: gaomingyang
	* @date: 2020-03-29
	*/
	public static class Node {
		Node next;
		int value;

		public Node() {
		}

		public Node(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

}
