module TestFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.fxml;
	exports application;
	
	opens application.view to javafx.fxml;
	exports application.view;
}
