package pom;

import org.openqa.selenium.WebDriver;

public class FaceBookLoginPage extends WebPage {

	private String emailXpath = "//*[@id=\"email\"]";
	private String passwordXpath = "//input[@id='pass']";
	private String logInXpath = "//button[@name='login']";
	private String loginErrorMessageXpath = "//div[@class='_9ay7']";
	private String forgottenpasswordXpath = "//a[text()='Forgotten password?']";
	private String createNewAccountXpath = "//a[text()='Create New Account']";

	public FaceBookLoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUserName(String userName) {
		super.enterText(emailXpath, userName);
	}

	public void enterPassword(String password) {
		super.enterText(passwordXpath, password);
	}

	public void clickOnLogIn() {
		super.click(logInXpath);

	}

	public String getErrorMessage() {
		String loginErrorMessage = super.getText(loginErrorMessageXpath);
		return loginErrorMessage;
	}

	public void enterUsernameAndPassword(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
	}

	public void clickOnforgottenPassword() {
		super.click(forgottenpasswordXpath);
	}

	public void clickOnCreateNewAccount() {
		super.click(createNewAccountXpath);
	}
}
