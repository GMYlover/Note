package com.supinfo.gmy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/** 
* @Description: 最小的K个数
* 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
* @author: gaomingyang
* @date: 2020-07-14
*/
public class Question42 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		if (input.length < k) {
			return new ArrayList<>();
		}
		ArrayList<Integer> haha = new ArrayList<>();
		Arrays.sort(input);
		for (int i = 0; i < k; i++) {
			int j = input[i];
			haha.add(j);
		}
		return haha;
	}

}
