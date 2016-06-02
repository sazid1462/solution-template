package com.tigerit.exam.utils;

/**
 * @author Sazedul Islam
 * 
 * A class represents the query statement of the format specified 
 * in the problem statement
 */
public class Query {
	// Name of the columns to be printed. Multiple columns should be space separated
	private String columns;
	// Table short names and long names are stored respectively
	private String tableShortNames[], tableLongNames[];
	// Condition on which the operation should be done
	private String condition;
	
	/**
	 * @return the columns
	 */
	public String getColumns() {
		return columns;
	}
	/**
	 * @param columns the columns to set
	 */
	public void setColumns(String columns) {
		this.columns = columns;
	}
	/**
	 * @return the tableShortNames
	 */
	public String[] getTableShortNames() {
		return tableShortNames;
	}
	/**
	 * @param tableShortNames the tableShortNames to set
	 */
	public void setTableShortNames(String... tableShortNames) {
		this.tableShortNames = tableShortNames;
	}
	/**
	 * @return the tableLongNames
	 */
	public String[] getTableLongNames() {
		return tableLongNames;
	}
	/**
	 * @param tableLongNames the tableLongNames to set
	 */
	public void setTableLongNames(String... tableLongNames) {
		this.tableLongNames = tableLongNames;
	}
	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
		
}
