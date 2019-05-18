package com.employeeManagement.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employeeManagement.dao.AdminsDao;
import com.employeeManagement.dbconn.DBConnection;
import com.employeeManagement.entity.Admins;
import com.mysql.jdbc.Connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminController {

	@FXML
	private Label dbConLb;
	@FXML
	private TextField user_name;
	@FXML
	private TextField password;
	@FXML
	private Label check;
	
	private AdminsDao adminsDao;
	
	public AdminController() {
		adminsDao=new AdminsDao();
	}
	
	public void statusDB(ActionEvent e) {

		try {
			Connection con = (Connection) DBConnection.getDB().getConnection();
			if (con != null) {
				dbConLb.setText("'Connected'");
				System.out.println("con====>"+con);

			} else {
				dbConLb.setText("'Notddddddddddddd'");
				System.out.println("else:::con====>"+con);
			}
		} catch (Exception e1) {
			dbConLb.setText("'Exception'");
		}
	}

	public void checkUserPass(ActionEvent e) throws IOException,SQLException{
		
		
        List<Admins> list = adminsDao.getAdmins();
        Map<String,String> map = new HashMap<String, String>();
        for(Admins admin : list) {
        	map.put(admin.getUser_name(), admin.getPassword());
        }
        if(map.containsKey(user_name.getText())) {
        	String value = map.get(user_name.getText());
        	if(value.equals(password.getText())) {
        		check.setText("'Success'");
        		
        		Stage primaryStage = new Stage();
        		//DBConnection.getDB().getConnection();
        		
				
					Parent root = FXMLLoader.load(getClass().getResource("ControlPanel.fxml"));
					Scene scene = new Scene(root,750,500);
					//scene.getStylesheets().add(getClass().getResource("/com/employeeManagement/application.css").toExternalForm());
	        		primaryStage.setScene(scene);
	    			primaryStage.show();
				      		
        		
        	}else {
        		check.setText("Error USerName or Password Try Again");
        	}
        }else{
        	check.setText("Error USerName or Password Try Again");
        }
	}

	}


