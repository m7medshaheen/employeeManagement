package com.employeeManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeeManagement.dbconn.DBConnection;
import com.employeeManagement.entity.Employee;
import com.employeeManagement.entity.Training;
import com.employeeManagement.util.ColumnName;
import com.employeeManagement.util.SqlQuery;

public class TrainingDao {
	
	public static List<Training> getAllTraining() {
		List<Training> trainings = new ArrayList<>();
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.GET_ALL_TRAINING_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Training training = getTraining(resultSet);
				trainings.add(training);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainings;
	}

	public static List<Training> findTrainingById(String id) {
		List<Training> trainings = new ArrayList<>();
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.FIND_EMPLOYEE_BY_ID_QUERY);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Training training = getTraining(resultSet);
				trainings.add(training);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainings;
	}

	public static Training getTraining(ResultSet resultSet) throws SQLException {
		Training training = new Training();

		int training_id = resultSet.getInt(ColumnName.TRAINING_ID);
		String name = resultSet.getString(ColumnName.TRAINING_NAME);

		training.setTraining_id(training_id);
		training.setTraining_name(name);

		return training;
	}
	 
/////////////////////////////////////////////////////////////////////////////////////
	  
	public static int save(Training traing) {
		int st = 0;

		try {
			Connection con = DBConnection.getDB().getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.INSERT_TRAINING_QUERY);
			preparedStatement.setInt(1, traing.getTraining_id());
			preparedStatement.setInt(2, traing.getTraining_type_id());
			preparedStatement.setInt(3, traing.getTraining_outlet_id());
			preparedStatement.setString(4, traing.getTraining_name());
			preparedStatement.setString(5, traing.getTraining_side());
			preparedStatement.setString(6, traing.getTraining_place());
			preparedStatement.setString(7, traing.getStart_training_date());
			preparedStatement.setString(8, traing.getEnd_training_date());
			preparedStatement.setDouble(9, traing.getTraining_fees());
			preparedStatement.setString(10, traing.getNotes());
			preparedStatement.setInt(11, traing.getGuarantor_id());
			preparedStatement.setString(12, traing.getGuarantor_name());
			preparedStatement.setInt(13, traing.getTraining_decision_number());
			

			st = preparedStatement.executeUpdate();
		//	con.close();

		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("saveeeeeeeee");
		}
		return st;

	}

	public static int update(Employee emp) {
		int st = 0;

		try {
			Connection con = DBConnection.getDB().getConnection();
			
			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.UPDATE_EMPLOYEE_QUERY);
			preparedStatement.setInt(1, emp.getEmp_id());
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
			preparedStatement.setInt(14, emp.getEmp_id());
		
			st = preparedStatement.executeUpdate();
			//con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("errrrrrrrrrrrrror update");
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
			//con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;

	}
	
	
	public static Employee getEmployeeById(int id) {
		//List<Employee> employees = new ArrayList<>();
		Employee emp = new Employee();
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.FIND_EMPLOYEE_BY_ID_QUERY);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				emp.setEmp_id(resultSet.getInt(1));
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
		//	con.close();
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
			//	Employee employee = getEmployee(resultSet);
			//	employees.add(employee);
				Employee emp = new Employee();

				emp.setEmp_id(resultSet.getInt(1));
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
