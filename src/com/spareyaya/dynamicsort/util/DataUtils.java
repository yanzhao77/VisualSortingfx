package com.spareyaya.dynamicsort.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2017/12/4.
 *
 * @author 赵恒.
 */
public class DataUtils {

	/**
	 * 排序次数
	 */
    public static List<int[]> sData = new ArrayList<>();

    /**
     * 排序过程中调用
     * 排序过程 用于显示数据变化
     * @param data
     */
    public static void add(int[] data) {
    	if (data.length < 200) {
    		int[] elem = Arrays.copyOf(data, data.length);
            sData.add(elem); 
		}
        
    }

    public static void clear() {
        sData.clear();
    }
}
