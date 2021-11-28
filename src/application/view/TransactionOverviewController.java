package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import application.MainApp;
import application.model.Transaction;

public class TransactionOverviewController {
    @FXML
    private TableView<Transaction> transactionTable;
    @FXML
    private TableColumn<Transaction, String> DateColumn;
    @FXML
    private TableColumn<Transaction, String> NameColumn;
    @FXML
    private TableColumn<Transaction, String> CategoryColumn;
    @FXML
    private TableColumn<Transaction, String> IncomeOrExpenseColumn;
    @FXML
    private TableColumn<Transaction, String> BalanceColumn;
    @FXML
    private TableColumn<Transaction, String> AmountColumn;
    
    @FXML
    private Label DateLabel;
    @FXML
    private Label NameLabel;
    @FXML
    private Label CategoryLabel;
    @FXML
    private Label IncomeOrExpenseLabel;
    @FXML
    private Label BalanceLabel;
    @FXML
    private Label AmountLabel;

    private MainApp mainApp;

    public TransactionOverviewController() {
    }

    @FXML
    private void initialize() {
    	DateColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        CategoryColumn.setCellValueFactory(cellData -> cellData.getValue().CategoryProperty());
        IncomeOrExpenseColumn.setCellValueFactory(cellData -> cellData.getValue().IncomeOrExpenseProperty());
        BalanceColumn.setCellValueFactory(cellData -> cellData.getValue().BalanceProperty());
        AmountColumn.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
        
        showTableDetail(null);
        
        transactionTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showTableDetail(newValue));
    }
    
    private void showTableDetail(Transaction transaction) {
    	if(transaction != null) {
    		DateLabel.setText(transaction.getDate());
    		NameLabel.setText(transaction.getName());
    		CategoryLabel.setText(transaction.getCategory());
    		IncomeOrExpenseLabel.setText(transaction.getIncomeOrExpense());
    		BalanceLabel.setText(transaction.getBalance());
    		AmountLabel.setText(transaction.getAmount());
    	} else {
    		DateLabel.setText("");
    		NameLabel.setText("");
    		CategoryLabel.setText("");
    		IncomeOrExpenseLabel.setText("");
    		BalanceLabel.setText("");
    		AmountLabel.setText("");
    	}
    }
    
    @FXML
    private void handleDeleteTransaction() {
    	int selectedIndex = transactionTable.getSelectionModel().getSelectedIndex();
    	if(selectedIndex >= 0) {
    		transactionTable.getItems().remove(selectedIndex);
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
    	}
    }
    
    @FXML
    private void handleNewTransaction() {
        Transaction tempTransaction = new Transaction();
        boolean okClicked = mainApp.showTableEditDialog(tempTransaction);
        if (okClicked) {
            mainApp.getTransactionData().add(tempTransaction);
        }
    }
    
    @FXML
    private void handleEditTransaction() {
        Transaction selectedTransaction = transactionTable.getSelectionModel().getSelectedItem();
        if (selectedTransaction != null) {
            boolean okClicked = mainApp.showTableEditDialog(selectedTransaction);
            if (okClicked) {
                showTableDetail(selectedTransaction);
            }

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        transactionTable.setItems(mainApp.getTransactionData());
    }
    
    @FXML
    private void handleToken2() {
    	mainApp.showTokenInquiry();
    }
}