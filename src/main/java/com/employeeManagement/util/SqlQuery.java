package com.employeeManagement.util;

public class SqlQuery {

	public static final String GET_ALL_EMPLOYEES_QUERY = "SELECT * FROM employee";
	public static final String FIND_EMPLOYEE_BY_ID_QUERY = "SELECT * FROM employee where emp_id = ?";
	public static final String GET_ALL_USERS_QUERY = "SELECT * FROM user";

	public static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO employee(emp_id,`name`,type_id,graduation_date,"
			+ "birth_date,recruitment_date,recruitment_decision_number,job_stability_date,job_stability_decision_number"
			+ ",job_group_id,career_id,address,notes)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	
	//no single qutation '' on string
	public static final String UPDATE_EMPLOYEE_QUERY = "UPDATE employee SET emp_id=?,`name`=?,type_id=?,graduation_date=?,"
			+ "birth_date=?,recruitment_date=?,recruitment_decision_number=? ,job_stability_date=?,"
			+ "job_stability_decision_number=?,job_group_id=?,career_id=?,address=?,notes=? where emp_id=?";

	public static final String DELETE_EMPLOYEE_QUERY = "DELETE FROM employee where emp_id=?";

	public static String getLookupQueryName(String tableName) {
		String query = "SELECT * FROM " + tableName;
		return query;
	}

	public static String getLookupQueryName(String tableName, String columnName) {
		String query = "SELECT * FROM " + tableName + " WHERE " + columnName + "= ?";
		return query;
	}

}
