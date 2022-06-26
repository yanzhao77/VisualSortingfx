package com.spareyaya.dynamicsort.sort.impl;

import com.spareyaya.dynamicsort.sort.Sort;

/**
 * 2017/11
 *
 * @author zhaoheng.
 *
 * 适配Sort接口
 *
 * @see Sort
 */
public class SortAdapter implements Sort {

    @Override
    public String sort(int[] unsortedArray) {
      return sortDesc(unsortedArray);
    }

    @Override
    public String sortDesc(int[] unsortedArray) {
    	return "";
    }

    @Override
    public String sortInc(int[] unsortedArray) {
    	return "";
    }
}
