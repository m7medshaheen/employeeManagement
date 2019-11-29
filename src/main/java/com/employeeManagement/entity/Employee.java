package com.employeeManagement.entity;
public class Employee {	
	
	private int emp_no;
	private String name;
	private int type_id;
	private String graduation_date;
	private String birth_date;
	private String recruitment_date;
	private int recruitment_decision_number;
	private String job_stability_date;
	private int job_stability_decision_number;
	private int job_group_id;
	private int career_id;
	private String address;
	private String notes;
	private int emp_id;
	
	
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public Employee(int emp_no, String name, int type_id, String graduation_date, String birth_date,
			String recruitment_date, int recruitment_decision_number, String job_stability_date,
			int job_stability_decision_number, int job_group_id, int career_id, String address, String notes) {
		super();
		this.emp_no = emp_no;
		this.name = name;
		this.type_id = type_id;
		this.graduation_date = graduation_date;
		this.birth_date = birth_date;
		this.recruitment_date = recruitment_date;
		this.recruitment_decision_number = recruitment_decision_number;
		this.job_stability_date = job_stability_date;
		this.job_stability_decision_number = job_stability_decision_number;
		this.job_group_id = job_group_id;
		this.career_id = career_id;
		this.address = address;
		this.notes = notes;
	}	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getGraduation_date() {
		return graduation_date;
	}
	public void setGraduation_date(String graduation_date) {
		this.graduation_date = graduation_date;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getRecruitment_date() {
		return recruitment_date;
	}
	public void setRecruitment_date(String recruitment_date) {
		this.recruitment_date = recruitment_date;
	}
	public int getRecruitment_decision_number() {
		return recruitment_decision_number;
	}
	public void setRecruitment_decision_number(int recruitment_decision_number) {
		this.recruitment_decision_number = recruitment_decision_number;
	}
	public String getJob_stability_date() {
		return job_stability_date;
	}
	public void setJob_stability_date(String job_stability_date) {
		this.job_stability_date = job_stability_date;
	}
	public int getJob_stability_decision_number() {
		return job_stability_decision_number;
	}
	public void setJob_stability_decision_number(int job_stability_decision_number) {
		this.job_stability_decision_number = job_stability_decision_number;
	}
	public int getJob_group_id() {
		return job_group_id;
	}
	public void setJob_group_id(int job_group_id) {
		this.job_group_id = job_group_id;
	}
	public int getCareer_id() {
		return career_id;
	}
	public void setCareer_id(int career_id) {
		this.career_id = career_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}	
	
}
