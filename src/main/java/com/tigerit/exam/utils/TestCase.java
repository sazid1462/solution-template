package com.tigerit.exam.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class TestCase {
	private int numTable;
	private HashMap<String, Table> tables;
	private int numQueries;
	private ArrayList<Query> queries;
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
	public void setTables(Table table) {
		this.tables.put(table.getName(), table);
	}
	/**
	 * @return the numQueries
	 */
	public int getNumQueries() {
		return numQueries;
	}
	/**
	 * @param numQueries the numQueries to set
	 */
	public void setNumQueries(int numQueries) {
		this.numQueries = numQueries;
	}
	/**
	 * @return the queries
	 */
	public ArrayList<Query> getQueries() {
		return queries;
	}
	/**
	 * @param queries the queries to set
	 */
	public void setQueries(ArrayList<Query> queries) {
		this.queries = queries;
	}
	
	
}
