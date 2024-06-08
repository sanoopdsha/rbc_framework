package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;




    @BeforeTest
    public void beforeTestMethod(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester","Sanoop Sha");
 
    }



    @BeforeMethod
    @Parameters(value={"browserName"}) //we will fetch the browser name from testng.xml
    public void beforeMethodMethod(String browserName, Method testMethod) throws MalformedURLException, URISyntaxException {
        logger = extent.createTest(testMethod.getName());
        setupDriver(browserName);
       driver.manage().window().maximize();
        driver.get(Constants.url); // we are passing the url here. we will be using the utils package and creating an
        // interface(Constants) because all the datatypes we put in interface will be automatically public static and final.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }


    @AfterMethod
    public void afterMethodMethod(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        }
        else if(result.getStatus()==ITestResult.FAILURE){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,m);
        }
        else if(result.getStatus()==ITestResult.SKIP) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Skipped";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP, m);
        }
        driver.quit();

    }


    @AfterTest
    public void afterTestMethod(){
        extent.flush();

    }

    //Below code to be used when run locally
    public void setupDriver(String browserName) throws MalformedURLException {

        if (browserName.equalsIgnoreCase("chrome")) {

            // Set the path to the chromedriver executable
            System.setProperty("webdriver.chrome.driver", "C:/Java and Selenium Workplace/rbc_framework/binaries/chromedriver.exe");

            // Create a new instance of the Chrome driver
            driver = new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("firefox")){
            // Set the path to the geckodriver executable (Firefox driver)
            System.setProperty("webdriver.gecko.driver", "C:/Java and Selenium Workplace/rbc_framework/binaries/geckodriver.exe");

            // Create a new instance of the Firefox driver
            driver = new FirefoxDriver();


        }else{
            // Set the path to the chromedriver executable
            System.setProperty("webdriver.chrome.driver", "C:/Java and Selenium Workplace/rbc_framework/binaries/chromedriver.exe");

            // Create a new instance of the Chrome driver
            driver = new ChromeDriver();
        }
    }




        }


