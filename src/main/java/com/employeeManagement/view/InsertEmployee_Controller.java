package com.employeeManagement.view;

import java.io.IOException;
import java.time.LocalDate;

import com.employeeManagement.dao.EmployeeDao;
import com.employeeManagement.entity.Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class InsertEmployee_Controller {
	
	@FXML
	private TextField emp_id;
	@FXML
	private TextField name;
	@FXML
	private TextField type_id;
	@FXML
	private DatePicker graduation_date;
	@FXML
	private DatePicker birth_date;
	@FXML
	private DatePicker recruitment_date;
	@FXML
	private TextField recruitment_decision_number;
	@FXML
	private DatePicker job_stability_date;
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
	
	
	public void insertData(ActionEvent e)throws IOException{
		
		LocalDate graduationDate = graduation_date.getValue();
		LocalDate birthDate = birth_date.getValue();
		LocalDate recruitmentDate = recruitment_date.getValue();
		LocalDate jobStabilityDate = job_stability_date.getValue();
		
		String empId = emp_id.getText();
		String typeId = type_id.getText();
		String employeeName = name.getText();
		String recruitmentDecisionNumber = recruitment_decision_number.getText();
		String jobStabilityDecisionNumber = job_stability_decision_number.getText();
		String jobGroupId = job_group_id.getText();
		String careerId = career_id.getText();
		String employeeAddress = address.getText();
		String employeeNotes = notes.getText();
		
		int type_Id = Integer.parseInt(typeId);
		int recruitment_Decision_Number = Integer.parseInt(recruitmentDecisionNumber);
		int job_Stability_Decision_Number = Integer.parseInt(jobStabilityDecisionNumber);
		int job_Group_Id = Integer.parseInt(jobGroupId);
		int career_Id = Integer.parseInt(careerId);
		int emp_Id = Integer.parseInt(empId);
		
		
		String graduation_Date = graduationDate.toString();
		String birth_Date = birthDate.toString();
		String recruitment_Date = recruitmentDate.toString();
		String jobStability_Date = jobStabilityDate.toString();
		
		Employee emp = new Employee();
		emp.setEmp_id(emp_Id);
		emp.setName(employeeName);
		emp.setType_id(type_Id);
		emp.setGraduation_date(graduation_Date);
		emp.setBirth_date(birth_Date);
		emp.setRecruitment_date(recruitment_Date);
		emp.setRecruitment_decision_number(recruitment_Decision_Number);
		emp.setJob_stability_date(jobStability_Date);
		emp.setJob_stability_decision_number(job_Stability_Decision_Number);
		emp.setJob_group_id(job_Group_Id);
		emp.setCareer_id(career_Id);
		emp.setAddress(employeeAddress);
		emp.setNotes(employeeNotes);
		
		int status = EmployeeDao.save(emp);
		
		if(status > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Insert");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record updated successfully!");
			
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data Insert");
			alert.setHeaderText("Error Dialog");
			alert.setContentText("Sorry! unable to update record");
			
			alert.showAndWait();	
		}
		
		
	}

}
