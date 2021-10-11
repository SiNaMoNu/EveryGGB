package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableController implements Initializable {
	@FXML
	private TableView<TableViewModel> transactionTable;
	@FXML
	private TableColumn<TableViewModel, String> DateColumn;
	@FXML
	private TableColumn<TableViewModel, String> NameColumn;
	@FXML
	private TableColumn<TableViewModel, String> CategoryColumn;
	@FXML
	private TableColumn<TableViewModel, String> IncomeOrExpenseColumn;
	@FXML
	private TableColumn<TableViewModel, String> BalanceColumn;
	@FXML
	private TableColumn<TableViewModel, String>AmountColumn;
	@FXML
	private Button RefreshButton;
	
	// 메인 에플리케이션 참조
	private Main main;
	
	// 컨트롤러 클래스를 초기화
	// fxml 파일 로드 후 자동으로 호출
	@FXML
    private void initialize() {
    	// 테이블 초기화
        DateColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        CategoryColumn.setCellValueFactory(cellData -> cellData.getValue().CategoryProperty());
        IncomeOrExpenseColumn.setCellValueFactory(cellData -> cellData.getValue().IncomeOrExpenseProperty());
        BalanceColumn.setCellValueFactory(cellData -> cellData.getValue().BalanceProperty());
        AmountColumn.setCellValueFactory(cellData -> cellData.getValue().AmountProperty());
    }
	
	// 참조를 위해 다시 메인 에플리케이션 호출
	public void setMain(Main Main) {
		this.main = main;
		
		// 테이블에 Observable 리스트 데이터 추가
		transactionTable.setItems(main.getTransactionData());
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		RefreshButton.setOnMouseClicked(event -> {System.out.println("test");});
	}

}
