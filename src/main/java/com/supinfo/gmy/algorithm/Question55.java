package com.supinfo.gmy.algorithm;

/** 
* @Description: 数字在排序数组中出现的次数
* 统计一个数字在排序数组中出现的次数。
* 方法一
最简单的方法就是遍历整个数组。没什么好说的，很low.
* 方法二
* 
* @author: gaomingyang
* @date: 2020-12-24
*/
public class Question55 {
	/**
	 * 方法一
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int times = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == k) {
				++times;
			}
		}

		return times;
	}

	/*方法二数组是有序的，我们可以利用二分查找。直观的一个思路就是通过二分查找获得一个k在数组中的下标，
	 * 然后顺序的在k的前面和后面寻找和k相等的数。*/
	/**
	 * 方法二
	 */
	public int GetNumberOfK_2(int[] array, int k) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int low = 0, high = array.length - 1, mid = 0, times = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (k < array[mid]) {
				high = mid - 1;
			} else if (k > array[mid]) {
				low = mid + 1;
			} else {
				times = 1;
				break;
			}
		}

		for (low = mid - 1; (low >= 0) && (array[low] == k); low--) {
			times += 1;
		}
		for (low = mid + 1; (low < array.length) && (array[low] == k); low++) {
			times += 1;
		}

		return times;
	}

	/*方法三
	通过二分查找获得数组中第一个k的下标和最后一个k的下标，然后下标相减就是出现的次数。
	思路是通过二分找到一个k，先判断这个数字是不是第一个k，如果中间数字的前面一个数字不是k，那么此时中间数字刚好就是第一个k，如果中间数字的前面一个数字也是k，那么第一个k肯定在数组的前半段，继续二分，这是递归的过程。
	寻找第一个k下标的方法(递归)：*/

	private int FetFirstK(int[] elem, int k, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;
		if (elem[mid] > k) {
			return FetFirstK(elem, k, start, mid - 1);
		} else if (elem[mid] < k) {
			return FetFirstK(elem, k, mid + 1, end);
		} else if (mid - 1 >= 0 && elem[mid - 1] == k) {
			return FetFirstK(elem, k, start, mid - 1);
		} else {
			return mid;
		}
	}

	/**
	* @Description: 非递归
	*/ 
	private int FetLastK(int[] elem, int k, int start, int end) {
		int mid = (start + end) / 2;
		while (start <= end) {
			if (elem[mid] > k) {
				end = mid - 1;
			} else if (elem[mid] < k) {
				start = mid + 1;
			} else if (mid + 1 < elem.length && elem[mid + 1] == k) {
				start = mid + 1;
			} else {
				return mid;
			}

			mid = (start + end) / 2;
		}

		return -1;
	}

	public int GetNumberOfK_3(int[] array, int k) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int firstK = FetFirstK(array, k, 0, array.length - 1);
		int lastK = FetLastK(array, k, 0, array.length - 1);
		if (firstK != -1 && lastK != -1) {
			return lastK - firstK + 1;
		}
		return 0;

	}
}
