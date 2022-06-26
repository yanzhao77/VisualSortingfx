package com.spareyaya.dynamicsort;

import java.util.Optional;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;//

import com.spareyaya.dynamicsort.sort.BarChartSample;

/**
 * 自定义排序类
 * @author zhh
 *
 */
public class SortAlls extends Application {
	private BarChart<String, Number> barChart1;
	private BarChart<String, Number> barChart2;
	private BarChart<String, Number> barChart3;

	public static void main(String[] args) {
		Application.launch(args);

	}

	// 创建应用界面
	public Parent createContent() {
		// 使用AnchorPane作为根布局
		AnchorPane anchorPane = new AnchorPane();
		// 设置内边距为20
		anchorPane.setPadding(new Insets(20.0, 20.0, 20.0, 20.0));

		BarCharts bCharts1 = new BarCharts();
		barChart1 = bCharts1.barChar(10, 50.0, 0.0);
		barChart2 = bCharts1.barChar(1000, 50.0, 550.0);
		barChart3 = bCharts1.barChar(10000, 50.0, 1150.0);

		// 水平分割线
		Separator hSep = new Separator(Orientation.HORIZONTAL);
		hSep.setPrefWidth(1700.0);
		AnchorPane.setLeftAnchor(hSep, 0.0);
		AnchorPane.setTopAnchor(hSep, 600.0);

		// 输入框
		TextField filed = new TextField();
		filed.setPromptText("请输入排序数据大小");
		filed.setPrefWidth(180.0);
		filed.setPrefHeight(38.0);
		AnchorPane.setRightAnchor(filed, 600.0);
		AnchorPane.setTopAnchor(filed, 660.0);
		// 自定义排序
		Button zdy = new Button("自定义排序");
		zdy.setPrefWidth(150.0);
		zdy.setPrefHeight(38.0);
		AnchorPane.setRightAnchor(zdy, 800.0);
		AnchorPane.setTopAnchor(zdy, 660.0);
		zdy.setOnAction(event -> {

			BarChartSample barSample = new BarChartSample();
			
			//文本框的值只能为正整数
			if (!this.isNumeric(filed.getText()) || "".equals(filed.getText())) {
				filed.clear();
				Alert aler = new Alert(null, "只能输入正整数！",
						new ButtonType("取消", ButtonBar.ButtonData.NO), new ButtonType(
								"确定", ButtonBar.ButtonData.YES));
				aler.setTitle("警告");
				Optional<ButtonType> _buttonType = aler.showAndWait();// 根据点击结果返回
				if (_buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)) {
					return;
				} else {
					return ;
				}
				

			}else {
				// 获取输入框的值
				barSample.setN(Integer.valueOf(filed.getText()));
			}
	

			Stage stage1 = new Stage();
			try {

				Stage stage = new Stage();
				barSample.start(stage);
				stage1.hide();
			} catch (Exception e) {

				e.printStackTrace();
			}
		});

		// 添加所有组件到根布局中barChart1,barChart2,
		anchorPane.getChildren().addAll(barChart1, barChart2, barChart3, hSep,
				zdy, filed);
		return anchorPane;
	}

	/**
	 * 判断字符串是否都是正整数
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	@Override
	public void start(Stage primaryStage) {

		// 设置窗口宽度和高度
		Scene root = new Scene(createContent(), 1700, 800);
		primaryStage.setFullScreen(false);
		primaryStage.setResizable(false);
		primaryStage.setTitle("几种排序算法的比较");
		primaryStage.setScene(root);
		primaryStage.show();

	}
}