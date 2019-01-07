package com.employeeManagement.util;

public class SqlQuery {

	public static final String GET_ALL_EMPLOYEES_QUERY = "SELECT * FROM employee";
	public static final String FIND_EMPLOYEE_BY_ID_QUERY = "SELECT * FROM employee where emp_id = ?";

	public static String getLookupQueryName(String tableName) {
		String query = "SELECT * FROM " + tableName;
		return query;
	}

	public static String getLookupQueryName(String tableName, String columnName) {
		String query = "SELECT * FROM " + tableName + " WHERE " + columnName + "= ?";
		return query;
	}

}
