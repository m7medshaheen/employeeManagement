package com.employeeManagement.view;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.employeeManagement.dao.EmployeeDao;
import com.employeeManagement.dao.LookupDao;
import com.employeeManagement.entity.Employee;
import com.employeeManagement.entity.Lookup;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class UpdateDelete_Controller implements Initializable {

	@FXML
	private TextField emp_no1;
	@FXML
	private TextField emp_no;
	@FXML
	private TextField name;
	@FXML
	private ComboBox<Lookup> type_id;
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
	private ComboBox<Lookup> job_group_id;
	@FXML
	private ComboBox<Lookup> career_id;
	@FXML
	private TextField address;
	@FXML
	private TextField notes;

	private LookupDao lookupDao;

	public UpdateDelete_Controller() {
		super();
		lookupDao = new LookupDao();
		type_id = new ComboBox<Lookup>();
		job_group_id = new ComboBox<Lookup>();
		career_id = new ComboBox<Lookup>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		getEmpType();
		getEmpGroupId();

	}

	public void getEmpType() {

		ObservableList<Lookup> empTypes = lookupDao.getLookup("emp_type");

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
			public String toString(Lookup  object) {

				return object.getName();
			}

			@Override
			public Lookup fromString(String string) {
				return job_group_id.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst()
						.orElse(null);
			};

		});

	}

	public void getEmpCareerId(ActionEvent e) {

		career_id.getItems().clear();
		ObservableList<Lookup> empCareerId = lookupDao.getLookup("career", "job_group_id",
				job_group_id.getValue().getId());
		// System.out.println(job_group_id.getValue().getId());

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

	public void getEmployeeById(ActionEvent e) throws IOException, ParseException {

		
		String empNo = emp_no.getText();
		int No = Integer.parseInt(empNo);

		Employee emp = EmployeeDao.getEmployeeById(No);
		
		emp_no1.setText(String.valueOf(emp.getEmp_no()));

		if(No == emp.getEmp_no()) {
		name.setText(emp.getName());

		int type = emp.getType_id();
		int groupId = emp.getJob_group_id();
		int careerId = emp.getCareer_id();
		// System.out.println(careerId);
		// getEmpCareerId();

		// type_id.setItems(FXCollections.observableArrayList(lookupDao.getLookup("emp_type",
		// "id", type)));
		// type_id.setText(String.valueOf(emp.getType_id()));
		if (emp.getEmp_no() != 0) {
			//type_id.setPromptText(type_id.getItems().get(type).getName());
			type_id.setValue(type_id.getItems().get(type+1));
			
		} else {
			type_id.getItems().clear();
		}
		graduation_date.setText(emp.getGraduation_date());
		birth_date.setText(emp.getBirth_date());
		recruitment_date.setText(emp.getRecruitment_date());
		recruitment_decision_number.setText(String.valueOf(emp.getRecruitment_decision_number()));
		job_stability_date.setText(emp.getJob_stability_date());
		job_stability_decision_number.setText(String.valueOf(emp.getJob_stability_decision_number()));

		// job_group_id.setText(String.valueOf(emp.getJob_group_id()));
		if (emp.getEmp_no() != 0) {
			
			//job_group_id.setPromptText(job_group_id.getItems().get(groupId).getName());
//			//job_group_id.setValue(new Lookup(0, job_group_id.getItems().get(groupId).getName()));

			job_group_id.setValue( job_group_id.getItems().get(groupId+1));
		} else {
			job_group_id.getItems().clear();
		}
		// career_id.setText(String.valueOf(emp.getCareer_id()));
		// System.out.println(career_id.getItems().get(careerId).getName());

		ObservableList<Lookup> careers = lookupDao.getCareerLookup("career", "job_group_id", groupId, "id", careerId);

		careers.forEach( x -> {
			System.out.println("careers ===> "+ x.getName());
		});
		// System.out.println(list);
		if (emp.getEmp_no() != 0) {
			//career_id.setPromptText(careers.get(1).getName());
			if(careers.size() > 1) {
			career_id.setValue( careers.get(1));
			}else
			{
				career_id.setValue( careers.get(0));
			}
		} else {
			career_id.setPromptText("");
		}
		address.setText(emp.getAddress());
		notes.setText(emp.getNotes());
		}else {
		
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("number not found in database");
			alert.setHeaderText("Error Dialog");
			alert.setContentText("Sorry! unable to find this employee ID");
			clear();
			alert.showAndWait();
		}
	}

	public void updateEmployee(ActionEvent e) throws IOException, ParseException {
		String sid = emp_no1.getText();
		
		int id = Integer.parseInt(sid);
		System.out.println("id---------->"+id);
		// int EmpID = Integer.parseInt(emp_id1.getText());

		String employeeName = name.getText();

		// int EmployeeType = Integer.parseInt(type_id.getText());

		// System.out.println("EmployeeType====> "+EmployeeType);

		String graduationDate = graduation_date.getText();
		String birthDate = birth_date.getText();
		String recruitmentDate = recruitment_date.getText();
		int recruitmentDecisionNumber = Integer.parseInt(recruitment_decision_number.getText());
		String jobStabilityDate = job_stability_date.getText();
		int jobStabilityDecisionNumber = Integer.parseInt(job_stability_decision_number.getText());

		// int jobGroupId = Integer.parseInt(job_group_id.getText());
		// int careerId = Integer.parseInt(career_id.getText());

		String employeeAddress = address.getText();
		String employeeNotes = notes.getText();

		Employee emp = new Employee();
		System.out.println("id222===>"+id);
		
		emp.setEmp_no(id);
		
		emp.setName(employeeName);

		if (type_id.getValue() != null) {
			int EmployeeType = type_id.getValue().getId();
			emp.setType_id(EmployeeType);
		} else {
			emp.setType_id(1);
		}

		emp.setGraduation_date(graduationDate);
		emp.setBirth_date(birthDate);
		emp.setRecruitment_date(recruitmentDate);
		emp.setRecruitment_decision_number(recruitmentDecisionNumber);
		emp.setJob_stability_date(jobStabilityDate);
		emp.setJob_stability_decision_number(jobStabilityDecisionNumber);

		if (job_group_id.getValue() != null) {
			int jobGroupIdee = job_group_id.getValue().getId();
			emp.setJob_group_id(jobGroupIdee);
			System.out.println("jobGroupIdee============>"+jobGroupIdee);
		} else {
			emp.setJob_group_id(1);
		}
		if (career_id.getValue() != null) {
			int careerIdee = career_id.getValue().getId();
			emp.setCareer_id(careerIdee);
			System.out.println("careerIdee============>"+careerIdee);
		} else {
			emp.setCareer_id(1);
		}

		emp.setAddress(employeeAddress);
		emp.setNotes(employeeNotes);
        System.out.println("emp.getEmp_no()------>"+emp.getEmp_no());
        
        //  search  ÞíãÉ ÇáÈæßÓ ÈÊÇÚ Çá
        // ÇáãÞÇÈá ááÑÞã Ïå idåäÇ ÈÞæáå ÎÏ ÑÞã ÇáãæÙÝ Çá Ýì ÈæßÓ ÇáÈÍË æåÇÊáì Çá    
      
        int emp_no1 = Integer.parseInt(emp_no.getText());
		int emp_id = EmployeeDao.getEmpID(emp_no1);
		emp.setEmp_id(emp_id);
		System.out.println("emp_id=============>"+emp_id);
		int status = EmployeeDao.update(emp);
		

		if (status > 0) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data updated");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record updated successfully!");
			
			
			alert.showAndWait();
			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data updated");
			alert.setHeaderText("Error Dialog");
			alert.setContentText("Sorry! unable to update record");

			alert.showAndWait();
		}

		
	}

	public void deleteEmployee(ActionEvent e) throws IOException, ParseException {
		String sid = emp_no.getText();
		int id = Integer.parseInt(sid);

		int status = EmployeeDao.delete(id);

		if (status > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Deleted");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record deleted successfully!");

			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data Deleted");
			alert.setHeaderText("Error Dialog");
			alert.setContentText("Sorry! unable to delete record");

			alert.showAndWait();
		}

	}

	public void clear() {
		name.setText("");
		emp_no1.setText("");
		type_id.setValue(new Lookup(0, ""));
//		type_id.setValue("");
		graduation_date.setText("");
		birth_date.setText("");
		recruitment_date.setText("");
		recruitment_decision_number.setText("");
		job_stability_date.setText("");
		job_stability_decision_number.setText("");
		job_group_id.setValue(new Lookup(0, ""));
		career_id.setValue(new Lookup(0, ""));
		address.setText("");
		notes.setText("");

	}

}
