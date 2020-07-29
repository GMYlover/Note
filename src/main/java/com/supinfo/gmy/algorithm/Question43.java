package com.supinfo.gmy.algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

/** 
* @Description: 大小为 K 的最小堆
* O2-O1是递减，O1-O2是递增
* @author: gaomingyang
* @date: 2020-07-14
*/

public class Question43 {
	public static ArrayList<Integer> GetLeastNumbers_Solution1(int[] nums, int k) {
		if (k > nums.length || k <= 0)
			return new ArrayList<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		for (int num : nums) {
			maxHeap.add(num);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		ArrayList<Integer> ret = new ArrayList<>(maxHeap);
		return ret;
	}

	public static void main(String[] args) {
		int[] hh = { 1, 8, 4, 0, 5, 2 };
		System.out.println(GetLeastNumbers_Solution1(hh, 3).toString());
	}
}
