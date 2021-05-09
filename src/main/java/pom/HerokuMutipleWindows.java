package pom;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class HerokuMutipleWindows extends WebPage {

	private String clickHereXpath = "//a[text()='Click Here']";
	private String parentWindowTextXpath = "//h3[text()='Opening a new window']";
	private String childWindowTextXpath = "//h3[text()='New Window']";

	public HerokuMutipleWindows(WebDriver driver) {
		super(driver);
	}

	public void clickOnClickHere() {
		super.click(clickHereXpath);
	}

	public String getTextInParentWindow() {
		String text = super.getText(parentWindowTextXpath);
		return text;
	}

	public String getTextInChildWindow() {
		Set<String> windows = super.windows();
		String parentWindow = super.getCurrentWindowHandle();
		String childWindow = null;
		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				childWindow = window;
			}
		}
		super.switchToWindow(childWindow);
		String text = super.getText(childWindowTextXpath);
		return text;
	}

}
