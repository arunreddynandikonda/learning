package pom;

import org.openqa.selenium.WebDriver;

public class HerokuContextMenu extends WebPage {

	private String boxXpath = "//div[@id='hot-spot']";

	public HerokuContextMenu(WebDriver driver) {
		super(driver);
	}

	public void rightClickInThebox() {
		super.contextClick(boxXpath);
	}

	public void acceptAlert() {
		super.acceptAlert();
	}
}
