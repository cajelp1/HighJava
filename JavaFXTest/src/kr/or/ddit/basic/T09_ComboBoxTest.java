package kr.or.ddit.basic;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T09_ComboBoxTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		HBox hbox = new HBox();
		TextArea txtarea = new TextArea();
		
		ComboBox<String> combo = new ComboBox<>();
		combo.getItems().addAll("한강","금강","낙동강","대천강");
		combo.setValue("한강"); //처음에 보이는 부분의 데이터 세팅
		
		//combo.setOnAction(e -> {txtarea.setText(combo.getValue());});
		
		combo.valueProperty().addListener(new ChangeListener<String>() {
			
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				txtarea.setText(newValue);
			}
			
		});
		
		//combo.valueProperty().addListener(e->{txtarea.setText(newValue);}); 람다식을 어떠케 만들지???
		
		ObservableList<String> fruitList = FXCollections.observableArrayList(
					"사과", "배", "복숭아", "포도", "감"
				);
		
		//객체 생성 및 데이터 초기화를 동시에..
		ComboBox<String> combo2 = new ComboBox<>(fruitList);
		
		//데이터 초기화 후에 추가하기
		combo2.getItems().addAll("대추","호두");
		combo2.setValue("포도");
		
		Button btn = new Button("확인");
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(combo.getValue() != null && combo2.getValue() != null) {
					txtarea.setText(combo.getValue() + "지역에는" 
							+ combo2.getValue() + "가 유명합니다");
				}
			}
		});
		
		hbox.setSpacing(10);
		hbox.setPadding(new Insets(10));
		hbox.getChildren().addAll(combo, combo2, btn);
		
		root.setTop(hbox);
		root.setCenter(txtarea);
		
		Scene scene = new Scene(root, 500, 400);
		primaryStage.setTitle("ComboBox 예제");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
