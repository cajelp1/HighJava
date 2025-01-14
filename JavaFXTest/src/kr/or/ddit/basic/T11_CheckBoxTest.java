package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class T11_CheckBoxTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle rect = new Rectangle(90, 30); //사각형 그리기
		rect.setArcHeight(10); //둥근 사각형을 만들기 위한 꼭지점
		rect.setArcWidth(10);
		rect.setFill(Color.rgb(41, 41, 41)); //사각형 내부 색칠하기
		
		String[] names = new String[] {"Security", "Project", "Chart"};
		Image[] images = new Image[names.length];
		ImageView[] icons = new ImageView[names.length];
		
		CheckBox[] chkbox = new CheckBox[names.length];
		
		for(int i = 0; i<names.length; i++) {
			//출력할 이미지 읽어오기
			final Image img = images[i] = new Image(
					getClass().getResourceAsStream("images/"+ names[i] + ".png"));
			
			//이미지를 출력하는 객체 생성
			final ImageView icon = icons[i] = new ImageView();
			final CheckBox cb = chkbox[i] = new CheckBox(names[i]);
			
			//체크박스를 클릭해서 값이 변경되었을 때 이벤트 처리
			cb.selectedProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					
					//ImageView의 setImage() 메서드는 보여줄 이미지를 세팅해줌
					if(newValue == true) {
						icon.setImage(img);
					}else {
						icon.setImage(null); //ImageView에서 이미지 삭제
					}
				}
			});
		} //for 문 완료
		
		Button btnok = new Button("확인");
		
		btnok.setOnAction(e->{
			//체크박스의 체크여부를 확인하는 방법
			if(chkbox[1].isSelected()) {
				showInfo(chkbox[1].getText() + "체크");
			}else {
				showInfo(chkbox[1].getText() + "체크 해제");
			}
			
			chkbox[0].setSelected(!chkbox[1].isSelected());
		});
		
		VBox vbox = new VBox(5); //spacing역할
		vbox.getChildren().addAll(chkbox);
		vbox.getChildren().add(btnok);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(icons);
		hbox.setPadding(new Insets(0,0,0,5));
		
		//stackpane은 컨트롤러들을 쌓아놓는 방식으로 배치하는 컨테이너
		StackPane stack = new StackPane();
		stack.getChildren().addAll(rect, hbox);
		StackPane.setAlignment(rect, Pos.TOP_CENTER);
		
		HBox root = new HBox();
		root.setSpacing(40);
		root.setPadding(new Insets(20,10,10,20));
		root.getChildren().addAll(vbox, stack);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("checkbox 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void showInfo(String msg) {
		Alert alertInfo = new Alert(AlertType.INFORMATION);
		alertInfo.setTitle("Information");
		alertInfo.setContentText(msg);
		alertInfo.showAndWait();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
