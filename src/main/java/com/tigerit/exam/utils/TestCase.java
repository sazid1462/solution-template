package com.tigerit.exam.utils;

import java.util.HashMap;

public class TestCase {
	private int numTable;
	private HashMap<String, Table> tables;
	/**
	 * @return the numTable
	 */
	public int getNumTable() {
		return numTable;
	}
	/**
	 * @param numTable the numTable to set
	 */
	public void setNumTable(int numTable) {
		this.numTable = numTable;
	}
	/**
	 * @return the tables
	 */
	public HashMap<String, Table> getTables() {
		return tables;
	}
	/**
	 * @param tables the tables to set
	 */
	public void setTables(HashMap<String, Table> tables) {
		this.tables = tables;
	}
	/**
	 * @return the table named [tableName]
	 */
	public Table getTables(String tableName) {
		return tables.get(tableName);
	}
	/**
	 * @param tables the tables to set
	 */
	public void putTable(Table table) {
		if (tables == null) tables = new HashMap<String, Table>();
		this.tables.put(table.getName(), table);
	}
	
}
