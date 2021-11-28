package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import application.model.TokenInput;

public class TokenInquiryController {
	@FXML
	private Label ACCESS_TOKEN_Information;
	@FXML
	private Label USER_SQUENCE_NUMBER_Information;
	
	// Label TokenFieldInformation = new Label();
	
	private Stage dialogStage;
	private boolean okClicked = false;
	
	@FXML
	private void initialize() {
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setTokenInformation() {
		ACCESS_TOKEN_Information.setText(TokenInput.ACCESS_TOKEN);
		USER_SQUENCE_NUMBER_Information.setText(TokenInput.USER_SQUENCE_NUMBER);
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void handleOk() {
		okClicked = true;
		dialogStage.close();
	}
}
