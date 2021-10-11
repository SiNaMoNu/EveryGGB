package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane mainLayoutAnchorPane;
	
	private ObservableList<TableViewModel> transactionData = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("에브리가계부");
		
		initRootLayout();
		
		showTransactionOverview();
	}
	
	public void initRootLayout() {
		try {
			// FXML layout loader	fxml 파일에서 상위 레이아웃을 가져온다.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MainView.fxml"));
			mainLayoutAnchorPane = (AnchorPane) loader.load();
			
			// 상위 레이아웃을 포함하는 scene을 보여준다.
			Scene scene = new Scene(mainLayoutAnchorPane);
			primaryStage.setResizable(false);	// 윈도우 창 크기 변경 불가
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showTransactionOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MainView.fxml"));
			AnchorPane TransactionOverview = (AnchorPane) loader.load();
			
			TableController controller = loader.getController();
			controller.setMain(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public Main() {
		transactionData.add(new TableViewModel("1", "2", "3", "4", "5", "6"));
	}
	
	public ObservableList<TableViewModel> getTransactionData() {
		return transactionData;
	}
	
	public static void main(String[] args) {
		launch(args);	// Main 객체 생성 및 메인 윈도우 생성
	}
}
