package com.spareyaya.dynamicsort.sort.impl;

import java.util.Arrays;

import com.spareyaya.dynamicsort.util.DataUtils;
import com.spareyaya.dynamicsort.util.Utils;

/**
 * Created on 2017/11.
 *	选择排序
 * @author zhaoheng
 */
public class SelectionSort extends SortAdapter {

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

        int mark, tmp, i, j;
        for (i = 0; i < unsortedArray.length; i++) {

            mark = i;

            for (j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[mark] < unsortedArray[j]) {
                    mark = j;
                }
            }

            if (mark != i) {
                tmp = unsortedArray[i];
                unsortedArray[i] = unsortedArray[mark];
                unsortedArray[mark] = tmp;
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

        DataUtils.add(unsortedArray);

        int mark, tmp, i, j;
        for (i = 0; i < unsortedArray.length; i++) {

            mark = i;

            for (j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[mark] > unsortedArray[j]) {
                    mark = j;
                }
            }

            if (mark != i) {
                tmp = unsortedArray[i];
                unsortedArray[i] = unsortedArray[mark];
                unsortedArray[mark] = tmp;
                DataUtils.add(unsortedArray);
            }

        }
        return unsortedArray.length<=500?Arrays.toString(unsortedArray):"";
    }
}
