package com.employeeManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeeManagement.dbconn.DBConnection;
import com.employeeManagement.entity.Employee;
import com.employeeManagement.util.ColumnName;
import com.employeeManagement.util.SqlQuery;

public class EmployeeDao {

	
	public List<Employee> getAllEmployees() {
		List<Employee> employees=new ArrayList<>();
		Connection con = DBConnection.getDB().getConnection();
		try {
			
			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.GET_ALL_EMPLOYEES_QUERY);
			ResultSet resultSet =  preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee=getEmployee(resultSet);
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public List<Employee> findEmployeeById(String id) {
		List<Employee> employees=new ArrayList<>();
		Connection con = DBConnection.getDB().getConnection();
		try {
			
			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.FIND_EMPLOYEE_BY_ID_QUERY);
			preparedStatement.setString(1, id);
			ResultSet resultSet =  preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee=getEmployee(resultSet);
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}


	private Employee getEmployee(ResultSet resultSet) throws SQLException {
		Employee employee=new Employee();
		
		int id=resultSet.getInt(ColumnName.EMPLOYEE_ID);
		String name=resultSet.getString(ColumnName.EMPLOYEE_NAME);
		
		employee.setId(id);
		employee.setName(name);
		
		return employee;
	}
	
}
