package com.spareyaya.dynamicsort.sort;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.spareyaya.dynamicsort.util.Times;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 /**
  * 自定义排序
  * 比较所有排序算法所花费的时间
  * @author zhaoheng
  *
  */
@SuppressWarnings("restriction")
public class BarChartSample extends Application {
	private XYChart.Data<String, Number>[] seriesData;
	private int n=100;//需要排序的数据长度
	
    public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@SuppressWarnings("all")
	@Override 
    public void start(Stage stage) {
        stage.setTitle("排序时间比较");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
        new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("时间比较");
       
       // xAxis.setLabel("算法");       
        yAxis.setLabel("时间/毫秒");
        bc.setBarGap(10);
        bc.setCategoryGap(20);
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("排序用时");       
        
        /**********************排序开始*********************************/
        RunAll rAll=new RunAll();
        Map<String, Double> map=rAll.getRunTime(this.n);
		List<Entry<String, Double>> list=rAll.sortByValue(map);
		seriesData =new XYChart.Data[list.size()];
		for (Entry<String, Double> entry : list) {
			//给条形图设置值
			series1.getData().add(new XYChart.Data(entry.getKey()+" "+Times.getTimes(entry.getValue())+" ms", Times.getTimes(entry.getValue())));
		}

		//窗口大小
        Scene scene  = new Scene(bc,1100,900);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();

    }

}
