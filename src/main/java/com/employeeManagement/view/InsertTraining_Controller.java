package com.employeeManagement.view;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.employeeManagement.dao.EmployeeDao;
import com.employeeManagement.dao.Employee_TrainingDao;
import com.employeeManagement.dao.LookupDao;
import com.employeeManagement.dao.TrainingDao;
import com.employeeManagement.entity.Employee;
import com.employeeManagement.entity.Employee_Training;
import com.employeeManagement.entity.Lookup;
import com.employeeManagement.entity.Training;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class InsertTraining_Controller implements Initializable {

	@FXML
	private TextField emp_id;
	@FXML
	private TextField name;
	@FXML
	private TextField training_id;
	@FXML
	private ComboBox<Lookup> training_type_id;
	@FXML
	private ComboBox<Lookup> training_outlet_id;
	@FXML
	private TextField training_name;
	@FXML
	private TextField training_side;
	@FXML
	private TextField training_place;
	@FXML
	private DatePicker start_training_date;
	@FXML
	private DatePicker end_training_date;
	@FXML
	private TextField training_fees;
	@FXML
	private TextField notes;
	@FXML
	private TextField guarantor_id;
	@FXML
	private TextField guarantor_name;
	@FXML
	private TextField training_decision_number;
	

	private LookupDao lookupDao;

	public InsertTraining_Controller() {
		// type_id=new ComboBox<Emp_type>();
		training_type_id = new ComboBox<Lookup>();
		training_outlet_id = new ComboBox<Lookup>();

		lookupDao = new LookupDao();
		

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// «‰Ê«⁄ «· œ—Ì»
		getTrainingType();
		// „‰›– «· œ—Ì»
		getTrainingOutlet();
		

	}
	
	
	public void getEmployeeById(ActionEvent e) throws IOException, ParseException {

		String sid = emp_id.getText();
		int id = Integer.parseInt(sid);

		Employee emp = EmployeeDao.getEmployeeById(id);
		
		name.setText(emp.getName());
	}
	
	
	public void getTrainingType() {

		// ObservableList<Emp_type> empTypes=emp_typeDao.getLookup();
		ObservableList<Lookup> trainingTypes = lookupDao.getLookup("training_type");

		// for(Emp_type empType:empTypes) {
		// type=type+"\n"+empType.getName();
		// }
		// employeeTextAreaId2.setText(type);
		training_type_id.getItems().addAll(trainingTypes);
		training_type_id.setConverter(new StringConverter<Lookup>() {

			@Override
			public String toString(Lookup object) {
//				 if(object != null) {
//				return object.getName();
//				 }else {
//					 return "";
//				 }
				return object.getName();
			}

			@Override
			public Lookup fromString(String string) {
				// TODO Auto-generated method stub
				return training_type_id.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst()
						.orElse(null);
			}

		});

	}

	public void getTrainingOutlet() {

		ObservableList<Lookup> trainingOutlet = lookupDao.getLookup("training_outlet");

		training_outlet_id.getItems().addAll(trainingOutlet);

		training_outlet_id.setConverter(new StringConverter<Lookup>() {

			@Override
			public String toString(Lookup object) {

				return object.getName();
			}

			@Override
			public Lookup fromString(String string) {
				return training_outlet_id.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst()
						.orElse(null);
			};

		});
	}

	public void insertData(ActionEvent e) throws IOException {

		String trainingId = training_id.getText();
		int trainingTypeId = training_type_id.getValue().getId();
		int trainingOutletId = training_outlet_id.getValue().getId();
		String trainingName = training_name.getText();
		String trainingSide = training_side.getText();
		String trainingPlace = training_place.getText();
		LocalDate startTrainingDate = start_training_date.getValue();
		LocalDate endTrainingDate = end_training_date.getValue();
		String trainingFees = training_fees.getText();
		String trainingNotes = notes.getText();		
		String guarantorId = guarantor_id.getText();
		String guarantorName = guarantor_name.getText();
		String trainingDecisionNumber = training_decision_number.getText();

		
		int empId = Integer.parseInt(emp_id.getText());
		
		
		int training_Id = Integer.parseInt(trainingId);
		int training_TypeId = trainingTypeId;
		int training_OutletId = trainingOutletId;
		String startTraining_Date = startTrainingDate.toString();
		String endTraining_Date = endTrainingDate.toString();
		double training_Fees = Double.parseDouble(trainingFees);
		int guarantor_Id = Integer.parseInt(guarantorId);
		int trainingDecision_Number=Integer.parseInt(trainingDecisionNumber);
		
		

		Training training = new Training();
		
		Employee_Training empTraining = new Employee_Training();

		training.setTraining_id(training_Id);
		training.setTraining_type_id(training_TypeId);
		training.setTraining_outlet_id(training_OutletId);
		training.setTraining_name(trainingName);
		training.setTraining_place(trainingPlace);
		training.setTraining_side(trainingSide);
		training.setStart_training_date(startTraining_Date);
		training.setEnd_training_date(endTraining_Date);
		training.setTraining_fees(training_Fees);
		training.setNotes(trainingNotes);
		training.setGuarantor_id(guarantor_Id);
		training.setGuarantor_name(guarantorName);
		training.setTraining_decision_number(trainingDecision_Number);
		
		empTraining.setTraining_id(training_Id);
		empTraining.setEmp_id(empId);
		

		
		int status = TrainingDao.save(training);
		
		Employee_TrainingDao.save(empTraining);

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

}
