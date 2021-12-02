package com.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerEx implements ITestListener {
	private Logger log = Logger.getLogger(ListenerEx.class);

	public void onTestStart(ITestResult result) {

		log.info("Test Case Started with name:- " + result);
	}
	public void onTestSuccess(ITestResult result) {
		log.info("Test Case Passed with name:- " + result);
	}

	public void onTestFailure(ITestResult result) {
		log.info("Test Case Failed with name:- "+result);	

	}

	public void onTestSkipped(ITestResult result) {
		log.info("Test Case Skipped with name:- "+result);	

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
