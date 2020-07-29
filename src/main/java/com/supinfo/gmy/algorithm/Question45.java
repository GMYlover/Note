package com.supinfo.gmy.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 41.2 字符流中第一个不重复的字符
 * @author gmylover
 * @date 2020-07-14
 */
public class Question45 {
	private int[] cnts = new int[256];
	private Queue<Character> queue = new LinkedList<>();

	public void Insert(char ch) {
		cnts[ch]++;
		queue.add(ch);
		while (!queue.isEmpty() && cnts[queue.peek()] > 1)
			queue.poll();
	}

	public char FirstAppearingOnce() {
		return queue.isEmpty() ? '#' : queue.peek();
	}
}
