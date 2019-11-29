package com.employeeManagement.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.employeeManagement.dbconn.DBConnection;
import com.employeeManagement.entity.Employee;
import com.employeeManagement.util.SqlQuery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeView_Controller implements Initializable {
	@FXML
	private TableView<Employee> table;
	@FXML
	private TableColumn<Employee, Integer> emp_no;
	@FXML
	private TableColumn<Employee, String> name;
	@FXML
	private TableColumn<Employee, Integer> type_id;
	@FXML
	private TableColumn<Employee, String> graduation_date;
	@FXML
	private TableColumn<Employee, String> birth_date;
	@FXML
	private TableColumn<Employee, String> recruitment_date;
	@FXML
	private TableColumn<Employee, Integer> recruitment_decision_number;
	@FXML
	private TableColumn<Employee, String> job_stability_date;
	@FXML
	private TableColumn<Employee, Integer> job_stability_decision_number;
	@FXML
	private TableColumn<Employee, Integer> job_group_id;
	@FXML
	private TableColumn<Employee, Integer> career_id;
	@FXML
	private TableColumn<Employee, String> address;
	@FXML
	private TableColumn<Employee, String> notes;

	public ObservableList<Employee> data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		try {
			
			Connection con = DBConnection.getDB().getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.GET_ALL_EMPLOYEES_QUERY);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				data.add(new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
						rs.getString(12), rs.getString(13)));
			}
			//con.close();

		} catch (SQLException e) {
			System.out.println("mabroooooooooooook");
			
		}
		

		
		
		emp_no.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("emp_no"));
		name.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
		type_id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("type_id"));
		graduation_date.setCellValueFactory(new PropertyValueFactory<Employee, String>("graduation_date"));
		birth_date.setCellValueFactory(new PropertyValueFactory<Employee, String>("birth_date"));
		recruitment_date.setCellValueFactory(new PropertyValueFactory<Employee, String>("recruitment_date"));
		recruitment_decision_number.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("recruitment_decision_number"));
		job_stability_date.setCellValueFactory(new PropertyValueFactory<Employee, String>("job_stability_date"));
		job_stability_decision_number.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("job_stability_decision_number"));
		job_group_id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("job_group_id"));
		career_id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("career_id"));
		address.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
		notes.setCellValueFactory(new PropertyValueFactory<Employee, String>("notes"));
		
		table.setItems(data);
		


}}
