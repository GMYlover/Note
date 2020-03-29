package com.supinfo.gmy.algorithm;

/** 
* @Description: 二维数组中的查找
* @author: gaomingyang
* @date: 2020-03-28
*/
public class Question2 {
	/*给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
	Consider the following matrix:
		[
		  [1,   4,  7, 11, 15],
		  [2,   5,  8, 12, 19],
		  [3,   6,  9, 16, 22],
		  [10, 13, 14, 17, 24],
		  [18, 21, 23, 26, 30]
		]
	Given target = 5, return true.
	Given target = 20, return false.*/

	public static void main(String[] args) {
		int[][] matrix =
				{ { 1, 4, 7, 11, 15 },
						{ 2, 5, 8, 12, 19 },
						{ 3, 6, 9, 16, 22 },
						{ 10, 13, 14, 17, 24 },
						{ 18, 21, 23, 26, 30 } };
		System.out.println(solution(matrix, 24));
	}

	/**
	* @Description: 考察如何对二位矩阵的掌握程度
	* 步骤:
	* 1while循环控制遍历所有行
	* 2定位到右上角如果小于则row不变col--
	* 3如果大于col不变row++
	* 4如果等于则return true
	* 知识点:
	* 1声明二位矩阵
	* 2遍历二维矩阵
	* 3while和for的使用
	* @param matrix
	* @param target
	* @return 
	*/
	public static boolean solution(int[][] matrix, int target) {
		if (null == matrix || 0 == matrix.length) {
			return false;
		}
		// 获取矩阵长宽方法
		int startRow = 0;
		int row = matrix.length;
		int col = matrix[0].length - 1;
		// 一个while就可控制遍历矩阵
		while (startRow < row) {
			if (matrix[startRow][col] == target)
				return true;
			else if (matrix[startRow][col] > target)
				col--;
			else
				startRow++;

		}
		return false;
	}
}
