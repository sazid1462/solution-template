package com.tigerit.exam;


import static com.tigerit.exam.IO.*;

import com.tigerit.exam.utils.Query;
import com.tigerit.exam.utils.TestCase;

/**
 * All of your application logic should be placed inside this class.
 * Remember we will load your application from our custom container.
 * You may add private method inside this class but, make sure your
 * application's execution points start from inside run method.
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
        	// read and execute the queries
        	readAndExecuteQueries(testCase);
        }
    }
    
    private void readAndExecuteQueries(TestCase testCase) {
    	// take number of query as input
    	int numQuery = readLineAsInteger();
    	// read each query as input and process the query
    	for (int i=0; i<numQuery; i++) {
    		Query query = readQuery();
    		executeQuery(testCase, query);
    	}
	}

	private void executeQuery(TestCase testCase, Query query) {
		// TODO Auto-generated method stub
		
	}
}
