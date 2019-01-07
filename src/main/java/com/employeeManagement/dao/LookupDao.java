package com.employeeManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeeManagement.dbconn.DBConnection;
import com.employeeManagement.entity.Lookup;
import com.employeeManagement.util.ColumnName;
import com.employeeManagement.util.SqlQuery;

public class LookupDao {

	public List<Lookup> getLookup(String tableName) {
		List<Lookup> lookups = new ArrayList<Lookup>();
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.getLookupQueryName(tableName));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Lookup lookup = new Lookup();
				int id = resultSet.getInt(ColumnName.LOOKUP_ID);
				String name = resultSet.getString(ColumnName.LOOKUP_NAME);
				lookup.setId(id);
				lookup.setName(name);
				lookups.add(lookup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lookups;
	}
	/**
	 * 
	 * @param tableName
	 * @param columnName
	 * @param forginKeyId
	 * @return
	 */
	public List<Lookup> getLookup(String tableName,String columnName,int forginKeyId) {
		List<Lookup> lookups = new ArrayList<Lookup>();
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(SqlQuery.getLookupQueryName(tableName, columnName));
			preparedStatement.setInt(1, forginKeyId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Lookup lookup = new Lookup();
				int id = resultSet.getInt(ColumnName.LOOKUP_ID);
				String name = resultSet.getString(ColumnName.LOOKUP_NAME);
				lookup.setId(id);
				lookup.setName(name);
				lookups.add(lookup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lookups;
	}
}
