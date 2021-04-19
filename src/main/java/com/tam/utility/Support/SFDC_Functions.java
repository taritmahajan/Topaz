package com.tam.utility.Support;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class SFDC_Functions extends Base implements ISFDCSales{

    String inputFieldXpathPartOne = "//label[text()='";
    String inputFieldXpathLast = "']/..//input";

    @Override
    public void convertLead() {

    }

    @Override
    public void switchApp(String appName) {

    }

    @Override
    public void sfdcSearch(String searchKey) {

    }

    @Override
    public void sfdcSetupSearch(String searchKey) {

    }

    @Override
    public void goToSetup() {

    }

    @Override
    public void openNewRecordCreationPage(String objectName) {

    }

    @Override
    public void verifyRelatedListExists(String listName) {

    }

    @Override
    public void verifyFieldLabel(String label) {

    }

    @Override
    public void enterFieldValue(String fieldName, String value) {
        try {
            setText(DriverManager.driver.findElement(By.xpath(inputFieldXpathPartOne + fieldName + inputFieldXpathLast)),
                    fieldName, value);
        }catch (Exception e){
            ExtentManager.test.log(Status.FAIL,"Failed to enter text in " + fieldName);
            ExtentManager.test.log(Status.FAIL,e.getMessage());
            captureScreenShot(fieldName+"_setTextFailed");
            ExtentManager.test.addScreenCaptureFromPath(screenShotMap.get(fieldName+"_setTextFailed"));
        }
    }

    @Override
    public void selectFromPicklist(String picklistName, String value) {

    }

    @Override
    public void saveRecord() {

    }

    @Override
    public void clickSFDCButton(String buttonName) {

    }

    @Override
    public void saveRecordAndContinue() {

    }

    @Override
    public void editRecord() {

    }

    @Override
    public void goToUserDetailsPage(String username) {

    }

    @Override
    public void goToUserPermissionSetPage(String username) {

    }

    @Override
    public void selectFromPicklist(String value) {

    }

    @Override
    public void lookUpValue(String value) {

    }

    @Override
    public void checkBox(String value) {

    }
}
