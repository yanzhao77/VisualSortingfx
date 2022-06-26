package com.spareyaya.dynamicsort;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javafx.animation.Timeline;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

import com.spareyaya.dynamicsort.sort.RunAll;
import com.spareyaya.dynamicsort.util.Times;

/**
 * 图表类
 * @author 赵恒
 *
 */
public class BarCharts {

	private XYChart.Series<String, Number> series;
    @SuppressWarnings("unused")
	private XYChart.Data<String, Number>[] seriesData;
    private Timeline timeline;
    private double width=500.0;//图表的宽度
    private double height= 500.0;//图表的高度

	/**
	 * 图表
	 * @param n 排序元素的个数
	 * @param top 距离顶部的高度
	 * @param left 距离左边的宽度
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BarChart<String, Number> barChar(int n,double top,double left) {

		series = new XYChart.Series<>();
	    CategoryAxis xAxis = new CategoryAxis(); //X轴
	    NumberAxis yAxis = new NumberAxis(); //Y轴
	    BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.getStylesheets().add(SortAlls.class.getResource("DataBar.css").toExternalForm());
        barChart.setBarGap(0.8);//设置同一类型bar之间的间距 
        barChart.setVerticalGridLinesVisible(false); //不显示垂直网格
        barChart.setLegendVisible(false); //不显示颜色标示 //显示颜色标示
        xAxis.setLabel("排序算法");
        yAxis.setLabel("排序时间/毫秒");
        barChart.setTitle("排序数："+n);
        yAxis.setUpperBound(400.0);
        
        //设置图形高度
        xAxis.setMinHeight(height);
        barChart.setMinHeight(height);
        //设置图像宽度
        xAxis.setMinWidth(width);
        barChart.setMinWidth(width);
        
        AnchorPane.setTopAnchor(barChart, top);
        AnchorPane.setLeftAnchor(barChart, left);
        /**********************排序开始*********************************/
        RunAll rAll=new RunAll();
        Map<String, Double> map=rAll.getRunTime(n);
		List<Entry<String, Double>> list=rAll.sortByValue(map);
		seriesData =new XYChart.Data[list.size()];
		for (Entry<String, Double> entry : list) {
			//给条形图设置值
			series.getData().add(new XYChart.Data(entry.getKey(), Times.getTimes(entry.getValue())));
		}
		 /**********************排序结束*********************************/
        if (null == this.timeline) {
            timeline = new Timeline();
        }
        //添加数据
        barChart.getData().add(series);
        return barChart;
    }
	
	
	}
	


