package com.employeeManagement.view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.employeeManagement.dao.EmployeeDao;
import com.employeeManagement.dao.LookupDao;
import com.employeeManagement.entity.Employee;
import com.employeeManagement.entity.Lookup;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class InsertEmployee_Controller implements Initializable {

	@FXML
	private TextField emp_no;
	@FXML
	private TextField name;

	@FXML
	private ComboBox<Lookup> type_id;
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
	private ComboBox<Lookup> job_group_id;
	@FXML
	private ComboBox<Lookup> career_id;
	@FXML
	private TextField address;
	@FXML
	private TextField notes;

	private LookupDao lookupDao;

	public InsertEmployee_Controller() {
		// type_id=new ComboBox<Emp_type>();
		type_id = new ComboBox<Lookup>();
		job_group_id = new ComboBox<Lookup>();
		career_id = new ComboBox<Lookup>();

		lookupDao = new LookupDao();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getEmpType();
		getEmpGroupId();

	}

	public void getEmpType() {

		// ObservableList<Emp_type> empTypes=emp_typeDao.getLookup();
		ObservableList<Lookup> empTypes = lookupDao.getLookup("emp_type");

		// for(Emp_type empType:empTypes) {
		// type=type+"\n"+empType.getName();
		// }
		// employeeTextAreaId2.setText(type);
		type_id.getItems().addAll(empTypes);
		type_id.setConverter(new StringConverter<Lookup>() {

			@Override
			public String toString(Lookup object) {
				return object.getName();
			}

			@Override
			public Lookup fromString(String string) {
				// TODO Auto-generated method stub
				return type_id.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst().orElse(null);
			}

		});

	}

	public void getEmpGroupId() {

		ObservableList<Lookup> empJroupId = lookupDao.getLookup("job_group");

		job_group_id.getItems().addAll(empJroupId);

		job_group_id.setConverter(new StringConverter<Lookup>() {

			@Override
			public String toString(Lookup object) {

				return object.getName();
			}

			@Override
			public Lookup fromString(String string) {
				return job_group_id.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst()
						.orElse(null);
			};

		});
	}

	public void getEmpCareerId(ActionEvent on) {

		
		career_id.getItems().clear();
		ObservableList<Lookup> empCareerId = lookupDao.getLookup("career", "job_group_id", job_group_id.getValue().getId());
		System.out.println(job_group_id.getValue().getId());

		career_id.getItems().addAll(empCareerId);

		career_id.setConverter(new StringConverter<Lookup>() {

			@Override
			public String toString(Lookup object) {

				return object.getName();
			}

			@Override
			public Lookup fromString(String string) {
				return career_id.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst().orElse(null);
			};

		});
	}

	public void insertData(ActionEvent e) throws IOException {

		LocalDate graduationDate = graduation_date.getValue();
		LocalDate birthDate = birth_date.getValue();
		LocalDate recruitmentDate = recruitment_date.getValue();
		LocalDate jobStabilityDate = job_stability_date.getValue();
		
		//int typeId = type_id.getValue() == null ? null : type_id.getValue().getId();

		String empNo = emp_no.getText();
		
		Lookup typeIdLookup = type_id.getValue();
		Lookup jobGroupIdLookup = job_group_id.getValue();
		Lookup careerIdLookup = career_id.getValue();
		
		int typeId = 0 ;
		int jobGroupId = 0;
		int careerId = 0;
		
		if(typeIdLookup != null) {
			typeId = typeIdLookup.getId();
		}
		
		if(jobGroupIdLookup != null) {
			jobGroupId = jobGroupIdLookup.getId();
		}
		
		if(careerIdLookup != null) {
			careerId = careerIdLookup.getId();
		}

				
		String employeeName = name.getText();
		String recruitmentDecisionNumber = recruitment_decision_number.getText();
		String jobStabilityDecisionNumber = job_stability_decision_number.getText();
		
		String employeeAddress = address.getText();
		String employeeNotes = notes.getText();

		int type_Id = typeId;// Integer.parseInt(typeId);
		int recruitment_Decision_Number = Integer.parseInt(recruitmentDecisionNumber);
		int job_Stability_Decision_Number = Integer.parseInt(jobStabilityDecisionNumber);
		int job_Group_Id = jobGroupId;
		int career_Id = careerId;
		int emp_No = Integer.parseInt(empNo);

		String graduation_Date = graduationDate.toString();
		String birth_Date = birthDate.toString();
		String recruitment_Date = recruitmentDate.toString();
		String jobStability_Date = jobStabilityDate.toString();

		Employee emp = new Employee();
		emp.setEmp_no(emp_No);
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

		if (status > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Insert");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record updated successfully!");

			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data Insert");
			alert.setHeaderText("Error Dialog");
			alert.setContentText("Sorry! unable to update record");

			alert.showAndWait();
		}

	}
	
	public void insertTraining(ActionEvent e) throws IOException {

		Stage primaryStage = new Stage();
		// DBConnection.getDB().getConnection();

		Parent root = FXMLLoader.load(getClass().getResource("InsertTraining.fxml"));
		Scene scene = new Scene(root, 850, 600);
		// scene.getStylesheets().add(getClass().getResource("/com/employeeManagement/application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	

}
