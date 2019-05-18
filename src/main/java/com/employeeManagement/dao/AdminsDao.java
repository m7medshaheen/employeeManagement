package com.employeeManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeeManagement.dbconn.DBConnection;
import com.employeeManagement.entity.Admins;
import com.employeeManagement.util.SqlQuery;

public class AdminsDao {

	public List<Admins> getAdmins() {
		List<Admins> list = new ArrayList<Admins>();
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.GET_ALL_USERS_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Admins adm = new Admins();
				adm.setId(resultSet.getInt(1));
				adm.setUser_name(resultSet.getString(2));
				adm.setPassword(resultSet.getString(3));
				list.add(adm);
			}
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
