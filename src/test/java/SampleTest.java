package test.java;

import main.java.pageEvents.HomePageEvents;

import main.java.pageEvents.LoginPageEvents;

import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test(description = "Check successful entry of email id")
    public void checkingSuccessfulLogin() throws InterruptedException {
        HomePageEvents homePageEvents = new HomePageEvents();
        homePageEvents
                .clickOnSignInButton();

        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents
                .verifySignInTextDisplayed()
                .enterEmailId();
    }

    @Test(description = "Check successful entry of email id")
    public void checkingSuccessfulLogin2() throws InterruptedException {
        HomePageEvents homePageEvents = new HomePageEvents();
        homePageEvents
                .clickOnSignInButton();

        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents
                .verifySignInTextDisplayed()
                .enterEmailId();
    }

}
