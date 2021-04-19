package com.tam.utility.Support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    public static ExtentReports report;
    public static ExtentTest test;
    public static ExtentSparkReporter sparkReporter;

    public ExtentManager(String extentReportName){
        this.report = new ExtentReports();
        this.sparkReporter = new ExtentSparkReporter("test-output/" + extentReportName+".html");
        this.report.attachReporter(sparkReporter);
        sparkReporter.config(
                ExtentSparkReporterConfig.builder()
                        .theme(Theme.DARK)
                        .documentTitle("MyReport")
                        .build());

    }

   public static void createTest(String testName){
        test = report.createTest(testName);
   }

   public static void generateReport(){
        report.flush();
   }
    
}
