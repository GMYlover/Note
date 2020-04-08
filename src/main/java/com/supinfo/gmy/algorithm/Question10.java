package com.supinfo.gmy.algorithm;

/** 
* @Description: 跳台阶
* @author: gaomingyang
* @date: 2020-04-08
*/
public class Question10 {
	/*一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。*/
	/** 
	* @Description: 都是兔子问题
	* @author: gaomingyang
	* @date: 2020-04-08
	*/
	public class Solution {
		public int JumpFloor(int target) {
			if (target <= 0)
				return 0;
			if (target == 1 || target == 2) {
				return target;
			}
			return JumpFloor(target - 1) + JumpFloor(target - 2);

		}
	}
}
