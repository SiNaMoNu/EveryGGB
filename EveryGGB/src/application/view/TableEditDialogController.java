package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.model.TokenInput;
import application.model.Transaction;

public class TableEditDialogController {
	@FXML
	private TextField DateField;
	@FXML
	private TextField NameField;
	@FXML
	private TextField CategoryField;
	@FXML
	private TextField IncomeOrExpenseField;
	@FXML
	private TextField BalanceField;
	@FXML
	private TextField AmountField;
	
	private Stage dialogStage;
	private Transaction transaction;
	private boolean okClicked = false;
	
	@FXML
	private void initialize() {

	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setTable(Transaction transaction) {
		this.transaction = transaction;
		
		DateField.setText(transaction.getDate());
		NameField.setText(transaction.getName());
		CategoryField.setText(transaction.getCategory());
		IncomeOrExpenseField.setText(transaction.getIncomeOrExpense());
		BalanceField.setText(transaction.getBalance());
		AmountField.setText(transaction.getAmount());
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void handleOK() {
		if(isInputValid()) {
			transaction.setDate(DateField.getText());
			transaction.setName(NameField.getText());
			transaction.setCategory(CategoryField.getText());
			transaction.setIncomeOrExpense(IncomeOrExpenseField.getText());
			transaction.setBalance(BalanceField.getText());
			transaction.setAmount(AmountField.getText());
			
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
		
		if(DateField.getText() == null || DateField.getText().length() == 0) {
			errorMessage += "DATE 이(가) 입력되지 않았습니다.\n";
		}
		if(NameField.getText() == null || NameField.getText().length() == 0) {
			errorMessage += "NAME 이(가) 입력되지 않았습니다.\n";
		}
		if(CategoryField.getText() == null || CategoryField.getText().length() == 0) {
			errorMessage += "CATEGORY 이(가) 입력되지 않았습니다.\n";
		}
		if(IncomeOrExpenseField.getText() == null || IncomeOrExpenseField.getText().length() == 0) {
			errorMessage += "INCOMEOREXPENSE 이(가) 입력되지 않았습니다.\n";
		}
		if(BalanceField.getText() == null || BalanceField.getText().length() == 0) {
			errorMessage += "BALANCE 이(가) 입력되지 않았습니다.\n";
		}
		if(AmountField.getText() == null || AmountField.getText().length() == 0) {
			errorMessage += "AMOUNT 이(가) 입력되지 않았습니다.\n";
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
