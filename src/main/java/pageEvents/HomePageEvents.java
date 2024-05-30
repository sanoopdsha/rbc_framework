package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.utils.ElementFetch;
import test.java.BaseTest;

public class HomePageEvents {

    public LoginPageEvents clickOnSignInButton() {
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Clicking sign in button");
        elementFetch.getWebElement("XPATH", HomePageElements.signInButton).click();
        return new LoginPageEvents();

    }}
