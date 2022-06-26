package com.spareyaya.dynamicsort.sort.impl;

import java.util.Arrays;

import com.spareyaya.dynamicsort.util.DataUtils;
import com.spareyaya.dynamicsort.util.Utils;

/**
 * Created on 2017/11.
 *堆排序
 * @author zhaoheng.
 */
public class HeapSort extends SortAdapter {

    @Override
    public String sort(int[] unsortedArray) {
    	return sortDesc(unsortedArray);
    }

    @Override
    public String sortDesc(int[] unsortedArray) {
        if (Utils.isEmpty(unsortedArray)) {
            return "";
        }
        DataUtils.add(unsortedArray);
    	/** 选择降序排序 **/
    	int in, out;
    	int max;
    	int temp;
    	for (out = 0; out < unsortedArray.length; out++) {
    	// 默认最大数的位置
    	max = out;
    	for (in = out + 1; in < unsortedArray.length; in++) {
    	if (unsortedArray[max] < unsortedArray[in]) {
    	// 获取最大数的位置
    	max = in;
    	}
    	}
    	// 当默认位置的最大数并不是实际的最大数时，和实际的最大数交换位置
    	if (out != max) {
    	temp = unsortedArray[out];
    	unsortedArray[out] = unsortedArray[max];
    	unsortedArray[max] = temp;	
        DataUtils.add(unsortedArray);
    	}
    	}
    	
        return unsortedArray.length<=500?Arrays.toString(unsortedArray):"";
    }

    @Override
    public String sortInc(int[] unsortedArray) {
    	System.out.println("升序");
        if (Utils.isEmpty(unsortedArray)) {
            return "";
        }
        DataUtils.add(unsortedArray);
    	int in, out;
		int max;
		int temp;
		for (out = unsortedArray.length - 1; out > 0; out--) {
		// 默认最大数的位置
		max = out;
		for (in = out-1; in >= 0; in--) {
		if (unsortedArray[max] < unsortedArray[in]) {
		max = in;
		}
		}
		// 当默认位置的最大数并不是实际的最大数时，和实际的最大数交换位置
		if (out != max) {
		temp = unsortedArray[out];
		unsortedArray[out] = unsortedArray[max];
		unsortedArray[max] = temp;
        DataUtils.add(unsortedArray);

		}
		}
        return unsortedArray.length<=500?Arrays.toString(unsortedArray):"";
    }

}

