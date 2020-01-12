package com.employeeManagement.util;

public class SqlQuery {

	public static final String GET_ALL_EMPLOYEES_QUERY = "SELECT * FROM employee";
	public static final String GET_ALL_TRAINING_QUERY = "SELECT * FROM training";
	public static final String FIND_EMPLOYEE_BY_NUM_QUERY = "SELECT * FROM employee where emp_no = ?";
	public static final String GET_TRIANING_ID = "SELECT MAX(training_id) FROM training";
	public static final String GET_ALL_USERS_QUERY = "SELECT * FROM user";

	public static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO employee(emp_no,`name`,type_id,graduation_date,"
			+ "birth_date,recruitment_date,recruitment_decision_number,job_stability_date,job_stability_decision_number"
			+ ",job_group_id,career_id,address,notes)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String INSERT_TRAINING_QUERY = "INSERT INTO training(training_id,training_type_id,training_outlet_id,training_name,"
			+ "training_side,training_place,start_training_date,end_training_date,training_fees,notes,guarantor_id,guarantor_name,training_decision_number"
			+ ")" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String INSERT_EMPLOYEE_TRAINING_QUERY = "INSERT INTO employee_training(emp_id,training_id) VALUES(?,?)";

	
	//no single qutation '' on string
	public static final String UPDATE_EMPLOYEE_QUERY = "UPDATE employee SET emp_no=?,`name`=?,type_id=?,graduation_date=?,"
			+ "birth_date=?,recruitment_date=?,recruitment_decision_number=? ,job_stability_date=?,"
			+ "job_stability_decision_number=?,job_group_id=?,career_id=?,address=?,notes=? where emp_id=?";

	public static final String DELETE_EMPLOYEE_QUERY = "DELETE FROM employee where emp_no=?";
	
	public static final String GET_EMP_ID = "select emp_id from employee where emp_no=?";

	public static String getLookupQueryName(String tableName) {
		String query = "SELECT * FROM " + tableName;
		return query;
	}

	public static String getLookupQueryName(String tableName, String columnName) {
		String query = "SELECT * FROM " + tableName + " WHERE " + columnName + "= ?";
		return query;
	}
	public static String getLookupQueryName2(String tableName, String columnName,String columnName2) {
		String query = "SELECT * FROM " + tableName + " WHERE " + columnName + "= ?"+" AND " + columnName2 + "= ?";
		return query;
	}
	

}
