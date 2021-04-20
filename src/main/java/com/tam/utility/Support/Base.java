package com.tam.utility.Support;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

public class Base {

     public static String screenShotPath = System.getProperty("user.dir") +"\\test-output\\screenshots\\";
     public  HashMap<String,String> screenShotMap= new HashMap<String,String>();


    public void mouseOver(WebElement object,String objectName){
        try {
            Actions action = new Actions(DriverManager.driver);
            action.moveToElement(object).build().perform();
            ExtentManager.test.log(Status.PASS,"Hovered at " + objectName);
        }catch (Exception e){
            ExtentManager.test.log(Status.FAIL,"Failed to hover at " + objectName);
            ExtentManager.test.log(Status.FAIL,e.getMessage());
            ExtentManager.addScreenshotToReport("mouseOverFailed");
        }
    }

    public void click(WebElement object,String objectName){
        try {
            object.click();
            ExtentManager.test.log(Status.PASS,"Clicked at " + objectName);
        }catch (Exception e){
            ExtentManager.test.log(Status.FAIL,"Failed to click at " + objectName);
            ExtentManager.test.log(Status.FAIL,e.getMessage());
            ExtentManager.addScreenshotToReport("clickFailed");
        }
    }

    public void setText(WebElement object,String objectName,String text){
        try {
            object.sendKeys(text);
            ExtentManager.test.log(Status.PASS,"Entered text -- " + text + " -- in -- " + objectName);
        }catch (Exception e){
            ExtentManager.test.log(Status.FAIL,"Failed to enter text in " + objectName);
            ExtentManager.test.log(Status.FAIL,e.getMessage());
            ExtentManager.addScreenshotToReport("setTextFailed");
        }
    }

    public boolean isElementDisplayed(WebElement object){
        try{
            object.getSize();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void verifyElementExistsOnPage(WebElement object,String objectName){
        try{
            object.getSize();
            ExtentManager.test.log(Status.PASS,objectName + "  exists on page");
        }catch (NoSuchElementException e){
            ExtentManager.test.log(Status.FAIL,objectName + "  doesn't exists on page");
            ExtentManager.addScreenshotToReport("elementExistsFailed");
        }
    }

    public void captureScreenShot(String name){
        //take screenshot
        File file = ((TakesScreenshot) DriverManager.driver).getScreenshotAs(OutputType.FILE);
        String ssName = name + "_" + ".png";
        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(file,
                    new File(screenShotPath+ssName));
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String destination = screenShotPath + ssName;
        screenShotMap.put(name,destination);
    }

    public static String getTimeStamp(){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        return df.format(dateobj).replace("/","").replace(":","");
    }

}
