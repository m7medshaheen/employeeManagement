package com.employeeManagement.view;

import java.io.IOException;
import java.text.ParseException;

import com.employeeManagement.dao.EmployeeDao;
import com.employeeManagement.entity.Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class UpdateDelete_Controller {

	@FXML
	private TextField emp_id1;
	@FXML
	private TextField emp_id;
	@FXML
	private TextField name;
	@FXML
	private TextField type_id;
	@FXML
	private TextField graduation_date;
	@FXML
	private TextField birth_date;
	@FXML
	private TextField recruitment_date;
	@FXML
	private TextField recruitment_decision_number;
	@FXML
	private TextField job_stability_date;
	@FXML
	private TextField job_stability_decision_number;
	@FXML
	private TextField job_group_id;
	@FXML
	private TextField career_id;
	@FXML
	private TextField address;
	@FXML
	private TextField notes;

	public void getEmployeeById(ActionEvent e) throws IOException, ParseException {
		
		String sid = emp_id.getText();
		int id = Integer.parseInt(sid);

		Employee emp = EmployeeDao.getEmployeeById(id);
		
		emp_id1.setText(String.valueOf(emp.getEmp_id()));
		
		name.setText(emp.getName());
		type_id.setText(String.valueOf(emp.getType_id()));
		graduation_date.setText(emp.getGraduation_date());
		birth_date.setText(emp.getBirth_date());
		recruitment_date.setText(emp.getRecruitment_date());
		recruitment_decision_number.setText(String.valueOf(emp.getRecruitment_decision_number()));
		job_stability_date.setText(emp.getJob_stability_date());
		job_stability_decision_number.setText(String.valueOf(emp.getJob_stability_decision_number()));
		job_group_id.setText(String.valueOf(emp.getJob_group_id()));
		career_id.setText(String.valueOf(emp.getCareer_id()));
		address.setText(emp.getAddress());
		notes.setText(emp.getNotes());

	}
	
	public void updateEmployee(ActionEvent e)throws IOException,ParseException{
		String sid = emp_id.getText();
		int id = Integer.parseInt(sid);
		
		//int EmpID = Integer.parseInt(emp_id1.getText());
		
		String employeeName = name.getText();
		int EmployeeType = Integer.parseInt(type_id.getText());
		String graduationDate = graduation_date.getText();
		String birthDate = birth_date.getText();
		String recruitmentDate = recruitment_date.getText();
		int recruitmentDecisionNumber = Integer.parseInt(recruitment_decision_number.getText());
		String jobStabilityDate = job_stability_date.getText();
		int jobStabilityDecisionNumber = Integer.parseInt(job_stability_decision_number.getText());
		int jobGroupId = Integer.parseInt(job_group_id.getText());
		int careerId = Integer.parseInt(career_id.getText());
		String employeeAddress = address.getText();
		String employeeNotes = notes.getText();
		
		
		Employee emp = new Employee();
		emp.setEmp_id(id);
		emp.setName(employeeName);
		emp.setType_id(EmployeeType);
		emp.setGraduation_date(graduationDate);
		emp.setBirth_date(birthDate);
		emp.setRecruitment_date(recruitmentDate);
		emp.setRecruitment_decision_number(recruitmentDecisionNumber);
		emp.setJob_stability_date(jobStabilityDate);
		emp.setJob_stability_decision_number(jobStabilityDecisionNumber);
		emp.setJob_group_id(jobGroupId);
		emp.setCareer_id(careerId);
		emp.setAddress(employeeAddress);
		emp.setNotes(employeeNotes);
		
		
		

		int status = EmployeeDao.update(emp);
		
		if(status > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data updated");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record updated successfully!");
			
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data updated");
			alert.setHeaderText("Error Dialog");
			alert.setContentText("Sorry! unable to update record");
			
			alert.showAndWait();	
		}
		
	}

	public void deleteEmployee(ActionEvent e)throws IOException,ParseException{
		String sid = emp_id.getText();
		int id = Integer.parseInt(sid);	

		int status = EmployeeDao.delete(id)	;
		
		if(status > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Deleted");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record deleted successfully!");
			
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data Deleted");
			alert.setHeaderText("Error Dialog");
			alert.setContentText("Sorry! unable to delete record");
			
			alert.showAndWait();	
		}
		
	}
}
