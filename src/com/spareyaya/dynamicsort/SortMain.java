package com.spareyaya.dynamicsort;

import com.spareyaya.dynamicsort.sort.Sort;
import com.spareyaya.dynamicsort.sort.impl.*;
import com.spareyaya.dynamicsort.util.DataUtils;
import com.spareyaya.dynamicsort.util.Times;
import com.spareyaya.dynamicsort.util.Utils;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Arrays;

/**
 * 排序窗口操作主页
 * @author zhh
 *
 */
public class SortMain extends Application {
	
	    private final int DURATION = 10;
	    
	    private BarChart<String, Number> barChart;
	    XYChart.Series<String, Number> series;
	    private XYChart.Data<String, Number>[] seriesData;

	    ComboBox<String> comboBox;

	    int sortMethod = 0; //排序方法
	    int sortOrder = 1; //1代表降序，2代表升序
	    ToggleGroup group;


	    private int[] currentData; //排序的原数据
	    private String sortStr;//排序后的数组字符串
	    
	    //显示排序之前的数据
	    Button numBut1 = new Button("排序前：");
	    //显示排序之后的数据
	    Button numBut2 = new Button("");
	    //保持选择排序方法时的数据和比较全部时的 数组数据一致
	    public static int[] data;
	    public static int[] data2;
	    
	    private Timeline timeline;

	    private int i, j;
	    private int m, n;


	    @SuppressWarnings("all")
	    public SortMain() {
	        //可以在此处做初始化的操作
	        currentData = Utils.createRadomData();
	        //不能让两个引用指向同一组数据，否则原数组的顺序无法保留
	        data = Arrays.copyOf(currentData, currentData.length);
	        data2 = Arrays.copyOf(currentData, currentData.length);
	        
	        series = new XYChart.Series<>();
	        //x轴的数据长度
	        seriesData = new XYChart.Data[currentData.length];
	        for (int i = 0; i < seriesData.length; i++) {
	        	//x轴显示的数据 和y轴每条的显示高度
	            seriesData[i] = new XYChart.Data<>("" + (i + 1), data[i]);
	            //添加数据 显示条形图
	           series.getData().add(seriesData[i]);
	        }

	        if (null == timeline) {
	            timeline = new Timeline();
	        }

	        i = 0;
	        j = 0;
	    }

	    /**
	     * 清空数据
	     */
	    private void clearData() {

	        DataUtils.clear();
	        timeline.getKeyFrames().clear();

	    }
	    
	    /**
	     * 选择排序的方法
	     * @param sortMethod
	     * @param sortOrder
	     */
	    private String startSort(int sortMethod, int sortOrder) {
	    	double hmTimes=0;
	    	double startTime1=0; 
	    	double endTime1=0;
	        i = 0;
	        j = 0;
	        
	        Sort sort;
	        long startTime=System.nanoTime();   //获取开始时间  
	        if (sortOrder == 1) {
	            //降序
	            switch (sortMethod) {
	                case SortMethod.BUBBLE_SORT:
	                	
	                    sort = new BubbleSort();
	                    startTime1 = System.nanoTime();
	                    sortStr = sort.sortDesc(data);
	                    endTime1 = System.nanoTime();
	                    hmTimes = endTime1-startTime1;
	                    break;

	                case SortMethod.INSERTION_SORT:
	                	 
	                    sort = new InsertionSort();
	                    startTime1 = System.nanoTime();
	                    sortStr = sort.sortDesc(data);
	                    endTime1 = System.nanoTime();

	                    break;

	                case SortMethod.QUICK_SORT:
	                    sort = new QuickSort();
	                    startTime1 = System.nanoTime();
	                    sortStr = sort.sortDesc(data);
	                    endTime1 = System.nanoTime();

	                    break;

	                case SortMethod.HEAP_SORT:
	                	sort = new HeapSort();
	                	startTime1 = System.nanoTime();
	                	sortStr=sort.sortDesc(data);
	                	endTime1 = System.nanoTime();
	                    break;

	                case SortMethod.SHELL_SORT:
	                	sort = new ShellSort();
	                	startTime1 = System.nanoTime();
	                	sortStr=sort.sortDesc(data);
	                	endTime1 = System.nanoTime();
	                    break;

	                case SortMethod.MERGE_SORT:
	                	sort = new MergeSort();
	                	startTime1 = System.nanoTime();
	                	sortStr=sort.sortDesc(data);
	                	endTime1 = System.nanoTime();
	                    break;

	                case SortMethod.SELECTION_SORT:

	                    sort = new SelectionSort();
	                    startTime1 = System.nanoTime();
	                    sortStr = sort.sortDesc(data);
	                    endTime1 = System.nanoTime();

	                    break;
	                default:
	                    break;

	            }
	        } else {
	            //升序
	            switch (sortMethod) {
	                case SortMethod.BUBBLE_SORT:

	                    sort = new BubbleSort();
	                    startTime1 = System.nanoTime();
	                    sortStr = sort.sortInc(data);
	                    endTime1 = System.nanoTime();

	                    break;

	                case SortMethod.INSERTION_SORT:

	                    sort = new InsertionSort();
	                    startTime1 = System.nanoTime();
	                    sortStr = sort.sortInc(data);
	                    endTime1 = System.nanoTime();

	                    break;

	                case SortMethod.QUICK_SORT:

	                    sort = new QuickSort();
	                    startTime1 = System.nanoTime();
	                    sortStr = sort.sortInc(data);
	                    endTime1 = System.nanoTime();

	                    break;

	                case SortMethod.HEAP_SORT:
	                	sort = new HeapSort();
	                	startTime1 = System.nanoTime();
	                	sortStr=sort.sortInc(data);
	                	endTime1 = System.nanoTime();
	                    break;

	                case SortMethod.SHELL_SORT:
	                	sort = new ShellSort();
	                	startTime1 = System.nanoTime();
	                	sortStr=sort.sortInc(data);
	                	endTime1 = System.nanoTime();
	                    break;

	                case SortMethod.MERGE_SORT:
	                	sort = new MergeSort();
	                	startTime1 = System.nanoTime();
	                	sortStr=sort.sortInc(data);
	                    break;

	                case SortMethod.SELECTION_SORT:

	                    sort = new SelectionSort();
	                    startTime1 = System.nanoTime();
	                    sortStr = sort.sortInc(data);
	                    endTime1 = System.nanoTime();

	                    break;

	                default:
	                    break;

	            }
	        }
	        long endTime=System.nanoTime(); //获取结束时间 
	       // System.out.println("程序运行时间： "+(endTime-startTime)+"ns"); //程序运行时间
	        //把纳秒转换成毫秒
	       // double hmTime=(endTime-startTime)/1000000.00;
	        double hmTime=Times.getTimes(endTime-startTime);
	        return hmTime+"";
	    }

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
    	stage.setFullScreen(false);//是否默认全屏 true是默认全屏
    	stage.setResizable(true);//窗口是否可拖动大小
    	stage.setTitle("几种排序算法的比较");
    	final Parent parent =createContent();
    	parent.setVisible(false);
    
        Scene scene = new Scene(new AnchorPane(), 1400, 900); //窗口宽度和高度
        MenuBar menuBar = new MenuBar();
 
        // --- Menu File
        Menu menuFile = new Menu("可视化排序");
        MenuItem add = new MenuItem("排序首页");
        
        add.setOnAction((ActionEvent t) -> {
        	parent.setVisible(true);
        });        
 
        menuFile.getItems().addAll(add);
 
        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");
        
        // --- Menu View
        Menu menuView = new Menu("View");
        
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
        ((AnchorPane) scene.getRoot()).getChildren().addAll(menuBar,parent);
        stage.setScene(scene);
        stage.show();
    }
    
  /**
   * 创建应用界面
   * @return
   */
  	public Parent createContent() {

        //使用AnchorPane作为根布局
        AnchorPane anchorPane = new AnchorPane();
        //设置内边距为20
        anchorPane.setPadding(new Insets(40.0, 20.0, 20.0, 200.0));

        //数据图表
        CategoryAxis xAxis = new CategoryAxis(); //X轴
        NumberAxis yAxis = new NumberAxis(); //Y轴
        barChart = new BarChart<>(xAxis, yAxis);
        barChart.getStylesheets().add(SortMain.class.getResource("DataBar.css").toExternalForm());
        barChart.setBarGap(0.8);//设置同一类型bar之间的间距 
        barChart.setCategoryGap(0.01); //设置不同类型之间的间距  
        barChart.setAnimated(false); //数据变化时不播放变化动画
        barChart.setVerticalGridLinesVisible(false); //不显示垂直网格
        barChart.setLegendVisible(false); //不显示颜色标示
        xAxis.setLabel("数据量/个");
        yAxis.setLabel("数据大小");
        yAxis.setUpperBound(400.0);
        
        //设置图形高度
        xAxis.setMinHeight(600);
        barChart.setMinHeight(600);
        //设置图像宽度
        xAxis.setMinWidth(820);
        barChart.setMinWidth(820);
        
        AnchorPane.setTopAnchor(barChart, 40.0);
        AnchorPane.setLeftAnchor(barChart, 0.0);

        //添加数据
        barChart.getData().add(series);

        //水平分割线
        Separator hSep = new Separator(Orientation.HORIZONTAL);
        hSep.setPrefWidth(800.0);
        AnchorPane.setLeftAnchor(hSep, 0.0);
        AnchorPane.setTopAnchor(hSep, 900.0);

        //垂直分割线
        Separator vSep = new Separator(Orientation.VERTICAL);
        vSep.setPrefHeight(600.0);
        AnchorPane.setLeftAnchor(vSep, 900.0);
        AnchorPane.setTopAnchor(vSep, 0.0);
        
        //比较全部按钮
        Button compareAll = new Button("自定义排序");
        compareAll.setPrefWidth(140.0);
        compareAll.setPrefHeight(38.0);
        AnchorPane.setRightAnchor(compareAll, 0.0);
        AnchorPane.setTopAnchor(compareAll, 0.0);
        compareAll.setOnAction(event -> {//按钮监听事件
        	SortAlls sAlls=new SortAlls();
        	Stage  stage=new Stage();
        	try {
				sAlls.start(stage);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
        });
       

        //右侧排序算法的下拉菜单
        ObservableList<String> options = FXCollections.observableArrayList(
                "冒泡排序",
                "插入排序",
                "快速排序",
                "堆排序",
                "希尔排序",
                "归并排序",
                "选择排序");
        comboBox = new ComboBox<>(options);

        comboBox.setPrefWidth(140.0);
        AnchorPane.setTopAnchor(comboBox, 60.0);
        AnchorPane.setRightAnchor(comboBox, 0.0);
        comboBox.getSelectionModel().select(0);
        comboBox.setOnAction(event -> {
            sortMethod = comboBox.getSelectionModel().getSelectedIndex();
        });
        //右侧排列顺序单选按钮组
        group = new ToggleGroup();

        RadioButton descRb = new RadioButton("降序");
        descRb.setUserData("降序");
        descRb.setToggleGroup(group);
        descRb.setSelected(true);
        descRb.setPrefWidth(100.0);
        descRb.setPrefHeight(38.0);
        AnchorPane.setRightAnchor(descRb, 0.0);
        AnchorPane.setTopAnchor(descRb, 90.0);

        RadioButton ascRb = new RadioButton("升序");
        ascRb.setUserData("升序");
        ascRb.setToggleGroup(group);
        ascRb.setPrefWidth(100.0);
        ascRb.setPrefHeight(38.0);
        AnchorPane.setRightAnchor(ascRb, 0.0);
        AnchorPane.setTopAnchor(ascRb, 120.0);

        //当单选按钮切换时记下当前选中的按钮
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if ("降序".equals(newValue.getUserData().toString())) {
                sortOrder = 1;
            } else {
                sortOrder = 2;
            }
        });
        

        
        //显示排序之前的数据
        numBut1.setPrefWidth(1100.0);
        numBut1.setPrefHeight(38.0);
        numBut1.setText("排序前："+Arrays.toString(data));
        AnchorPane.setLeftAnchor(numBut1, 0.0);
        AnchorPane.setBottomAnchor(numBut1, 190.0);
        
       //显示排序之后的数据
        numBut2.setPrefWidth(1100.0);
        numBut2.setPrefHeight(38.0);
        AnchorPane.setLeftAnchor(numBut2, 0.0);
        AnchorPane.setBottomAnchor(numBut2, 130.0);


        //底部控制按钮
        //重置数据按钮
        Button resetBtn = new Button("重置数据");
        resetBtn.setPrefWidth(100.0);
        resetBtn.setPrefHeight(38.0);
        AnchorPane.setLeftAnchor(resetBtn, 0.0);
        AnchorPane.setBottomAnchor(resetBtn, 50.0);
        resetBtn.setOnAction(event -> {
            data = Arrays.copyOf(currentData, currentData.length);
            data2 = Arrays.copyOf(currentData, currentData.length);

            clearData();

            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(DURATION), event1 -> {


                for (XYChart.Series<String, Number> s : barChart.getData()) {
                    m = 0;
                    for (XYChart.Data<String, Number> d : s.getData()) {
                        d.setYValue(data[m]);
                        m++;
                    }
                }

            }
            ));

            timeline.setCycleCount(1);
            timeline.play();
            numBut2.setText("");
        });


        //变换数据按钮
        Button changeBtn = new Button("变换数据");
        changeBtn.setPrefWidth(100.0);
        changeBtn.setPrefHeight(38.0);
        AnchorPane.setLeftAnchor(changeBtn, 150.0);
        AnchorPane.setBottomAnchor(changeBtn, 50.0);
        changeBtn.setOnAction(event -> {
            currentData = Utils.createRadomData();
            data = Arrays.copyOf(currentData, currentData.length);

            clearData();

            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(DURATION), event1 -> {
                for (XYChart.Series<String, Number> s : barChart.getData()) {
                    n = 0;
                    for (XYChart.Data<String, Number> d : s.getData()) {
                        d.setYValue(data[n]);
                        n++;
                    }
                }

            }
            ));

            timeline.setCycleCount(1);
            timeline.play();
            numBut1.setText("排序前："+Arrays.toString(data));
        });
        //排序时间
        Button sortTime = new Button("排序时间：");
        sortTime.setPrefWidth(200.0);
        sortTime.setPrefHeight(38.0);
        AnchorPane.setLeftAnchor(sortTime, 450.0);
        AnchorPane.setBottomAnchor(sortTime, 50.0);
        
        //开始排序按钮
        Button sortBtn = new Button("开始排序");
        sortBtn.setPrefWidth(100.0);
        sortBtn.setPrefHeight(38.0);
        AnchorPane.setLeftAnchor(sortBtn, 300.0);
        AnchorPane.setBottomAnchor(sortBtn, 50.0);
        sortBtn.setOnAction(event -> {
            //开始排序之前先把原来的数据清空
            clearData();
            //得到排序时间
            String sortTimeString= startSort(sortMethod, sortOrder);
            sortTime.setText("时间："+sortTimeString+"毫秒");
            numBut2.setText("排序后："+sortStr);
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(DURATION), event1 -> {

                for (XYChart.Series<String, Number> s : barChart.getData()) {

                    for (XYChart.Data<String, Number> d : s.getData()) {
                    	
                        d.setYValue(DataUtils.sData.get(i)[j]);
                        j++;

                    }

                    j = 0;
                    i++;

                }

            }
            ));

            timeline.setCycleCount(DataUtils.sData.size());
            timeline.play();

        });
        

        //添加所有组件到根布局中
        anchorPane.getChildren().addAll(barChart, hSep, vSep,compareAll,comboBox, descRb, ascRb,numBut1,numBut2,resetBtn, changeBtn, sortBtn,sortTime);
     
        return anchorPane;
    
    } 
    //排序方法静态变量标准
    class SortMethod {

        static final int BUBBLE_SORT = 0;

        static final int INSERTION_SORT = 1;

        static final int QUICK_SORT = 2;

        static final int HEAP_SORT = 3;

        static final int SHELL_SORT = 4;

        static final int MERGE_SORT = 5;

        static final int SELECTION_SORT = 6;
    }

}