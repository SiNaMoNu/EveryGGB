package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// FXML layout loader
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MainView.fxml"));
			
			// widow root
			AnchorPane mainLayoutAnchorPane = (AnchorPane) loader.load();
			Scene scene = new Scene(mainLayoutAnchorPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setTitle("���긮�����");
			primaryStage.setResizable(false);	// ������ â ũ�� ���� �Ұ�
			primaryStage.setScene(scene);
			primaryStage.show();	// ������ �����ֱ�
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);	// Main ��ü ���� �� ���� ������ ����
	}
}
