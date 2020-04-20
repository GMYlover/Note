package com.supinfo.gmy.algorithm;

/** 
* @Description: 机器人的运动范围
* @author: gaomingyang
* @date: 2020-04-08
*/
public class Question14 {
	/*地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
	
	例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子*/

	// https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github

	/*	思路:
		1 是否走过都要初始化一个二位数组记录是否走过,int或者boolean都可以
		2然后开始走
		3
		 	3.1   是否走判断标志i,j不能大于行和列,不能小于0,
		 	3.2 i、j相加不能超过threshold,
		 	3.3 flag[i][j]==0,
		4赋值
		5i,j相加问题用10取模来做 
	*/
	public class Solution {

		public int movingCount(int threshold, int rows, int cols) {
			int flag[][] = new int[rows][cols]; // 记录是否已经走过
			return helper(0, 0, rows, cols, flag, threshold);
		}

		private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
			if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1)
				return 0;
			flag[i][j] = 1;
			return helper(i - 1, j, rows, cols, flag, threshold)
					+ helper(i + 1, j, rows, cols, flag, threshold)
					+ helper(i, j - 1, rows, cols, flag, threshold)
					+ helper(i, j + 1, rows, cols, flag, threshold)
					+ 1;
		}

		private int numSum(int i) {
			int sum = 0;
			do {
				sum += i % 10;
			} while ((i = i / 10) > 0);
			return sum;
		}
	}
}
