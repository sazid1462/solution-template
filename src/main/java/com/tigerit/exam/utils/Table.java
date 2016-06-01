package com.tigerit.exam.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {
	private String name;
	private ArrayList<String> columns;
	private HashMap<String, ArrayList<Integer>> values;
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
	public void setColumns(ArrayList<String> columns) {
		this.columns = columns;
	}
	/**
	 * @return the rows
	 */
	public HashMap<String, ArrayList<Integer>> getValues() {
		return values;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setValues(HashMap<String, ArrayList<Integer>> rows) {
		this.values = rows;
	}
	
	/**
	 * @return the values of the specified column
	 */
	public ArrayList<Integer> getValuesOf(String column) {
		return values.get(column);
	}
	public void print() {
		System.out.println("############## Starts Table "+name+" #############");
		
		for (int i=0; i<columns.size(); i++) {
			System.out.print(columns.get(i)+"\t");
		}
		System.out.println();
		for (int i=0; i<values.size(); i++) {
			for (int j=0; j<columns.size(); j++) {
				System.out.print(values.get(columns.get(j)).get(i)+"\t");
			}
			System.out.println();
		}
		
		System.out.println("################### Ends Table ##################");
	}
	
}
