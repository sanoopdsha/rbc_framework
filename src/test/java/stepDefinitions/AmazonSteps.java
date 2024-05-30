package test.java.stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import test.java.BaseTest;


public class AmazonSteps extends BaseTest{

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Java and Selenium Workplace/rbc_framework/binaries/chromedriver.exe");

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
    }

    @When("User opens Amazon URL")
    public void user_opens_amazon_url() {

        driver.get("https://www.amazon.in");

    }

    @Then("Verify logo present in Amazon homepage")
    public void verify_logo_present_in_amazon_homepage() {
        boolean status = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
        Assert.assertEquals(true,status);
    }

    @Then("Close browser")
    public void close_browser() {
        driver.quit();
    }

}
