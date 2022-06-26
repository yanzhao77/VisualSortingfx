package com.spareyaya.dynamicsort.sort.impl;

import java.util.Arrays;

import com.spareyaya.dynamicsort.util.DataUtils;
import com.spareyaya.dynamicsort.util.Utils;

/**
 * Created on 2017/11.
 * 快速排序
 * @author zhaoheng.
 */
public class QuickSort extends SortAdapter {

    @Override
    public String sort(int[] unsortedArray) {
      return  sortDesc(unsortedArray);
    }

    @Override
    public String sortDesc(int[] unsortedArray) {

        if (Utils.isEmpty(unsortedArray)) {
            return "";
        }

      return  qSortDesc(unsortedArray, 0, unsortedArray.length - 1);
    }

    @Override
    public String sortInc(int[] unsortedArray) {

        if (Utils.isEmpty(unsortedArray)) {
            return "";
        }

      return qSortInc(unsortedArray, 0, unsortedArray.length - 1);
    }


    private String qSortInc(int[] arr, int l, int h) {

        if (l < h) {
            int pivot = descPartition(arr, l, h);
            qSortInc(arr, l, pivot - 1);
            qSortInc(arr, pivot + 1, h);
        }
        return  arr.length<=500?Arrays.toString(arr):"";
    }

    private int descPartition(int[] arr, int l, int h) {

        int mark = arr[l];
        int pivot = arr[l];

        while (l < h) {

            while (l < h && arr[h] >= pivot) {
                --h;
            }

            arr[l] = arr[h];
            DataUtils.add(arr);

            while (l < h && arr[l] <= pivot) {
                ++l;
            }
            arr[h] = arr[l];
            DataUtils.add(arr);
        }

        arr[l] = mark;
        return l;

    }

	/**
	 * 降序
	 * @param arr
	 * @param l
	 * @param h
	 * @return
	 */
    private String qSortDesc(int[] arr, int l, int h) {

        if (l < h) {
            int pivot = incPartition(arr, l, h);
            qSortDesc(arr, l, pivot - 1);
            qSortDesc(arr, pivot + 1, h);
        }
        return arr.length<=500?Arrays.toString(arr):"";
    }

    private int incPartition(int[] arr, int l, int h) {

        int mark = arr[l];
        int pivot = arr[l];

        while (l < h) {

            while (l < h && arr[h] <= pivot) {
                --h;
            }

            arr[l] = arr[h];
            DataUtils.add(arr);

            while (l < h && arr[l] >= pivot) {
                ++l;
            }
            arr[h] = arr[l];
            DataUtils.add(arr);
        }

        arr[l] = mark;
        return l;

    }

    /**
     * 测试的方法
     * @param args
     */
    public static void main(String[] args) {
    	QuickSort quickSort=new QuickSort();
    	
    	quickSort.sortDesc(Utils.createRandomData(50000));
    	System.out.println("完成");
	}
}
