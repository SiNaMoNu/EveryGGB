package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Transaction;

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
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        transactionTable.setItems(mainApp.getTransactionData());
    }
}