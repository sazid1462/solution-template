package com.tigerit.exam;

import static com.tigerit.exam.IO.readLineAsInteger;
import static com.tigerit.exam.IO.readTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.tigerit.exam.utils.Query;
import com.tigerit.exam.utils.Table;
import com.tigerit.exam.utils.TestCase;

/**
 * @author Faisal Ahmed
 * This is a helper class for input/output in java.
 * Your don't need to use it if you want. This is
 * just for your convenience. Don't use Scanner or
 * System.console() stuff for input.
 */
public class IO {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private IO() {}

    public static String readLine() {
        String value;
        try {
            value = reader.readLine();
        } catch (IOException ex) {
            value = null;
        }
        return value;
    }

    public static Integer readLineAsInteger() {
        return Integer.parseInt(readLine());
    }
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
    
    public static void printLine(Object value) {
        System.out.println(value);
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
    	
    	
    	return query;
    }
}
