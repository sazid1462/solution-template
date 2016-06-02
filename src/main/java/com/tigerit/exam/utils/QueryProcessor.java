package com.tigerit.exam.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class QueryProcessor {
	private ArrayList<String> selectedColumns;
	private HashMap<String, Table> columnTableMap;
	private HashMap<String, String> tableNames;
	private ArrayList<ArrayList<Integer>> result;
	private String col1, col2;
	
	/**
	 * @return the selectedColumns
	 */
	public ArrayList<String> getSelectedColumns() {
		return selectedColumns;
	}

	/**
	 * @param selectedColumns the selectedColumns to set
	 */
	public void setSelectedColumns(ArrayList<String> selectedColumns) {
		this.selectedColumns = selectedColumns;
	}

	/**
	 * @return the result
	 */
	public ArrayList<ArrayList<Integer>> getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(ArrayList<ArrayList<Integer>> result) {
		this.result = result;
	}
	
	public void executeQuery(TestCase testCase, Query query) {
		tableNames = new HashMap<>();
		for (int i=0; i<query.getTableLongNames().length; i++) {
			tableNames.put(query.getTableShortNames()[i], query.getTableLongNames()[i]);
		}
		
		Table table1 = testCase.getTable(query.getTableLongNames()[0]);
		Table table2 = testCase.getTable(query.getTableLongNames()[1]);
		selectedColumns = new ArrayList<>(table1.getColumns().size() + table2.getColumns().size());
		columnTableMap = new HashMap<>();
		
		if (query.getColumns().equalsIgnoreCase("*")) {			
			for (String col : table1.getColumns()) {
				selectedColumns.add(col);
				columnTableMap.put(col, table1);
			}
			for (String col : table2.getColumns()) {
				selectedColumns.add(col);
				columnTableMap.put(col, table2);
			}
		} else {
			StringTokenizer tok = new StringTokenizer(query.getColumns(), ",");
			
			while (tok.hasMoreTokens()) {
				String table_column = tok.nextToken();
				StringTokenizer tokColumn = new StringTokenizer(table_column, ".");
				
				if (tokColumn.countTokens() > 1) {
					String tableName = tokColumn.nextToken();
					String column = tokColumn.nextToken();
					
					selectedColumns.add(column);
					columnTableMap.put(column, testCase.getTable(tableNames.get(tableName)));
				}
			}
		}
		
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
