package com.spareyaya.dynamicsort.sort;

import java.util.Map;
import java.util.TreeMap;

import com.spareyaya.dynamicsort.SortMain;
import com.spareyaya.dynamicsort.sort.impl.BubbleSort;
import com.spareyaya.dynamicsort.sort.impl.HeapSort;
import com.spareyaya.dynamicsort.sort.impl.InsertionSort;
import com.spareyaya.dynamicsort.sort.impl.MergeSort;
import com.spareyaya.dynamicsort.sort.impl.QuickSort;
import com.spareyaya.dynamicsort.sort.impl.QuikSort2;
import com.spareyaya.dynamicsort.sort.impl.SelectionSort;
import com.spareyaya.dynamicsort.sort.impl.ShellSort;
import com.spareyaya.dynamicsort.util.Utils;

/**
 * @author 赵恒
 * Created on 2017/12/4.
 */
public class AllSort {
	
	public static int a=0;
	
	/**
	 * 多组数据的比较
	 * 对所有排序算法进行调用
	 * @param n 排序元素个数
	 * @return
	 */
	public  Map<String, Double> sortAlls(int n) {

		Map<String, Double> map = new TreeMap<String, Double>();
		
		// 排序的原数据
		int[] data =Utils.createRandomData(n);
        Sort sort1 = new BubbleSort();
		Sort sort2 = new InsertionSort();
		Sort sort3 = new QuickSort();
		Sort sort4 = new HeapSort();
		Sort sort5 = new ShellSort();
		Sort sort6 = new MergeSort();
		Sort sort7 = new SelectionSort();
		//非递归 用于大数组排序
		QuikSort2 qks=new QuikSort2();

		double startTime1 = System.nanoTime(); // 获取开始时间 纳秒
		sort1.sortDesc(data);
		double endTime1 = System.nanoTime(); // 获取结束时间
		map.put(SName.mp, endTime1-startTime1);

		double startTime2 = System.nanoTime(); // 获取开始时间
		sort2.sortDesc(data);
		double endTime2 = System.nanoTime(); // 获取结束时间
		map.put(SName.cr, endTime2-startTime2);

		
		
		double startTime4 = System.nanoTime(); // 获取开始时间
		sort4.sortDesc(data);
		double endTime4 = System.nanoTime(); // 获取结束时间
		map.put(SName.d, endTime4-startTime4);

		double startTime5 = System.nanoTime(); // 获取开始时间
		sort5.sortDesc(data);
		double endTime5 = System.nanoTime(); // 获取结束时间
		map.put(SName.xer, endTime5-startTime5);

		double startTime6 = System.nanoTime(); // 获取开始时间
		sort6.sortDesc(data);
		double endTime6 = System.nanoTime(); // 获取结束时间
		map.put(SName.gb, endTime6-startTime6);
		
		double startTime7 = System.nanoTime(); // 获取开始时间
		sort7.sortDesc(data);
		double endTime7 = System.nanoTime(); // 获取结束时间
		map.put(SName.xz, endTime7-startTime7);
		
		double startTime3 = System.nanoTime(); // 获取开始时间
		//sort3.sortDesc(data);
		
		qks.quicksort(data);
		
		double endTime3 = System.nanoTime(); // 获取结束时间
		map.put(SName.ks, endTime3-startTime3 );
		return map;
	}
	
	/**
	 * 对所有排序算法进行调用
	 */
	public  Map<String, Double> sortAll() {

		Map<String, Double> map = new TreeMap<String, Double>();
		
		// 排序的原数据
		//int[] data = Utils.createRadomData();
		int[] data =SortMain.data2;
        Sort sort1 = new BubbleSort();
		Sort sort2 = new InsertionSort();
		Sort sort3 = new QuickSort();
		Sort sort4 = new HeapSort();
		Sort sort5 = new ShellSort();
		Sort sort6 = new MergeSort();
		Sort sort7 = new SelectionSort();

		double startTime1 = System.nanoTime(); // 获取开始时间 纳秒
		sort1.sortDesc(data);
		double endTime1 = System.nanoTime(); // 获取结束时间
		map.put(SName.mp, endTime1-startTime1);

		double startTime2 = System.nanoTime(); // 获取开始时间
		sort2.sortDesc(data);
		double endTime2 = System.nanoTime(); // 获取结束时间
		map.put(SName.cr, endTime2-startTime2);

		double startTime3 = System.nanoTime(); // 获取开始时间
		sort3.sortDesc(data);
		double endTime3 = System.nanoTime(); // 获取结束时间
		map.put(SName.ks, endTime3-startTime3 );
		
		double startTime4 = System.nanoTime(); // 获取开始时间
		sort4.sortDesc(data);
		double endTime4 = System.nanoTime(); // 获取结束时间
		map.put(SName.d, endTime4-startTime4);

		double startTime5 = System.nanoTime(); // 获取开始时间
		sort5.sortDesc(data);
		double endTime5 = System.nanoTime(); // 获取结束时间
		map.put(SName.xer, endTime5-startTime5);

		double startTime6 = System.nanoTime(); // 获取开始时间
		sort6.sortDesc(data);
		double endTime6 = System.nanoTime(); // 获取结束时间
		map.put(SName.gb, endTime6-startTime6);
		
		double startTime7 = System.nanoTime(); // 获取开始时间
		sort7.sortDesc(data);
		double endTime7 = System.nanoTime(); // 获取结束时间
		map.put(SName.xz, endTime7-startTime7);
		
		return map;
	}
}

// 排序方法名称
class SName {

	static final String mp = "冒泡排序";

	static final String cr = "插入排序";
	
	static final String ks = "快速排序";
	
	static final String d = "堆排序";

	static final String xer = "希尔排序";

	static final String gb = "归并排序";

	static final String xz = "选择排序";
}
