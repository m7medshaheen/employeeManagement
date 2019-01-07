package com.employeeManagement.controller;

import java.util.List;

import com.employeeManagement.dao.EmployeeDao;
import com.employeeManagement.dao.LookupDao;
import com.employeeManagement.entity.Employee;
import com.employeeManagement.entity.Lookup;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class EmployeeController {

	@FXML
	private VBox mainContainer;
	@FXML
	private TextArea employeeTextAreaId;
	@FXML
	private TextArea employeeTextAreaId2;
	
	private EmployeeDao employeeDao;
	private LookupDao lookupDao;

	public EmployeeController() {
		employeeDao = new EmployeeDao();
		lookupDao = new LookupDao();
	}

	@FXML
	public void getAllEmployee() {

		String employeeNames="";
		List<Employee> employees=employeeDao.getAllEmployees();
		for(Employee employee:employees) {
			employeeNames+=employee.getName();
		}
		employeeTextAreaId.setText(employeeNames);

	}
	@FXML
	public void getAlllookup() {

		String lookupNames="";
		List<Lookup> lookupNames1=lookupDao.getLookup("qualification");
		for(Lookup lookup:lookupNames1) {
			lookupNames+=lookup.getName();
		}
		employeeTextAreaId2.setText(lookupNames);

	}
}
