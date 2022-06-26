package com.spareyaya.dynamicsort;


import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class FxWebs extends Application {
  @Override
  public void start(final Stage stage) {
    stage.setWidth(1800);//总窗口大小
    stage.setHeight(1000);
    Scene scene = new Scene(new Group(),1800,900);//次窗口大小


    //网页显示的窗口
    ScrollPane scrollPane = this.createContent(stage);

    scene.setRoot(scrollPane);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);

  }

  /**
   * 创建应用界面
   * @return
   */
public ScrollPane createContent(Stage stage) {
	
	 ScrollPane scrollPane = new ScrollPane();
	 scrollPane.setTranslateY(30);
	 scrollPane.setMinSize(1800, 1000);// 网页窗口外窗口的大小（宽、高）尽量设置宽点避免遮挡住网页窗口
	 
	  WebView browser = new WebView();
	     WebEngine webEngine = browser.getEngine();
	     
	     //设置网页页面大小
	     browser.setMinSize(1500, 1000);// 网页窗口的大小（宽、高）
	     browser.setTranslateX(100);//设置左边距
	     browser.setTranslateY(20);//设置上边距
	     
	     //获取项目路径
	     File directory = new File("");// 参数为空
	     String courseFile="";
	 	try {
	 		courseFile = directory.getCanonicalPath();
	 	} catch (IOException e) {
	 	
	 		e.printStackTrace();
	 	}
	 	
	 	String url = courseFile.replace("\\", "/");
	     //html文件所在位置
	     webEngine.load("file:///"+url+"/sortHtml/pages/sort001.html");
	     scrollPane.setContent(browser);
	return scrollPane;
}
}
