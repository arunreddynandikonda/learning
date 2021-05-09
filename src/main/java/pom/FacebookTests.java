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

public class FacebookTests {
	WebDriver driver;

	@BeforeMethod
	public void before(ITestContext context) {
		DriverFactory driverFactory = new DriverFactory();
		driver = driverFactory.createDriver();
		driver.get("http://www.facebook.com");
		context.setAttribute("driver", driver);
	}

	@Test
	public void invalidLogInTest() throws IOException {

		ScreenshotUtils sc = new ScreenshotUtils();

		FaceBookLoginPage loginPage = new FaceBookLoginPage(driver);
		loginPage.enterUsernameAndPassword("asdf", "12343");
		ExtentTestManager.getTest().log(Status.INFO, "Entering username and password is Completed");

		loginPage.clickOnLogIn();
		ExtentTestManager.getTest().log(Status.INFO, "Clicking On login Button is Completed");

		try {
			String loginErrorMessage = loginPage.getErrorMessage();
			Assert.assertEquals(loginErrorMessage,
					"The email address or mobile number you entered isn't connected to an account. Find your account and log in.");
			ExtentTestManager.getTest().log(Status.PASS, "Login Error Message Is Matching", MediaEntityBuilder
					.createScreenCaptureFromPath(sc.takeScreenshot(driver, "invalidLoginTest")).build());
		} catch (Throwable t) {
			ExtentTestManager.getTest().log(Status.FAIL, "Login Error Message Is Not Matching", MediaEntityBuilder
					.createScreenCaptureFromPath(sc.takeScreenshot(driver, "invalidLoginTest")).build());
			throw new RuntimeException(t);
		}

	}

	@Test
	public void invalidForgotPasswordTest() {
		FaceBookLoginPage loginPage = new FaceBookLoginPage(driver);

		loginPage.clickOnforgottenPassword();

		FaceBookForgottenPasswordPage fpp = new FaceBookForgottenPasswordPage(driver);

		fpp.enterEmailAddress("test@gmail.com");

		fpp.clickOnSearch();

		String resetYourPassword = fpp.getResetYourPassword();
		Assert.assertEquals(resetYourPassword, "Reset Your Password");

	}

	@Test
	public void invalidCreateNewAccount() {
		FaceBookLoginPage loginPage = new FaceBookLoginPage(driver);
		loginPage.clickOnCreateNewAccount();
		FacebookCreateNewAccount na = new FacebookCreateNewAccount(driver);
		na.enterfirstNameAndSurName("asdf", "hjkl");
		na.enteremailAddress("asdf@gmail.com");
		na.reEnteremailAddress("asdf@gmail.com");
		na.enterPassword("123456");
		na.enterDateOfBirth("12", "4", "1996");
		na.selectGender("Male");
		na.clickOnSignUp();

		String signUpErrorMessage = na.getSignUpErrormessage();
		Assert.assertEquals(signUpErrorMessage, "An error occurred. Please try again.");
	}

	@AfterMethod
	public void quit() {
		DriverFactory driverFactory = new DriverFactory();
		driverFactory.quitDriver(driver);
	}

}
