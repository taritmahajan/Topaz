package com.tam.cukes.StepDefs;


import com.tam.utility.Support.DriverManager;
import com.tam.utility.Support.ExtentManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void startScenario(Scenario scenario){

        ExtentManager.createTest(scenario.getName().replace(" ",""));
    }

    @After
    public void endScenario(Scenario scenario){

//        try {
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//                if (scenario.isFailed()) {
//            scenario.log(screenshotName + "  Step Failed");
//            TakesScreenshot ts = (TakesScreenshot) DriverManager.driver;
//            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", screenshotName);
//              }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
