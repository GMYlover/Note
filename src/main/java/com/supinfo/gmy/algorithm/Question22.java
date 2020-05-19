package com.supinfo.gmy.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

/**
 * @Description: 调整数组顺序使奇数位于偶数前面
 * @author gmylover
 * @date 2020-05-20
 */
public class Question22 {
    public static void reOrderArray(int [] array) { 
    	int[] list=new int[array.length];
    	int num=0;
    	for (int var : array) {
			if (var%2==1) {
				list[num]=var;
				num++;
			}
		}
    	for (int var : array) {
			if (var%2==0) {
				list[num]=var;
				num++;			
				}
		}
    	array=list;
    	System.out.println(ArrayUtils.toString(array));
    }
    public static void main(String[] args) {
		int[]haha={1,2,3,4,5,6,7}; 
		reOrderArray(haha);
	}
    
}