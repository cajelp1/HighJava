package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class Combo99DanController implements Initializable{

	@FXML private ComboBox<Integer> cmbDan;
	@FXML private Button btnDan;
	@FXML private TextArea txtResult;
	//객체주입이 일어남
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<Integer> list = FXCollections.observableArrayList(
				1,2,3,4,5,6,7,8,9
			);
		cmbDan.setItems(list);
		
		/*btnDan.setOnAction(e -> {
			int dan = cmbDan.getSelectionModel().getSelectedItem();
			
			txtResult.setText(dan + "단\n\n");
			for(int i =1; i <=9; i++) {
				int r = dan * i;
				txtResult.appendText(dan + " * "+i+" = "+r+"\n");
			}
		});*/
		
	}

	@FXML public void btnDanClicked(ActionEvent event) {
		int dan = cmbDan.getSelectionModel().getSelectedItem();
		
		txtResult.setText(dan + "단\n\n");
		for(int i =1; i <=9; i++) {
			int r = dan * i;
			txtResult.appendText(dan + " * "+i+" = "+r+"\n");
		}
	}
	
}
