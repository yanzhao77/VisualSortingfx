 package com.spareyaya.dynamicsort.sort;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.spareyaya.dynamicsort.util.Times;

import javafx.scene.chart.XYChart;
/**
 * 运行所有排序算法
 * @author zhaoheng
 *
 */
public class RunAll {
	
	/**
	 * 获取排序时间
	 * @return
	 */
	public Map<String, Double> getRunTime() {

		AllSort allSort =new AllSort();
		return allSort.sortAll();
	}
	
	/**
	 * 获取排序时间
	 * @param n 排序元素个数
	 * @return
	 */
	public Map<String, Double> getRunTime(int n) {

		AllSort allSort =new AllSort();
		return allSort.sortAlls(n);
	}
	
	/**
	 * map排序工具类
	 * 根据map的value进行排序
	 * @return
	 */
	public List<Entry<String, Double>> sortByValue(Map<String, Double> map) {
		List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(map.entrySet());  
        Collections.sort(list,new Comparator<Entry<String,Double>>() {
            //降序排序  
            public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {  
                return o2.getValue().compareTo(o1.getValue());  
            }  
        });  
        return list;
	}
	
	/**
	 * 用于测试的方法
	 * @param args
	 */
	public static void main(String[] args) {
//		RunAll rAll = new RunAll();
//		List<Entry<String, Double>> list=rAll.sortByValue();
//		
//		for (Entry<String, Double> entry : list) {	
//			System.out.println(entry.getKey()+"   "+Times.getTimes(entry.getValue())+" x10微秒");
//		}

	}
	


}
