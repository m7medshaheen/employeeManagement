package com.employeeManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employeeManagement.dbconn.DBConnection;
import com.employeeManagement.entity.Lookup;
import com.employeeManagement.util.ColumnName;
import com.employeeManagement.util.SqlQuery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LookupDao {

	public ObservableList<Lookup> getLookup(String tableName) {
		ObservableList<Lookup> lookups = FXCollections.observableArrayList();
		lookups.addAll(new Lookup());
		// List<Lookup> lookups = new ArrayList<Lookup>();
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

	public ObservableList<Lookup> getLookup(String tableName, String columnName, int forginKeyId) {
		ObservableList<Lookup> lookups = FXCollections.observableArrayList();
		lookups.addAll(new Lookup());
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con
					.prepareStatement(SqlQuery.getLookupQueryName(tableName, columnName));
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
	
	public ObservableList<Lookup> getCareerLookup(String tableName, String columnName, int forginKeyId,String col2,int primarykey) {
		ObservableList<Lookup> lookups = FXCollections.observableArrayList();
		lookups.addAll(new Lookup());
		Connection con = DBConnection.getDB().getConnection();
		try {

			PreparedStatement preparedStatement = con
					.prepareStatement(SqlQuery.getLookupQueryName2(tableName, columnName , col2));
			preparedStatement.setInt(1, forginKeyId);
			preparedStatement.setInt(2, primarykey);
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

	/*
	 * public List<Lookup> getLookup(String tableName) { List<Lookup> lookups = new
	 * ArrayList<Lookup>(); Connection con = DBConnection.getDB().getConnection();
	 * try {
	 * 
	 * PreparedStatement preparedStatement =
	 * con.prepareStatement(SqlQuery.getLookupQueryName(tableName)); ResultSet
	 * resultSet = preparedStatement.executeQuery(); while (resultSet.next()) {
	 * Lookup lookup = new Lookup(); int id =
	 * resultSet.getInt(ColumnName.LOOKUP_ID); String name =
	 * resultSet.getString(ColumnName.LOOKUP_NAME); lookup.setId(id);
	 * lookup.setName(name); lookups.add(lookup); } } catch (SQLException e) {
	 * e.printStackTrace(); } return lookups; }
	 */

	/*
	 * public List<Lookup> getLookup(String tableName, String columnName, int
	 * forginKeyId) { List<Lookup> lookups = new ArrayList<Lookup>(); Connection con
	 * = DBConnection.getDB().getConnection(); try {
	 * 
	 * PreparedStatement preparedStatement = con
	 * .prepareStatement(SqlQuery.getLookupQueryName(tableName, columnName));
	 * preparedStatement.setInt(1, forginKeyId); ResultSet resultSet =
	 * preparedStatement.executeQuery(); while (resultSet.next()) { Lookup lookup =
	 * new Lookup(); int id = resultSet.getInt(ColumnName.LOOKUP_ID); String name =
	 * resultSet.getString(ColumnName.LOOKUP_NAME); lookup.setId(id);
	 * lookup.setName(name); lookups.add(lookup); } } catch (SQLException e) {
	 * e.printStackTrace(); } return lookups; }
	 */

}
