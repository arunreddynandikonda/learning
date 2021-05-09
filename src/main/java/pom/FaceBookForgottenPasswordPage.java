package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FaceBookForgottenPasswordPage extends WebPage {

	private String emailXpath = "//input[@type='text']";
	private String searchXpath = "//button[@type='submit']";
	private String restYourPasswordXpath = "//h2[@class='uiHeaderTitle' and text()='Reset Your Password']";

	public FaceBookForgottenPasswordPage(WebDriver driver) {
		super(driver);
	}

	public void enterEmailAddress(String emailId) {
		super.enterText(emailXpath, emailId);
	}

	public void clickOnSearch() {
		super.click(searchXpath);
	}

	public String getResetYourPassword() {
		WebElement resetYourPassword = super.visibleWait(restYourPasswordXpath); 
		return resetYourPassword.getText();
	}

}
