package Steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.java.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class Hooks {
    @Before
    public void beforestep(){
        System.out.println("--------celal------------");
    }
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    WebDriver driver;


    @BeforeSuite
    public void setUp() throws Exception{
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent= new ExtentReports();
        extent.attachReporter(htmlReporter);
        driver = new ChromeDriver();

    }

    @Test
    public void test1() throws IOException {
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        driver.get("http://www.google.com");
        test.pass("google a giris yapildi");
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
    }

    @After
    public void tearDown(){
        extent.flush();
        driver.quit();
    }
}
