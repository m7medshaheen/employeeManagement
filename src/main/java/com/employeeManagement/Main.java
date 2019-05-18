package com.employeeManagement;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//	//		BorderPane root = new BorderPane();
			
			
			
			//Parent parent = FXMLLoader.load(getClass().getResource("/com/employeeManagement/view/EmployeeView.fxml"));
			Parent parent = FXMLLoader.load(getClass().getResource("/com/employeeManagement/view/Main1.fxml"));
			
			Scene scene = new Scene(parent,750,500);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
