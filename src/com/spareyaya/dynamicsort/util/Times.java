package com.spareyaya.dynamicsort.util;

import java.util.Formatter;

/**
 * 
 * @author 赵恒
 *
 */
public class Times {

	/**
	 * 把纳秒转换成毫秒
	 * 
	 * @return
	 */
	@SuppressWarnings("resource")
	public static double getTimes(double time) {
		//把纳秒转换成毫秒
        double hmTime=(time)/1000000.00;
        return Double.valueOf(new Formatter().format("%.4f", hmTime).toString());
	}
	

}
