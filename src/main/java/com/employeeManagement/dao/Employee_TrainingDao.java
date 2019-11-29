package com.employeeManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeeManagement.dbconn.DBConnection;
import com.employeeManagement.entity.Employee;
import com.employeeManagement.entity.Employee_Training;
import com.employeeManagement.util.SqlQuery;

public class Employee_TrainingDao {

	
	

	public static int save(Employee_Training employeeTraing) {
		int st = 0;

		try {
			Connection con = DBConnection.getDB().getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.INSERT_EMPLOYEE_TRAINING_QUERY);
			preparedStatement.setInt(1, employeeTraing.getEmp_id());
			preparedStatement.setInt(2, employeeTraing.getTraining_id());
			

			st = preparedStatement.executeUpdate();
			// con.close();

		} catch (SQLException e) {
			e.printStackTrace();
//				System.out.println("saveeeeeeeee");
		}
		return st;

	}

	public static int update(Employee emp) {
		int st = 0;

		try {
			Connection con = DBConnection.getDB().getConnection();

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.UPDATE_EMPLOYEE_QUERY);
			preparedStatement.setInt(1, emp.getEmp_no());
			preparedStatement.setString(2, emp.getName());
			preparedStatement.setInt(3, emp.getType_id());
			preparedStatement.setString(4, emp.getGraduation_date());
			preparedStatement.setString(5, emp.getBirth_date());
			preparedStatement.setString(6, emp.getRecruitment_date());
			preparedStatement.setInt(7, emp.getRecruitment_decision_number());
			preparedStatement.setString(8, emp.getJob_stability_date());
			preparedStatement.setInt(9, emp.getJob_stability_decision_number());
			preparedStatement.setInt(10, emp.getJob_group_id());
			preparedStatement.setInt(11, emp.getCareer_id());
			preparedStatement.setString(12, emp.getAddress());
			preparedStatement.setString(13, emp.getNotes());
			preparedStatement.setInt(14, emp.getEmp_no());

			st = preparedStatement.executeUpdate();
			// con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("errrrrrrrrrrrrror update");
		}
		return st;

	}

	public static int delete(int id) {
		int st = 0;

		try {
			Connection con = DBConnection.getDB().getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.DELETE_EMPLOYEE_QUERY);
			preparedStatement.setInt(1, id);

			st = preparedStatement.executeUpdate();
			// con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;

	}

	public static Employee getEmployeeById(int id) {
		// List<Employee> employees = new ArrayList<>();
		Employee emp = new Employee();
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.FIND_EMPLOYEE_BY_ID_QUERY);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				emp.setEmp_no(resultSet.getInt(1));
				emp.setName(resultSet.getString(2));
				emp.setType_id(resultSet.getInt(3));
				emp.setGraduation_date(resultSet.getString(4));
				emp.setBirth_date(resultSet.getString(5));
				emp.setRecruitment_date(resultSet.getString(6));
				emp.setRecruitment_decision_number(resultSet.getInt(7));
				emp.setJob_stability_date(resultSet.getString(8));
				emp.setJob_stability_decision_number(resultSet.getInt(9));
				emp.setJob_group_id(resultSet.getInt(10));
				emp.setCareer_id(resultSet.getInt(11));
				emp.setAddress(resultSet.getString(12));
				emp.setNotes(resultSet.getString(13));

			}
			// con.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return emp;
	}

	public static List<Employee> getEmployee() {
		List<Employee> employees = new ArrayList<Employee>();
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.FIND_EMPLOYEE_BY_ID_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Employee employee = getEmployee(resultSet);
				// employees.add(employee);
				Employee emp = new Employee();

				emp.setEmp_no(resultSet.getInt(1));
				emp.setName(resultSet.getString(2));
				emp.setType_id(resultSet.getInt(3));
				emp.setGraduation_date(resultSet.getString(4));
				emp.setBirth_date(resultSet.getString(5));
				emp.setRecruitment_date(resultSet.getString(6));
				emp.setRecruitment_decision_number(resultSet.getInt(7));
				emp.setJob_stability_date(resultSet.getString(8));
				emp.setJob_stability_decision_number(resultSet.getInt(9));
				emp.setJob_group_id(resultSet.getInt(10));
				emp.setCareer_id(resultSet.getInt(11));
				emp.setAddress(resultSet.getString(12));
				emp.setNotes(resultSet.getString(13));

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

}
