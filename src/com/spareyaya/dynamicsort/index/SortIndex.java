package com.spareyaya.dynamicsort.index;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import com.spareyaya.dynamicsort.FxWebs;
import com.spareyaya.dynamicsort.SortAlls;
import com.spareyaya.dynamicsort.SortMain;
import com.spareyaya.dynamicsort.Welcomes;
 
/**
 * 项目启动类
 * 排序窗口操作主页
 * @author zhaoheng
 *
 */
public class SortIndex extends Application {
	    /**
	     * 主方法
	     * @param args
	     */
    public static void main(String[] args) {
        launch(args);
    }
  
	 /**
	  * 启动方法   
	  */
    @Override
    public void start(Stage stage) {
        stage.setWidth(1800);//总窗口大小
        stage.setHeight(1000);
    	stage.setFullScreen(false);//是否默认全屏 true是默认全屏
    	stage.setResizable(true);//窗口是否可拖动大小
    	stage.setTitle("几种排序算法的比较");
    	
    	//首页 欢迎界面
    	Welcomes welcomes = new Welcomes();
    	final Parent welParent = welcomes.createContent();
    	welParent.setVisible(true);
    	
    	//实例化首页面对象
    	SortMain sortMain = new SortMain();
    	final Parent parent = sortMain.createContent();
    	parent.setVisible(false);
    	
    	//实例化自定义排序对象
    	SortAlls sAlls = new SortAlls();
    	final Parent parent2 =sAlls.createContent();
    	parent2.setVisible(false);
    	
    	//排序算法HTML页面加载类
    	FxWebs fxWebs = new FxWebs();
    	//final Parent HtmlParent =sAlls.createContent();// fxWebs.createContent();
    	
    	
    	 ScrollPane HtmlParent = fxWebs.createContent(stage);
    	 HtmlParent.setVisible(false);
    	
    	
        Scene scene = new Scene(new AnchorPane(), 1700, 950); //窗口宽度和高度
       //菜单组件
        MenuBar menuBar = new MenuBar();
        menuBar.setPrefWidth(2000.0);
        
        //菜单1
        Menu menuFile = new Menu("可视化排序");
        
        //菜单1.1
        MenuItem mItem = new MenuItem("排序首页");
        mItem.setOnAction((ActionEvent t) -> {
        	HtmlParent.setVisible(false);
        	welParent.setVisible(false);
        	parent2.setVisible(false);
        	parent.setVisible(true);
        });  
        //菜单1.2
        MenuItem mItem2 = new MenuItem("自定义排序");
        mItem2.setOnAction((ActionEvent t) -> {
        	HtmlParent.setVisible(false);
        	welParent.setVisible(false);
        	parent.setVisible(false);
        	parent2.setVisible(true);
        }); 
        
        //菜单2.0t        
        Menu menuEdit = new Menu("我的文档");
        MenuItem mItemF = new MenuItem("十大排序算法简介");
        mItemF.setOnAction((ActionEvent t) -> {
        	welParent.setVisible(false);
        	parent2.setVisible(false);
        	parent.setVisible(false);
        	HtmlParent.setVisible(true);
        });
        
        //菜单3
        Menu menuSys = new Menu("系统");
        //菜单3.1
        MenuItem mItemsys = new MenuItem("退出");
        mItemsys.setOnAction((ActionEvent t) -> {
        	 System.exit(0);
        }); 
 
        menuFile.getItems().addAll(mItem,mItem2);
        menuEdit.getItems().addAll(mItemF);
        menuSys.getItems().addAll(mItemsys);
        
        menuBar.getMenus().addAll(menuFile, menuEdit, menuSys);
       
        
        //把展示页面组件添加到首页，菜单（menuBar）组件必须放在最后
        ((AnchorPane) scene.getRoot()).getChildren().addAll(welParent,parent,parent2,HtmlParent,menuBar);
//        scene.getStylesheets().add(Welcomes.class.getResource("css/welcomes.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }
}