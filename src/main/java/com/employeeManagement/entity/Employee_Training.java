package com.employeeManagement.entity;

public class Employee_Training {
	private int emp_id;
	private int training_id;
	
	
	
	public Employee_Training(int emp_id, int training_id) {
		super();
		this.emp_id = emp_id;
		this.training_id = training_id;
	
	}


	public Employee_Training() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public int getTraining_id() {
		return training_id;
	}


	public void setTraining_id(int training_id) {
		this.training_id = training_id;
	}


	
	
	
	
	
	
	
}
