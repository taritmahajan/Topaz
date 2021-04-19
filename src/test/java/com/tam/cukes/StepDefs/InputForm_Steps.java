package com.tam.cukes.StepDefs;

import com.aventstack.extentreports.Status;
import com.tam.cukes.PageFactory.Page_Home;
import com.tam.cukes.PageFactory.Page_InputForm;
import com.tam.utility.FileUtil.ReadJson;
import com.tam.utility.Support.DriverManager;
import com.tam.utility.Support.ExtentManager;
import com.tam.utility.Support.SFDC_Functions;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class InputForm_Steps {

    Page_Home page_home;
    Page_InputForm page_inputForm;

    @Given("navigate to input forms submit page")
    public void navigate_to_input_forms_submit_page() {
        page_home = new Page_Home();
        page_home.navigateToInputSubmitPage();
        ExtentManager.test.log(Status.PASS,"navigate to input form step def completed");
    }

    @Given("fill the user form")
    public void fill_the_form() throws IOException {
        SFDC_Functions sfdc_functions = new SFDC_Functions();
        ReadJson readJson = new ReadJson("Opportunity");
        page_inputForm = new Page_InputForm();
        page_inputForm.createOppty("TC 002");
        ExtentManager.test.log(Status.PASS,"filled the user form");
    }


}
