package com.employeeManagement.entity;

public class Training {

	private int training_id;
	private int training_type_id;
	private int training_outlet_id;
	private String training_name;
	private String training_side;
	private String training_place;
	private String start_training_date;
	private String end_training_date;
	private double training_fees;
	private String notes;
	private int guarantor_id;
	private String guarantor_name;
	private int training_decision_number;
	
	
	
	
	public String getNotes() {
		return notes;
	}




	public void setNotes(String notes) {
		this.notes = notes;
	}




	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Training(int training_id, int training_type_id, int training_outlet_id, String training_name,
			String training_side, String training_place, String start_training_date, String end_training_date,
			double training_fees, String notes, int guarantor_id, String guarantor_name, int training_decision_number) {
		super();
		this.training_id = training_id;
		this.training_type_id = training_type_id;
		this.training_outlet_id = training_outlet_id;
		this.training_name = training_name;
		this.training_side = training_side;
		this.training_place = training_place;
		this.start_training_date = start_training_date;
		this.end_training_date = end_training_date;
		this.training_fees = training_fees;
		this.notes = notes;
		this.guarantor_id = guarantor_id;
		this.guarantor_name = guarantor_name;
		this.training_decision_number = training_decision_number;
	}




	public int getTraining_id() {
		return training_id;
	}




	public void setTraining_id(int training_id) {
		this.training_id = training_id;
	}




	public int getTraining_type_id() {
		return training_type_id;
	}




	public void setTraining_type_id(int training_type_id) {
		this.training_type_id = training_type_id;
	}




	public int getTraining_outlet_id() {
		return training_outlet_id;
	}




	public void setTraining_outlet_id(int training_outlet_id) {
		this.training_outlet_id = training_outlet_id;
	}




	public String getTraining_name() {
		return training_name;
	}




	public void setTraining_name(String training_name) {
		this.training_name = training_name;
	}




	public String getTraining_side() {
		return training_side;
	}




	public void setTraining_side(String training_side) {
		this.training_side = training_side;
	}




	public String getTraining_place() {
		return training_place;
	}




	public void setTraining_place(String training_place) {
		this.training_place = training_place;
	}




	public String getStart_training_date() {
		return start_training_date;
	}




	public void setStart_training_date(String start_training_date) {
		this.start_training_date = start_training_date;
	}




	public String getEnd_training_date() {
		return end_training_date;
	}




	public void setEnd_training_date(String end_training_date) {
		this.end_training_date = end_training_date;
	}




	public double getTraining_fees() {
		return training_fees;
	}




	public void setTraining_fees(double training_fees) {
		this.training_fees = training_fees;
	}
	

	public int getGuarantor_id() {
		return guarantor_id;
	}




	public void setGuarantor_id(int guarantor_id) {
		this.guarantor_id = guarantor_id;
	}




	public String getGuarantor_name() {
		return guarantor_name;
	}




	public void setGuarantor_name(String guarantor_name) {
		this.guarantor_name = guarantor_name;
	}




	public int getTraining_decision_number() {
		return training_decision_number;
	}




	public void setTraining_decision_number(int training_decision_number) {
		this.training_decision_number = training_decision_number;
	}

	
	
}
