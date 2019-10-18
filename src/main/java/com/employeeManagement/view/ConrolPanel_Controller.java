package com.employeeManagement.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConrolPanel_Controller {

	public void viewEmployee(ActionEvent e) throws IOException {

		Stage primaryStage = new Stage();
		// DBConnection.getDB().getConnection();

		Parent root = FXMLLoader.load(getClass().getResource("EmployeeView.fxml"));
		Scene scene = new Scene(root, 1034, 510);
		// scene.getStylesheets().add(getClass().getResource("/com/employeeManagement/application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void insertEmployee(ActionEvent e) throws IOException {

		Stage primaryStage = new Stage();
		// DBConnection.getDB().getConnection();

		Parent root = FXMLLoader.load(getClass().getResource("InsertEmployee.fxml"));
		Scene scene = new Scene(root, 1300, 650);
		// scene.getStylesheets().add(getClass().getResource("/com/employeeManagement/application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void updateDeleteEmployee(ActionEvent e) throws IOException {

		Stage primaryStage = new Stage();
		// DBConnection.getDB().getConnection();

		Parent root = FXMLLoader.load(getClass().getResource("UpdateDelete.fxml"));
		Scene scene = new Scene(root, 1034, 550);
		// scene.getStylesheets().add(getClass().getResource("/com/employeeManagement/application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void viewLookup(ActionEvent e) throws IOException {

		Stage primaryStage = new Stage();
		// DBConnection.getDB().getConnection();

		Parent root = FXMLLoader.load(getClass().getResource("Lookup.fxml"));
		Scene scene = new Scene(root, 1034, 510);
		// scene.getStylesheets().add(getClass().getResource("/com/employeeManagement/application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}


}
