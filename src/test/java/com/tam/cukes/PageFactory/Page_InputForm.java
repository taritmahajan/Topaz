package com.tam.cukes.PageFactory;

import com.tam.utility.FileUtil.ExcelManager;
import com.tam.utility.Support.Base;
import com.tam.utility.Support.DriverManager;
import com.tam.utility.Support.SFDC_Functions;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Page_InputForm extends Base {

    public Page_InputForm(){
        PageFactory.initElements(DriverManager.driver,this);
    }

    public void createOppty(String dataSetName) throws IOException {
        ExcelManager opptyData = new ExcelManager("Opportunity",dataSetName);
        SFDC_Functions sfdc_functions = new SFDC_Functions();
        sfdc_functions.enterFieldValue("First Name",opptyData.getDataByColumnName("firstname"));
        sfdc_functions.enterFieldValue("Last Name",opptyData.getDataByColumnName("lastname"));
        sfdc_functions.enterFieldValue("E-Mail",opptyData.getDataByColumnName("email"));
        sfdc_functions.enterFieldValue("Address",opptyData.getDataByColumnName("address"));
        sfdc_functions.enterFieldValue("City",opptyData.getDataByColumnName("city"));
        //sfdc_functions.enterFieldValue("State",opptyData.getDataByColumnName("state"));
        sfdc_functions.enterFieldValue("Phone #",opptyData.getDataByColumnName("phone"));
        sfdc_functions.enterFieldValue("Zip Code",opptyData.getDataByColumnName("zipcode"));
        sfdc_functions.enterFieldValue("Website or domain name",opptyData.getDataByColumnName("website"));
        //sfdc_functions.enterFieldValue("Zip Code",opptyData.getDataByColumnName("firstname"));
    }
}
