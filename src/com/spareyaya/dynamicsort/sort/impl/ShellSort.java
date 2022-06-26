package com.spareyaya.dynamicsort.sort.impl;

import java.util.Arrays;

import com.spareyaya.dynamicsort.util.DataUtils;
import com.spareyaya.dynamicsort.util.Utils;

/**
 * Created on 2017/11.
 * 希尔排序
 * @author zhaoheng.
 */
public class ShellSort extends SortAdapter {
    @Override
    public String sort(int[] unsortedArray) {
       return sortDesc(unsortedArray);
    }

    @Override
    public String sortDesc(int[] data) {
        if (Utils.isEmpty(data)) {
            return "";
        }
        DataUtils.add(data);
        int j = 0;  
        int temp = 0;  
        for (int increment = data.length / 2; increment > 0; increment /= 2) {  
            for (int i = increment; i < data.length; i++) {  
                temp = data[i];  
                for (j = i; j >= increment; j -= increment) {
                	//降序
                    if(temp > data[j - increment]){  
                        data[j] = data[j - increment];  
                    }else{  
                        break;  
                    }  
                }   
                data[j] = temp; 
                DataUtils.add(data);
            }  
        } 
        return data.length<=500?Arrays.toString(data):"";
    }

    @Override
    public String sortInc(int[] data) {
        if (Utils.isEmpty(data)) {
            return "";
        }
        DataUtils.add(data);
        int j = 0;  
        int temp = 0;  
        for (int increment = data.length / 2; increment > 0; increment /= 2) {  
            for (int i = increment; i < data.length; i++) {  
                temp = data[i];  
                for (j = i; j >= increment; j -= increment) {
                	//升序
                    if(temp < data[j - increment]){  
                        data[j] = data[j - increment];  
                    }else{  
                        break;  
                    }  
                }   
                data[j] = temp; 
                DataUtils.add(data);
            }  
        } 
        return data.length<=500?Arrays.toString(data):"";
    }
}
