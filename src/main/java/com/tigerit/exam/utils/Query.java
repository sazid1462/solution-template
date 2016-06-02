package com.tigerit.exam.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Query {
	private String columns;
	private String tableShortNames[], tableLongNames[];
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
