package pom;

import org.openqa.selenium.WebDriver;

public class FlipkartHomePage extends WebPage {

	private String loginDismissXpath = "//button[@class='_2KpZ6l _2doB4z']";
	private String searchBoxXpath = "//div[@class='_1cmsER']/form/div/div/input";

	public FlipkartHomePage(WebDriver driver) {
		super(driver);
	}

	public void dismissLoginPopupPage() {
		super.click(loginDismissXpath);
	}

	public void enterTextInSearchBox(String text) {
		super.enterText(searchBoxXpath, text);
	}

	public void clickEnter() {
		super.clickEnter(searchBoxXpath);
	}

	public void searchForTheProduct(String product) {
		dismissLoginPopupPage();
		enterTextInSearchBox(product);
		clickEnter();
	}

}
