package pom;

import org.openqa.selenium.WebDriver;

public class FacebookCreateNewAccount extends WebPage {

	private String firstNameXpath = "//input[@name='firstname']";
	private String surNameXpath = "//input[@aria-label='Surname']";
	private String emailAddressXpath = "//input[@aria-label='Mobile number or email address']";
	private String reEnterEmailAddressXpath = "//input[@name='reg_email_confirmation__']";
	private String passwordXpath = "//input[@aria-label='New password']";
	private String dateXpath = "//select[@id='day']";
	private String monthXpath = "//select[@id='month']";
	private String yearXpath = "//select[@id='year']";

	private String getGenderXpath(String gender) {
		return "//label[text()='" + gender + "']";
	}

	private String signUpXpath = "//button[@name='websubmit' and text()='Sign Up']";
	private String signUpErrorMessageXpath = "//div[@id='reg_error_inner']";

	public FacebookCreateNewAccount(WebDriver driver) {
		super(driver);
	}

	public void enterfirstNameAndSurName(String firstName, String surName) {
		super.visibleWait(firstNameXpath).sendKeys(firstName);
		super.enterText(surNameXpath, surName);
	}

	public void enteremailAddress(String emailAddress) {
		super.enterText(emailAddressXpath, emailAddress);
	}

	public void reEnteremailAddress(String emailAddress) {
		super.enterText(reEnterEmailAddressXpath, emailAddress);
	}

	public void enterPassword(String password) {
		super.enterText(passwordXpath, password);
	}

	public void enterDateOfBirth(String date, String month, String year) {
		super.selectByValueFromDropDown(dateXpath, date);
		super.selectByValueFromDropDown(monthXpath, month);
		super.selectByValueFromDropDown(yearXpath, year);
//		WebElement d = driver.findElement(By.xpath(dateXpath));
//		Select Date = new Select(d);
//		Date.selectByValue(date);
//		WebElement m = driver.findElement(By.xpath(monthXpath));
//		Select Month = new Select(m);
//		Month.selectByVisibleText(month);
//		WebElement y = driver.findElement(By.xpath(yearXpath));
//		Select Year = new Select(y);
//		Year.selectByVisibleText(year);
	}

	public void selectGender(String gender) {
		super.click(this.getGenderXpath(gender));
	}

	public void clickOnSignUp() {
		super.click(signUpXpath);
	}

	public String getSignUpErrormessage() {
		String signUpErrorMessage = super.visibleWait(signUpErrorMessageXpath).getText();
		return signUpErrorMessage;
	}

}
