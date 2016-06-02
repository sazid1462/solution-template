package com.tigerit.exam;


import static com.tigerit.exam.IO.*;
import static com.tigerit.exam.utils.IOHelper.*;

import java.util.ArrayList;

import com.tigerit.exam.utils.Query;
import com.tigerit.exam.utils.QueryProcessor;
import com.tigerit.exam.utils.TestCase;

/**
 * @author Sazedul Islam
 *  
 * The application's execution points start from inside run method.
 */
public class Solution implements Runnable {
    @Override
    public void run() {
    	// Take the number of testCases as input
        int tCase = readLineAsInteger();
        // process each test case
        for (int cas=1; cas<=tCase; cas++) {
        	// read a test case
        	TestCase testCase = readTestCase();
        	System.out.println("Test: "+cas);
        	// read and execute the queries
        	readAndExecuteQueries(testCase);
        }
    }
    /**
     * This method will process the testCase and print the solution
     * @param testCase Object of the TestCase class
     */
    private void readAndExecuteQueries(TestCase testCase) {
    	// take number of query as input
    	int numQuery = readLineAsInteger();
    	// read each query as input and process the query
    	for (int q=0; q<numQuery; q++) {
    		Query query = readQuery();
    		QueryProcessor qProcessor = new QueryProcessor();
    		
    		qProcessor.executeQuery(testCase, query);
    		
    		ArrayList<String> resCol = qProcessor.getSelectedColumns();
    		for (int i=0; i<resCol.size(); i++) {
    			if (i > 0) System.out.print(" ");
    			System.out.print(resCol.get(i));
    		}
    		System.out.println();
    		ArrayList<ArrayList<Integer>> res = qProcessor.getResult();
    		for (int i=0; i<res.size(); i++) {
    			for (int j=0; j<res.get(i).size(); j++) {
    				if (j > 0) System.out.print(" ");
    				System.out.print(res.get(i).get(j));
    			}
    			System.out.println();
    		}
    		System.out.println();
    	}
	}
    
}
