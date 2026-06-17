package base_folder;

import Util.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setupReport() {

        ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        spark.config().setReportName("API Automation Report");
        spark.config().setDocumentTitle("REST Assured Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeClass
    public void setup() {

        ConfigReader config = new ConfigReader();
        RestAssured.baseURI = config.getBaseURL();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();  // Report generate होईल
    }
}

