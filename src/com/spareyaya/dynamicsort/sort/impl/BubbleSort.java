package com.spareyaya.dynamicsort.sort.impl;

import java.util.Arrays;

import com.spareyaya.dynamicsort.util.DataUtils;
import com.spareyaya.dynamicsort.util.Utils;

/**
 *  2017/11
 *冒泡排序
 * @author zhaoheng.
 */
public class BubbleSort extends SortAdapter {

	 @Override
    public String sort(int[] unsortedArray) {
       return sortDesc(unsortedArray);
    }

	 /**
	  * 降序
	  */
    @Override
    public String sortDesc(int[] unsortedArray) {

        if (Utils.isEmpty(unsortedArray)) {
            return "";
        }
        DataUtils.add(unsortedArray);
        int tmp;

        for (int i = 0; i < unsortedArray.length; i++) {
            for (int j = unsortedArray.length - 1; j > i; j--) {
                if (unsortedArray[j] > unsortedArray[j-1]) {
                    tmp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j-1];
                    unsortedArray[j-1] = tmp;
                    //排序过程中调用 排序过程 用于显示数据变化
                    DataUtils.add(unsortedArray);
                }

            }

        }
        return unsortedArray.length<=500?Arrays.toString(unsortedArray):"";
    }

    @Override
    public String sortInc(int[] unsortedArray) {

        boolean isSwap = false;

        if (Utils.isEmpty(unsortedArray)) {
            return "";
        }
        DataUtils.add(unsortedArray);
        int tmp;

        for (int i = 0; i < unsortedArray.length; i++) {
            for (int j = unsortedArray.length - 1; j > i; j--) {
                if (unsortedArray[j] < unsortedArray[j-1]) {
                    tmp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j-1];
                    unsortedArray[j-1] = tmp;
                    isSwap = true;
                }

                if (isSwap) {
                    DataUtils.add(unsortedArray);
                    isSwap = false;
                }

            }

        }
        return unsortedArray.length<=500?Arrays.toString(unsortedArray):"";
    }
}
