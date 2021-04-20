package com.tam.cukes.StepDefs;

import com.aventstack.extentreports.Status;
import com.tam.utility.Support.Base;
import com.tam.utility.Support.DriverManager;
import com.tam.utility.Support.ExtentManager;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class Common_Steps extends Base {

    @Given("navigate to home page")
    public void navigate_to_home_page() {
        DriverManager.driver.get(DriverManager.envProp.getPropValue("url"));
        ExtentManager.test.log(Status.PASS,"navigate to home page");
    }

    @Given("verify if title contains {string}")
    public void verify_title_contains(String partOfTitle) {
        if(DriverManager.driver.getTitle().contains(partOfTitle)){
            ExtentManager.test.log(Status.PASS,"Page title contains  " + partOfTitle);
        }else{
            ExtentManager.test.log(Status.FAIL,"Page title does not contain  " + partOfTitle
            + "  actual title is  " +  DriverManager.driver.getTitle());
           ExtentManager.addScreenshotToReport("titleMatchFailed");
        }
    }

}
