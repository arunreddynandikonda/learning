package pom;

import org.openqa.selenium.WebDriver;

public class HerokuDropdown extends WebPage {

	private String selectOptionXpath = "//select[@id='dropdown']";

	public HerokuDropdown(WebDriver driver) {
		super(driver);
	}

	public void selectAnOptionFromDropdownList(String text) {
		super.selectByTextFromDropDown(selectOptionXpath, text);
	}

	public String optionSelected() {
		return super.selectedValue(selectOptionXpath);
	}

}
