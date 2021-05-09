package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class FlipkartTests {
	WebDriver driver;

	@BeforeMethod
	public void before(ITestContext context) {
		DriverFactory driverFactory = new DriverFactory();
		driver = driverFactory.createDriver();
		driver.get("http://www.flipkart.com");
		context.setAttribute("driver", driver);
	}

	@Test
	public void flipkartValidInputTest() throws IOException {

		ScreenshotUtils su = new ScreenshotUtils();

		FlipkartHomePage homePage = new FlipkartHomePage(driver);
		homePage.searchForTheProduct("mobiles");
		ExtentTestManager.getTest().log(Status.INFO, "Entering The Product To Search Is Completed");

		FlipkartProductsPage productsPage = new FlipkartProductsPage(driver);
		productsPage.enterMinimumPriceAndMaximumprice("10000", "50000");
		ExtentTestManager.getTest().log(Status.INFO, "Entering MinimumPrice And MaximumPrice Is Completed");

		productsPage.enterTheRamSize("6 GB & Above");
		ExtentTestManager.getTest().log(Status.INFO, " Entering Ram Size Is Completed");

		productsPage.checkFlipkartAssuredCheckbox();
		ExtentTestManager.getTest().log(Status.INFO, "Checking Flipkart Assured Checkbox Is Completed");

		productsPage.enterStarRating("4");
		ExtentTestManager.getTest().log(Status.INFO, "Entering Star Rating Is Completd");

		try {

//			System.out.println(productsPage.searchResult());
			String searchResult = productsPage.searchResult();

			Assert.assertEquals(searchResult, "Showing 1 – 24 of 689 results for \"mobiles\"");

			ExtentTestManager.getTest().log(Status.PASS, "Search Result Matched", MediaEntityBuilder
					.createScreenCaptureFromPath(su.takeScreenshot(driver, "flipkartValidInputTest")).build());

		} catch (Throwable t) {

			ExtentTestManager.getTest().log(Status.FAIL, "Search Result Did Not Match", MediaEntityBuilder
					.createScreenCaptureFromPath(su.takeScreenshot(driver, "flipkartValidInputTest")).build());

			throw new RuntimeException(t);
		}

	}

	@AfterMethod
	public void quit() {
		DriverFactory driverFactory = new DriverFactory();
		driverFactory.quitDriver(driver);
	}
}
