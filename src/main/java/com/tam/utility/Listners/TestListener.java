package com.tam.utility.Listners;


import com.tam.utility.Support.DriverManager;
import com.tam.utility.Support.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {


    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.generateReport();
        DriverManager.tearDown();
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentManager extentManager = new ExtentManager(context.getCurrentXmlTest().getName());
        DriverManager.setUp();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult result) {
        //needed only when running testng tests , not cukes tests
       //ExtentManager.test = ExtentManager.report.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
    }

}
