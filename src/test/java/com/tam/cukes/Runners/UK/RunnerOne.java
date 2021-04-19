package com.tam.cukes.Runners.UK;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//will run all feature files under UK folder.will create report for each feature.
// browser will open once for each feature and close after feature
@CucumberOptions(
        features="src/test/java/com/tam/cukes/Features/UK",
        glue={"com/tam/cukes/StepDefs"},
        //tags = "@Smoke",
        //plugin= {"json:target/cucumber-reports/CucumberTestReport.json",
          //      "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        //},
        monochrome=true
)
public class RunnerOne extends AbstractTestNGCucumberTests {


}
