package com.supinfo.gmy.algorithm;

import java.util.Stack;

/** 
* @Description: 用两个栈实现队列
* @author: gaomingyang
* @date: 2020-03-31
*/
public class Question7 {
	Stack<Integer> in = new Stack<Integer>();
	Stack<Integer> out = new Stack<Integer>();

	/**
	* @Description: 
	* 知识点:
	* 1考察栈和队列的区别
	* 2考察出栈和入栈 
	* 解题:
	* 入队：将元素进栈A
	* 出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；
	* 如果不为空，栈B直接出栈。
	* @param node 
	*/
	public void push(int node) {
		in.push(node);
	}

	public int pop() throws Exception {
		if (out.isEmpty())
			while (!in.isEmpty())
				out.push(in.pop());

		if (out.isEmpty())
			throw new Exception("queue is empty");

		return out.pop();
	}

}
