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

}