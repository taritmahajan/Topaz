package com.tam.utility.Support;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitUtil extends Base{

    WebDriverWait wait;
    Wait<WebDriver> fWait;

    private WebDriverWait explicitWait(long timeout){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(timeout));
        return wait;
    }

    public void implicitWait(long timeout){
        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    private Wait<WebDriver> fluentWait(long timeout,long pollingtimeout){
        fWait = new FluentWait<>(DriverManager.driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingtimeout)).ignoring(NoSuchElementException.class);

        return fWait;
    }

    public void fluentClick(WebElement el,long timeout,long pollingtime){
        WebElement element = fluentWait(timeout,pollingtime).until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    WebElement element = el;
                    return element;
                }
            });
        element.click();
    }

    public void waitForVisibility(WebElement el,long timeout){
        try {
            explicitWait(timeout).until(ExpectedConditions.visibilityOf(el));
        }catch (TimeoutException e){
            ExtentManager.test.log(Status.FAIL,"waitForVisibility, explicit wait timeout!!!");
        }
    }



    public void waitForClickable(WebElement el,long timeout){
        try {
            explicitWait(timeout).until(ExpectedConditions.elementToBeClickable(el));
        }catch (StaleElementReferenceException e){
            ExtentManager.test.log(Status.FAIL,"waitForClickable, explicit wait timeout!!!");
        }
    }

    public void waitForInvisibility(WebElement el,long timeout){
        try {
            explicitWait(timeout).until(ExpectedConditions.invisibilityOf(el));
        }catch (Exception e){
            ExtentManager.test.log(Status.FAIL,"waitForInvisibility, explicit wait timeout!!!");
        }
    }


}
