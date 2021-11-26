package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.model.TokenInput;

public class TokenDialogController {
	@FXML
	private TextField ACCESS_TOKEN_Field;
	@FXML
	private TextField USER_SQUENCE_NUMBER_Field;
	
	String Test = new String();
	
	private Stage dialogStage;
	private boolean okClicked = false;
	
	@FXML
	private void initialize() {

	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void handleOK() {
		if(isInputValid()) {
			TokenInput.ACCESS_TOKEN = ACCESS_TOKEN_Field.getText();
			TokenInput.USER_SQUENCE_NUMBER = USER_SQUENCE_NUMBER_Field.getText();
			
			okClicked = true;
			dialogStage.close();
		}
	}
	
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	private boolean isInputValid() {
		String errorMessage = "";
		
		if(ACCESS_TOKEN_Field.getText() == null || ACCESS_TOKEN_Field.getText().length() == 0) {
			errorMessage += "ACCESS_TOKEN가 입력되지 않았습니다.\n";
		}
		
		if(USER_SQUENCE_NUMBER_Field.getText() == null || USER_SQUENCE_NUMBER_Field.getText().length() == 0) {
			errorMessage += "USER_SQUENCE_NUMBER가 입력되지 않았습니다.\n";
		}
		
		if(errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			
			alert.showAndWait();
			
			return false;
		}
	}
}
