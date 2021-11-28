package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import application.model.Transaction;
import application.view.LoginController;
import application.view.TableEditDialogController;
import application.view.TransactionOverviewController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private ObservableList<Transaction> transactionData = FXCollections.observableArrayList();

    public MainApp() {
    	transactionData.add(new Transaction("20211012", "육장장이", "식비", "지출", "1000000", "-14500"));
    	transactionData.add(new Transaction("20211013", "쿠팡", "생활", "지출", "800000", "-200000"));
    	transactionData.add(new Transaction("20211122", "플라잉로드", "교통", "지출", "798520", "-1480"));
    	transactionData.add(new Transaction("20211123", "신가네", "식비", "지출", "791220", "-7300"));
    	transactionData.add(new Transaction("20211124", "휴대폰 요금", "고정지출", "지출", "727420", "-63800"));
    	transactionData.add(new Transaction("20211124", "용돈", "", "수입", "1027420", "+300000"));
    	transactionData.add(new Transaction("20211125", "김래하 닭갈비", "식비", "지출", "1013420", "-13000"));
    	transactionData.add(new Transaction("20211126", "CU", "식비", "지출", "1011520", "-1900"));
    	
    }

    public ObservableList<Transaction> getTransactionData() {
        return transactionData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("가계부");

        initRootLayout();

        showPersonOverview();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TransactionOverview.fxml"));
            AnchorPane transactionOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(transactionOverview);

            TransactionOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean showTableEditDialog(Transaction transaction) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("view/TableDialog.fxml"));
    		AnchorPane page = (AnchorPane) loader.load();
    		
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("Edit");
    		dialogStage.initModality(Modality.WINDOW_MODAL);
    		dialogStage.initOwner(primaryStage);
    		Scene scene = new Scene(page);
    		dialogStage.setScene(scene);
    		
    		TableEditDialogController controller = loader.getController();
    		controller.setDialogStage(dialogStage);
    		controller.setTable(transaction);
    		
    		dialogStage.showAndWait();
    		
    		return controller.isOkClicked();
    	} catch(IOException e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
    public boolean showTokenInquiry() {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("view/LoginOverview.fxml"));
    		AnchorPane page = (AnchorPane) loader.load();
    		
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("Login");
    		dialogStage.initModality(Modality.WINDOW_MODAL);
    		dialogStage.initOwner(primaryStage);
    		Scene scene = new Scene(page);
    		dialogStage.setScene(scene);
    		
    		LoginController controller = loader.getController();
    		controller.setDialogStage(dialogStage);
    		controller.setTokenInformation();
    		
    		dialogStage.showAndWait();
    		
    		return controller.isOkClicked();
    	} catch(IOException e) {
    		e.printStackTrace();
    		return false;
    	}
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}