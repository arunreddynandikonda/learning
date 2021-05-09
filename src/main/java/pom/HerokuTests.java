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

public class HerokuTests {

	WebDriver driver;

	@BeforeMethod
	public void before(ITestContext context) {
		DriverFactory df = new DriverFactory();
		driver = df.createDriver();
		driver.get("https://the-internet.herokuapp.com/");
		context.setAttribute("driver", driver);
	}

	@Test
	public void addRemoveElementsTest() throws IOException {
		ScreenshotUtils sc = new ScreenshotUtils();
		HerokuHomePage homepage = new HerokuHomePage(driver);
		homepage.clickOnAddRemoveElementsLink();
		ExtentTestManager.getTest().log(Status.INFO, "Clicking On Add Remove Link Button Completed");

		HerokuAddRemoveElements ar = new HerokuAddRemoveElements(driver);
		ar.clickOnAddElement();

		ExtentTestManager.getTest().log(Status.INFO, "Clicking On Add Element Button Completed");

		try {
			Assert.assertTrue(ar.isDeleteButtonPresent());
			ExtentTestManager.getTest().log(Status.PASS, "Delete Button Is Present", MediaEntityBuilder
					.createScreenCaptureFromPath(sc.takeScreenshot(driver, "addRemoveElementsTest")).build());
		} catch (Throwable t) {
			ExtentTestManager.getTest().log(Status.FAIL, "Delete Button Is Not Present", MediaEntityBuilder
					.createScreenCaptureFromPath(sc.takeScreenshot(driver, "addRemoveElementsTest")).build());
		}

		ar.clickOnDelete();
		ExtentTestManager.getTest().log(Status.INFO, "Clicking On Delete Button Completed");

		try {
			Assert.assertTrue(ar.isDeleteButtonPresent());
			ExtentTestManager.getTest().log(Status.PASS, "Delete Button Is Present", MediaEntityBuilder
					.createScreenCaptureFromPath(sc.takeScreenshot(driver, "addRemoveElementsTest")).build());
		} catch (Throwable t) {
			ExtentTestManager.getTest().log(Status.FAIL, "Delete Button Is Not Present", MediaEntityBuilder
					.createScreenCaptureFromPath(sc.takeScreenshot(driver, "addRemoveElementsTest")).build());
			throw new RuntimeException(t);
		}

		System.out.println("addRemoveElementsTest - Passed");
	}

//	@Test
//	public void checkBoxesTest() throws IOException {
//		try {
//			HerokuHomePage homepage = new HerokuHomePage(driver);
//			homepage.clickOnCheckBoxesLink();
//
//			HerokuCheckboxes cb = new HerokuCheckboxes(driver);
//			cb.checkCheckbox1();
//			Assert.assertTrue(cb.isCheckBox1Selected());
//
//			cb.checkCheckbox2();
//			Assert.assertTrue(cb.isCheckBox2Selected());
//
//			System.out.println("checkBoxesTest - Passed");
//		} catch (Throwable e) {
//			System.out.println("checkBoxesTest - Failed");
//			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			Date date = new Date();
//			File dest = new File("C:\\Users\\saith\\Desktop\\Screenshots\\checkBoxes" + date.getTime() + ".jpg");
//			FileUtils.copyFile(screenshotFile, dest);
//
//			throw new RuntimeException("checkBoxesTest - Failed");
//		}
//	}
//
//	@Test
//	public void dropdownTest() throws IOException {
//		try {
//			HerokuHomePage homepage = new HerokuHomePage(driver);
//			homepage.clickOnDropdownLink();
//
//			HerokuDropdown d = new HerokuDropdown(driver);
//			d.selectAnOptionFromDropdownList("Option 2");
//
//			Assert.assertEquals(d.optionSelected(), "Option 2");
//
//			System.out.println("dropdownTest - Passed");
//		} catch (Throwable e) {
//			System.out.println("dropdownTest - Failed");
//			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			Date date = new Date();
//			File dest = new File("C:\\Users\\saith\\Desktop\\Screenshots\\dropdown" + date.getTime() + ".jpg");
//			FileUtils.copyFile(screenshotFile, dest);
//
//			throw new RuntimeException("dropdownTest - Failed");
//		}
//	}
//
//	@Test
//	public void hoversTest() throws IOException {
//		try {
//			HerokuHomePage homepage = new HerokuHomePage(driver);
//			homepage.clickOnHoversLink();
//
//			HerokuHovers hh = new HerokuHovers(driver);
//			hh.mouseHoverOverImage1();
//			String userName1 = hh.getImage1UserName();
//			Assert.assertEquals(userName1, "name: user1");
//
//			hh.mouseHoverOverImage2();
//			String userName2 = hh.getImage2UserName();
//			Assert.assertEquals(userName2, "name: user2");
//
//			hh.mouseHoverOverImage3();
//			String userName3 = hh.getImage3UserName();
//			Assert.assertEquals(userName3, "name: user3");
//
//			System.out.println("hoversTest - Passed");
//		} catch (Throwable e) {
//			System.out.println("hoversTest - Failed");
//			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			Date date = new Date();
//			File dest = new File("C:\\Users\\saith\\Desktop\\Screenshots\\hovers" + date.getTime() + ".jpg");
//			FileUtils.copyFile(screenshotFile, dest);
//
//			throw new RuntimeException("hoversTest - Failed");
//		}
//	}
//
//	@Test
//	public void dynamicControlsTest() throws IOException {
//		try {
//			HerokuHomePage homepage = new HerokuHomePage(driver);
//			homepage.clickOnDynamicControlsLink();
//
//			HerokuDynamicControls dc = new HerokuDynamicControls(driver);
//			dc.checkCheckbox();
//			dc.clickOnRemoveButton();
//			dc.waitForAddButtonToDisplay();
//			Assert.assertFalse(dc.isCheckboxpresent());
//
//			dc.clickOnAddButton();
//			dc.waitForRemoveButtonToDisplay();
//			Assert.assertTrue(dc.isCheckboxpresent());
//
//			dc.clickOnEnableButton();
//			dc.waitForDisableButtonToDisplay();
//			Assert.assertTrue(dc.isInputTextFieldEnabled());
//
//			dc.enterText("arun");
//
//			dc.clickOnDisableButton();
//			dc.waitForEnableButtonToDisplay();
//			Assert.assertFalse(dc.isInputTextFieldEnabled());
//
//			System.out.println("dynamicControlsTest - Passed");
//		} catch (Throwable e) {
//			System.out.println("dynamicControlsTest - Failed");
//			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			Date date = new Date();
//			File dest = new File("C:\\Users\\saith\\Desktop\\Screenshots\\dynamicControls" + date.getTime() + ".jpg");
//			FileUtils.copyFile(screenshotFile, dest);
//
//			throw new RuntimeException("dynamicControlsTest - Failed");
//		}
//
//	}

	@AfterMethod
	public void quit() {
		DriverFactory df = new DriverFactory();
		df.quitDriver(driver);
	}

}
