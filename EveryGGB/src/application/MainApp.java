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
import application.view.TokenDialogController;
import application.view.TokenInquiryController;
import application.view.TransactionOverviewController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private ObservableList<Transaction> transactionData = FXCollections.observableArrayList();

    public MainApp() {
    	transactionData.add(new Transaction("20211012", "육장장이", "식비", "지출", "1000000", "-14500"));
    	transactionData.add(new Transaction("20211013", "쿠팡", "생활", "지출", "800000", "-200000"));
    }

    public ObservableList<Transaction> getTransactionData() {
        return transactionData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("에브리 가계부");

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
    
    public boolean showTokenDialog() {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("view/TokenDialog.fxml"));
    		AnchorPane page = (AnchorPane) loader.load();
    		
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("Token");
    		dialogStage.initModality(Modality.WINDOW_MODAL);
    		dialogStage.initOwner(primaryStage);
    		Scene scene = new Scene(page);
    		dialogStage.setScene(scene);
    		
    		TokenDialogController controller = loader.getController();
    		controller.setDialogStage(dialogStage);
    		
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
    		loader.setLocation(MainApp.class.getResource("view/TokenInquiry.fxml"));
    		AnchorPane page = (AnchorPane) loader.load();
    		
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("Token Information");
    		dialogStage.initModality(Modality.WINDOW_MODAL);
    		dialogStage.initOwner(primaryStage);
    		Scene scene = new Scene(page);
    		dialogStage.setScene(scene);
    		
    		TokenInquiryController controller = loader.getController();
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