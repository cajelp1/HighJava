package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
	top, bottom, left, right, center 셀에 컨트롤러를 배치하는 컨테이너
	각 셀에는 하나의 컨트롤 또는 컨테이너만 배치
	
	top, bottom, left, right 에 배치하지 않으면 center에 배치된 컨트롤이 사방으로 자동 확장
	
	
 */

public class T05_BorderPaneTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(300, 200);
		
		ToolBar toolbar = new ToolBar(
			new Button("첫번째버튼"),
			new Button("두번째버튼")
		);
		
		TextArea txtarea = new TextArea();
		
		root.setTop(toolbar); //top 영역에 toolbar추가하기
		root.setCenter(txtarea); //center영역에 textarea 추가
		
		BorderPane bottom = new BorderPane();
		bottom.setPadding(new Insets(10));
		
		TextField txtField = new TextField();
		Button bun1 = new Button("확인");
		bottom.setCenter(txtField);
		bottom.setRight(bun1);
		
		root.setBottom(bottom);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("BorderPane 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
