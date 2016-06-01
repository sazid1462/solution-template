package com.tigerit.exam.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {
	private String name;
	private ArrayList<String> columns;
	private HashMap<String, ArrayList<Integer>> rows;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the collumns
	 */
	public ArrayList<String> getColumns() {
		return columns;
	}
	/**
	 * @param collumns the columns to set
	 */
	public void setCollumns(ArrayList<String> columns) {
		this.columns = columns;
	}
	/**
	 * @return the rows
	 */
	public HashMap<String, ArrayList<Integer>> getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(HashMap<String, ArrayList<Integer>> rows) {
		this.rows = rows;
	}
	
	/**
	 * @return the values of the specified column
	 */
	public ArrayList<Integer> getValues(String column) {
		return rows.get(column);
	}
	/**
	 * @param values of the specified column to set
	 */
	public void setRows(String column, ArrayList<Integer> values) {
		this.rows.put(column, values);
	}
}
