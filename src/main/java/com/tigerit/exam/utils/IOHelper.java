package com.tigerit.exam.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import static com.tigerit.exam.IO.*;

public class IOHelper {
	// reads a line then tokenize it with ' ' and returns them as an array
    private static int[] readLineAsMultipleInteger() {
    	String str = readLine();
    	StringTokenizer tok = new StringTokenizer(str, " ");
    	
    	int retArr[] = new int[tok.countTokens()];
    	int idx = 0;
    	while(tok.hasMoreTokens()) {
    		retArr[idx++] = Integer.parseInt(tok.nextToken());
    	}
		return retArr;
	}
    
    // Reader method of a test case
    public static TestCase readTestCase() {
    	TestCase testCase = new TestCase();
    	// take number of table as input
    	int numTables = readLineAsInteger();
    	testCase.setNumTable(numTables);
    	// take each table as input
    	for (int i=0; i<numTables; i++) {
    		Table table = readTable();
    		testCase.putTable(table);
    		
//    		table.print();
    	}
    	return testCase;
    }
    
    public static Table readTable() {
    	Table table = new Table();
    	// take the table name as input
    	String tableName = readLine();
    	table.setName(tableName);
    	// here should be 2 space separated integers. first 'nC' and second is 'nD'
    	int intArr[] = readLineAsMultipleInteger();
    	// read every column name of the table
    	ArrayList<String> columns = new ArrayList<>(intArr[0]);
    	
		String s = readLine();
		StringTokenizer tok = new StringTokenizer(s, " ");
		while (tok.hasMoreTokens()) {
			columns.add(tok.nextToken());
		}
   
    	table.setColumns(columns);
    	// read each and every rows/records of the table
    	HashMap<String, ArrayList<Integer>> values = new HashMap<>(intArr[1]);
    	for (int i=0; i<intArr[1]; i++)
    	{
    		int row[] = readLineAsMultipleInteger();
    		for (int j=0; j<intArr[0]; j++) {
    			ArrayList<Integer> valuesOf;
    			if (values.containsKey(columns.get(j))) {
    				valuesOf = values.get(columns.get(j));
    			} else {
    				valuesOf = new ArrayList<Integer>();
    				values.put(columns.get(j), valuesOf);
    			}
    			valuesOf.add(row[j]);
    		}
    	}
    	table.setValues(values);
    	
    	return table;
    }
    
    public static Query readQuery() {
    	Query query = new Query();
    	
    	String raw = readLine();
    	StringTokenizer tok = new StringTokenizer(raw, " ,");
    	
    	String rawColumns = "", rawCondition = "";
    	boolean f = false;
    	
    	while (tok.hasMoreTokens()) {
    		String s = tok.nextToken();
    		if (s.equalsIgnoreCase("select") && f==false) {
    			f = true;
    		}
    		else if (s.equalsIgnoreCase("*")) {
    			rawColumns = "*";
    		} else if (f==true) {
    			rawColumns = rawColumns+","+s;
    		}
    	}
    	query.setColumns(rawColumns);
    	
    	raw = readLine();
    	tok = new StringTokenizer(raw, " ,");
    	String table1Long = null, table1Short;
    	if (tok.hasMoreTokens()) tok.nextToken();
    	if (tok.hasMoreTokens()) table1Long = tok.nextToken();
    	if (tok.hasMoreTokens()) table1Short = tok.nextToken();
    	else table1Short = table1Long;
//    	query.mapTableNames(table1Short, table1Long);
    	
    	raw = readLine();
    	tok = new StringTokenizer(raw, " ,");    	
    	String table2Long = null, table2Short;
    	if (tok.hasMoreTokens()) tok.nextToken();
    	if (tok.hasMoreTokens()) table2Long = tok.nextToken();
    	if (tok.hasMoreTokens()) table2Short = tok.nextToken();
    	else table2Short = table2Long;
//    	query.mapTableNames(table2Short, table2Long);
    	
    	query.setTableShortNames(table1Short, table2Short);
    	query.setTableLongNames(table1Long, table2Long);
    	
    	raw = readLine();
    	tok = new StringTokenizer(raw, " ");
    	if (tok.hasMoreTokens()) tok.nextToken();
    	if (tok.hasMoreTokens()) rawCondition += tok.nextToken();
    	if (tok.hasMoreTokens()) rawCondition += tok.nextToken();
    	if (tok.hasMoreTokens()) rawCondition += tok.nextToken();
    	
		query.setCondition(rawCondition);
    	
		// read the blank line
		raw = readLine();
		
    	return query;
    }
}
