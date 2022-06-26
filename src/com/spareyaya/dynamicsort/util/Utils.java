package com.spareyaya.dynamicsort.util;

import java.util.Arrays;
import java.util.Random;

/**
 * Created on 2017/11
 *
 * @author zhaoheng.
 */
public class Utils {

    private static final int ARRAY_SIZE = 100;

    public static boolean isEmpty(int[] unsortedArray) {
        if (unsortedArray == null || unsortedArray.length == 0) {
            return true;
        }

        return false;
    }

    /**
     * 产生100个元素的随机数组（[0, 300)）
     * @return
     */
    public static int[] createRadomData() {
        int[] arr = new int[ARRAY_SIZE];

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = random.nextInt(300) + 1;
        }

        return arr;
    }
    
    /**
     * 产生n个元素的随机数组（[0, 1000)）
     * @param n 随机数的个数
     * @return
     */
    public static int[] createRandomData(int n) {
        int[] arr = new int[n];

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1000) + 1;
        }

        return arr;
    }

    /**
     * 打印数据
     * */
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 简单的日志方法
     * */
    public static void log(String tag, String msg) {
        System.out.println(tag + " --- " + msg);
    }
    
    //测试的主方法
    public static void main(String[] args) {
    	
    	System.out.println(Arrays.toString(Utils.createRandomData(1000)));
		 
	}
}
