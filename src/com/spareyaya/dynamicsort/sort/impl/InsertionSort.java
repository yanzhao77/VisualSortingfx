package com.spareyaya.dynamicsort.sort.impl;

import java.util.Arrays;

import com.spareyaya.dynamicsort.util.DataUtils;
import com.spareyaya.dynamicsort.util.Utils;

/**
 * Created on 2017/12/4.
 * 插入排序
 * @author 赵恒.
 */
public class InsertionSort extends SortAdapter {

    @Override
    public String sort(int[] unsortedArray) {
    	return sortDesc(unsortedArray);
    }

    @Override
    public String sortDesc(int[] unsortedArray) {

        if (Utils.isEmpty(unsortedArray)) {
            return "";
        }

        int mark, i, j;

        for (i = 1; i < unsortedArray.length; i++) {

            if (unsortedArray[i] > unsortedArray[i - 1]) {
                mark = unsortedArray[i];

                for (j = i; j > 0 && mark > unsortedArray[j - 1]; j--) {
                    unsortedArray[j] = unsortedArray[j - 1];
                    DataUtils.add(unsortedArray);

                }

                unsortedArray[j] = mark;
                DataUtils.add(unsortedArray);

            }

        }
        return unsortedArray.length<=500?Arrays.toString(unsortedArray):"";
    }

    @Override
    public String sortInc(int[] unsortedArray) {

        if (Utils.isEmpty(unsortedArray)) {
            return "";
        }

        int mark, i, j;

        for (i = 1; i < unsortedArray.length; i++) {

            if (unsortedArray[i] < unsortedArray[i - 1]) {
                mark = unsortedArray[i];

                for (j = i; j > 0 && mark < unsortedArray[j - 1]; j--) {
                    unsortedArray[j] = unsortedArray[j - 1];
                    DataUtils.add(unsortedArray);

                }

                unsortedArray[j] = mark;
                DataUtils.add(unsortedArray);

            }

        }
        return unsortedArray.length<=500?Arrays.toString(unsortedArray):"";
    }
}
