package com.tam.utility.Support;

public interface ISFDCSales {

    public void convertLead();
    public void switchApp(String appName);
    public void sfdcSearch(String searchKey);
    public void sfdcSetupSearch(String searchKey);
    public void goToSetup();
    public void openNewRecordCreationPage(String objectName);
    public void verifyRelatedListExists(String listName);
    public void verifyFieldLabel(String label);
    public void enterFieldValue(String fieldName,String value);
    public void selectFromPicklist(String picklistName,String value);
    public void saveRecord();
    public void clickSFDCButton(String buttonName);
    public void saveRecordAndContinue();
    public void editRecord();
    public void goToUserDetailsPage(String username);
    public void goToUserPermissionSetPage(String username);
    public void selectFromPicklist(String value);
    public void lookUpValue(String value);
    public void checkBox(String value);

    default void loginAsAnotherUser(String username){
        goToSetup();
        sfdcSearch(username);
        clickSFDCButton("Login");
    }
}
