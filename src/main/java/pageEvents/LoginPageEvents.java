package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.java.BaseTest;

public class  LoginPageEvents {

    public LoginPageEvents verifySignInTextDisplayed(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Verifying Sign in Text");
        String actualText = "Sign in";
        String expectedText = elementFetch.getWebElement("XPATH",LoginPageElements.signInText).getText();
        Assert.assertEquals(actualText,expectedText);
        System.out.println("Actual: " + actualText + "\nExpected: " + expectedText);
        return this;
    }


    public LoginPageEvents enterEmailId() throws InterruptedException {
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Entering email id");
        WebElement emailInput = elementFetch.getWebElement("XPATH", LoginPageElements.emailAddress);
        emailInput.sendKeys("dsanoopsha24@gmail.com");
        Thread.sleep(3000);
        return new LoginPageEvents();
    }




}
