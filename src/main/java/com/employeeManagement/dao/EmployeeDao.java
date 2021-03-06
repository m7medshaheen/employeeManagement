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
		List<Employee> employees = new ArrayList<>();
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.GET_ALL_EMPLOYEES_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = getEmployee(resultSet);
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public List<Employee> findEmployeeById(String id) {
		List<Employee> employees = new ArrayList<>();
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.FIND_EMPLOYEE_BY_NUM_QUERY);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = getEmployee(resultSet);
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	private Employee getEmployee(ResultSet resultSet) throws SQLException {
		Employee employee = new Employee();

		int emp_no = resultSet.getInt(ColumnName.EMPLOYEE_NO);
		String name = resultSet.getString(ColumnName.EMPLOYEE_NAME);

		employee.setEmp_no(emp_no);
		employee.setName(name);

		return employee;
	}

/////////////////////////////////////////////////////////////////////////////////////

	public static int save(Employee emp) {
		int st = 0;

		try {
			Connection con = DBConnection.getDB().getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.INSERT_EMPLOYEE_QUERY);
			preparedStatement.setInt(1, emp.getEmp_no());
			preparedStatement.setString(2, emp.getName());
//			if (emp.getType_id() != 0) {
			System.err.println("typeId:: "+ emp.getType_id());
				preparedStatement.setInt(3, emp.getType_id());
//			}
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

			st = preparedStatement.executeUpdate();
			// con.close();

		} catch (Exception e) {
			e.printStackTrace();
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
			System.out.println("emp_id22222=============>"+emp.getEmp_id());
			preparedStatement.setInt(14, emp.getEmp_id());

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

	public static Employee getEmployeeByNUM(int empNum) {
		// List<Employee> employees = new ArrayList<>();
		Employee emp = new Employee();
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.FIND_EMPLOYEE_BY_NUM_QUERY);
			preparedStatement.setInt(1, empNum);
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
				emp.setEmp_id(resultSet.getInt(14));

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

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.FIND_EMPLOYEE_BY_NUM_QUERY);
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
	
	public static int getEmpID(int empNo) {
		int st = 0;

		try {
			Connection con = DBConnection.getDB().getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.GET_EMP_ID);
			preparedStatement.setInt(1, empNo);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Employee employee = getEmployee(resultSet);
				// employees.add(employee);
				//Employee emp = new Employee();

				st=resultSet.getInt(1);
			}
			// con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;

	}


}
