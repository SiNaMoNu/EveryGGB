package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.model.TokenInput;

public class LoginController {
	@FXML
	private TextField LoginField;	
	
	private Stage dialogStage;
	private boolean okClicked = false;
	
	@FXML
	private void initialize() {
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setTokenInformation() {
		
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void handleOk() {
		TokenInput.LOGIN_TOKEN = LoginField.getText();
		
		okClicked = true;
		dialogStage.close();
	}
}
