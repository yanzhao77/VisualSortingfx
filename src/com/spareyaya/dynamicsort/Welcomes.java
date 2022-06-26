package com.spareyaya.dynamicsort;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *欢迎界面
 * Created on 2018
 *
 * @author 赵恒
 */
public class Welcomes extends Application {

    /*
     * 创建欢迎界面（文字）
     */
	public Parent createContent() {
    	 Group group = new Group();
    
    	 Text t = new Text();
         t.setX(420.0);//距离左边位置
         t.setY(260.0);//距离顶部位置
         t.setCache(true);
         t.setText("Java可视化排序演示");
         t.setFill(Color.web("#00B2EE"));//字体颜色
         t.setFont(Font.font(null, FontWeight.BOLD, 100));//字体大小
         
         Reflection r = new Reflection();
         r.setFraction(0.9);//倒影大小
         t.setEffect(r);

         group.getChildren().add(t); 
        return group;
    }

    /**
     * 主方法
     * @param args
     */
public static void main(String[] args) {
    launch(args);
}
	@Override
	public void start(Stage stage) throws Exception {
		
		//欢迎界面背景图片
		 Scene scene = new Scene(new AnchorPane(), 1700, 900); //窗口宽度和高度
		// scene.getStylesheets().add(Welcomes.class.getResource("css/welcomes.css").toExternalForm());

		 final Parent parent = createContent();
	    	parent.setVisible(true);
	    ((AnchorPane) scene.getRoot()).getChildren().addAll(parent);
		 
		stage.setFullScreen(false);//是否默认全屏 true是默认全屏
    	stage.setResizable(true);//窗口是否可拖动大小
    	stage.setTitle("几种排序算法的比较");
    	 stage.setScene(scene);
         stage.show();
	}

   

}
