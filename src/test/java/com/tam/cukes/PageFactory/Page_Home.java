package com.tam.cukes.PageFactory;

import com.aventstack.extentreports.Status;
import com.tam.utility.Support.Base;
import com.tam.utility.Support.DriverManager;
import com.tam.utility.Support.ExtentManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Home extends Base {

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(text(),'Input Forms')]")
    public WebElement INPUT_FORMS;

    @FindBy(xpath = "(//a[text()='Input Form Submit'])[1]")
    public WebElement INPUT_FORMS_SUBMIT;

    public Page_Home() {
        PageFactory.initElements(DriverManager.driver,this);
    }

    public void navigateToInputSubmitPage(){
        click(INPUT_FORMS,"Input Forms");
        click(INPUT_FORMS_SUBMIT,"Input Forms submit");
    }
}
