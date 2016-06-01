package com.tigerit.exam.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Query {
	private ArrayList<String> selectedRows;
	private HashMap<String, String> tableNames;
	private String col1, col2;
	/**
	 * @return the selectedRows
	 */
	public ArrayList<String> getSelectedRows() {
		return selectedRows;
	}
	/**
	 * @param selectedRows the selectedRows to set
	 */
	public void setSelectedRows(ArrayList<String> selectedRows) {
		this.selectedRows = selectedRows;
	}
	/**
	 * @return the tableNames
	 */
	public HashMap<String, String> getTableNames() {
		return tableNames;
	}
	/**
	 * @param tableNames the tableNames to set
	 */
	public void setTableNames(HashMap<String, String> tableNames) {
		this.tableNames = tableNames;
	}
	/**
	 * @return the longTableName of the given shortTableName
	 */
	public String getLongTableName(String shortName) {
		return tableNames.get(shortName);
	}
	/**
	 * @param tableNames the tableNames to set
	 */
	public void mapTableNames(String shortName, String longName) {
		this.tableNames.put(shortName, longName);
	}
	/**
	 * @return the col1
	 */
	public String getCol1() {
		return col1;
	}
	/**
	 * @param col1 the col1 to set
	 */
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	/**
	 * @return the col2
	 */
	public String getCol2() {
		return col2;
	}
	/**
	 * @param col2 the col2 to set
	 */
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	
	
}
