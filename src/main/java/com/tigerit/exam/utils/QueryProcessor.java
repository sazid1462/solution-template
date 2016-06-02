package com.tigerit.exam.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author Sazedul Islam
 * 
 * Query Processing and Executing class
 */
public class QueryProcessor {
	// Name of the columns to be printed. Multiple columns should be space separated
	private ArrayList<String> selectedColumns;
	// Maps the table from which the column is obtained
	private HashMap<String, Table> columnTableMap;
	// Maps the TableNames to their respective short versions
	private HashMap<String, String> tableNames;
	// Contains the result after the execution of the query
	private ArrayList<ArrayList<Integer>> result;
	// Contains two given columns on which the joining operation should be done
	private String col1, col2;
	
	/**
	 * Return value can be null if no query is executed
	 * @return the selectedColumns
	 */
	public ArrayList<String> getSelectedColumns() {
		return selectedColumns;
	}

	/**
	 * Return value can be null if no query is executed
	 * @return the result
	 */
	public ArrayList<ArrayList<Integer>> getResult() {
		return result;
	}
	
	/**
	 * Processes and executes query on the given test case scenario. Result of the query
	 * is in the results array. After executing the query results can be obtained by
	 * invoking getResult() method. Also the list of selected columns can also be obtained 
	 * by invoking getSelectedColumns() method
	 * 
	 * @param testCase An object of the TestCase
	 * @param query An object of the Query
	 */
	public void executeQuery(TestCase testCase, Query query) {
		// Mapping the TableNames to their respective short versions
		tableNames = new HashMap<>();
		for (int i=0; i<query.getTableLongNames().length; i++) {
			tableNames.put(query.getTableShortNames()[i], query.getTableLongNames()[i]);
		}
		
		Table table1 = testCase.getTable(query.getTableLongNames()[0]);
		Table table2 = testCase.getTable(query.getTableLongNames()[1]);
		selectedColumns = new ArrayList<>(table1.getColumns().size() + table2.getColumns().size());
		columnTableMap = new HashMap<>(); // maps the table from which the column is obtained
		
		// Populate the selectedColumns list
		if (query.getColumns().equalsIgnoreCase("*")) {	// All columns should be selected		
			for (String col : table1.getColumns()) {
				selectedColumns.add(col);
				columnTableMap.put(col, table1);
			}
			for (String col : table2.getColumns()) {
				selectedColumns.add(col);
				columnTableMap.put(col, table2);
			}
		} else { // Parse the given selected columns list
			StringTokenizer tok = new StringTokenizer(query.getColumns(), ",");
			
			while (tok.hasMoreTokens()) {
				String table_column = tok.nextToken();
				StringTokenizer tokColumn = new StringTokenizer(table_column, ".");
				
				if (tokColumn.countTokens() > 1) {
					String tableName = tokColumn.nextToken(); // may be short name or long/original name
					String column = tokColumn.nextToken();
					
					selectedColumns.add(column);
					columnTableMap.put(column, testCase.getTable(tableNames.get(tableName)));
				}
			}
		}
		
		// Get the first column of the joining condition
		StringTokenizer tok = new StringTokenizer(query.getCondition(), "=");
		if (tok.hasMoreTokens()) {
			String table_column = tok.nextToken();
			StringTokenizer tokColumn = new StringTokenizer(table_column, ".");
			
			if (tokColumn.countTokens() > 1) {
				String tableName = tokColumn.nextToken();
				String column = tokColumn.nextToken();
				
				col1 = column;
				columnTableMap.put(column, testCase.getTable(tableNames.get(tableName)));
			}
		}
		// Get the second column of the joining condition
		if (tok.hasMoreTokens()) {
			String table_column = tok.nextToken();
			StringTokenizer tokColumn = new StringTokenizer(table_column, ".");
			
			if (tokColumn.countTokens() > 1) {
				String tableName = tokColumn.nextToken();
				String column = tokColumn.nextToken();
				
				col2 = column;
				columnTableMap.put(column, testCase.getTable(tableNames.get(tableName)));
			}
		}
		// Obtain the result of the join operation
		result = new ArrayList<>(1000);
		ArrayList<Integer> columnTable1 = columnTableMap.get(col1).getValuesOf(col1);
		ArrayList<Integer> columnTable2 = columnTableMap.get(col2).getValuesOf(col2);
		for (int i=0; i<columnTable1.size(); i++) {
			for (int j=0; j<columnTable2.size(); j++) {
				int val1 = columnTable1.get(i);
				int val2 = columnTable2.get(j);
				if (val1 == val2) {
					ArrayList<Integer> resRow = new ArrayList<>(selectedColumns.size());
					for (String column : selectedColumns) {
						if (columnTableMap.get(column) == columnTableMap.get(col1)) 
							resRow.add(columnTableMap.get(column).getValuesOf(column).get(i));
						else 
							resRow.add(columnTableMap.get(column).getValuesOf(column).get(j));
					}
					result.add(resRow);
				}
			}
		}
	}
}
