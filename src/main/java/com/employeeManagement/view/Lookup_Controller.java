package com.employeeManagement.view;

import java.util.List;

import com.employeeManagement.dao.LookupDao;
import com.employeeManagement.dao.TrainingDao;
import com.employeeManagement.entity.Lookup;
import com.employeeManagement.entity.Training;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class Lookup_Controller {

	@FXML
	private VBox mainContainer;
	
	@FXML
	private ComboBox combo;
	@FXML
	private TextArea employeeTextAreaId;
	@FXML
	private TextArea employeeTextAreaId2;

//	private EmployeeDao employeeDao;
	private LookupDao lookupDao;;

	public Lookup_Controller() {
		// employeeDao = new EmployeeDao();
		lookupDao = new LookupDao();
		combo = new ComboBox();
		combo.setValue("sssssssssss");

	}

	@FXML
	public void getAllEmployee() {

		// String employeeNames="";
		// List<Employee> employees=employeeDao.getAllEmployees();
		// for(Employee employee:employees) {
		// employeeNames+=employee.getName();
		// }
//		employeeTextAreaId.setText(employeeNames);

	}
	
	@FXML
	public void getAllTraining() {

		 String trainingNames="";
		 List<Training> trainings=TrainingDao.getAllTraining();
		 for(Training training:trainings) {
			 trainingNames+=training.getTraining_name();
		 }
		employeeTextAreaId.setText(trainingNames);

	}

	@FXML
	public void getAlllookup() {

		String lookupNames = "";
		List<Lookup> lookupNames1 = lookupDao.getLookup("emp_type");
		for (Lookup lookup : lookupNames1) {
			lookupNames = lookupNames + "\n" + lookup.getName();
		}
		employeeTextAreaId2.setText(lookupNames);

	}

	
	@FXML
	public void getEmpType() {

		// String type="";

		// for(Emp_type empType:empTypes) {
		// type=type+"\n"+empType.getName();
		// }
		// employeeTextAreaId2.setText(type);

	}
}
