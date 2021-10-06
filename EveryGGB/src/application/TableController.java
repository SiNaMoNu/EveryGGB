package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TableController implements Initializable {
	@FXML
	private Button RefreshButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		RefreshButton.setOnMouseClicked(event -> {System.out.println("test");});
	}

}
