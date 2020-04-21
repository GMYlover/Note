package com.supinfo.gmy.algorithm;

/** 
* @Description: 剪绳子
* @author: gaomingyang
* @date: 2020-04-08
*/
public class Question15 {
	/*给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
	 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
	 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。*/
	// https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=13&tqId=33257&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
	/**
	* @Description: 读题，关键点是m、n>1也就是说一定要切分，并且n要大于1长度
	* 1 先分析1，2，3分别返回
	* 2再分析其他场景并返回
	* @param num
	* @return 
	*/
	public int solution(int num) {
		if (num == 1) {
			return 0;
		}
		if (num == 2) {
			return 1;
		}
		if (num == 3) {
			return 2;
		}
		int[] value = new int[num + 1];

		value[1] = 0;
		value[2] = 1;
		value[3] = 2;
		int res = 0;
		for (int i = 4; i <= num; i++) {
			for (int j = 1; j <= i / 2; j++) {
				res = Math.max(res, value[j] * value[i - j]);
			}
			value[i] = res;
		}
		return value[num];

	}

}
