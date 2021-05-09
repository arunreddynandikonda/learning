package pom;

import org.openqa.selenium.WebDriver;

public class HerokuDynamicControls extends WebPage {

	private String checkboxXpath = "//input[@type='checkbox']";
	private String removeButtonXpath = "//button[text()='Remove']";
	private String addButtonXpath = "//button[text()='Add']";
	private String inputXpath = "//input[@type='text']";
	private String enableButtonXpath = "//button[text()='Enable']";
	private String disableButtonXpath = "//button[text()='Disable']";

	public HerokuDynamicControls(WebDriver driver) {
		super(driver);
	}

	public void checkCheckbox() {
		super.select(checkboxXpath);
	}

	public void clickOnRemoveButton() {
		super.click(removeButtonXpath);
	}

	public void waitForAddButtonToDisplay() {
		super.visibleWait(addButtonXpath);
	}

	public boolean isCheckboxpresent() {
		return super.isElementPresent(checkboxXpath);
	}

	public void clickOnAddButton() {
		super.click(addButtonXpath);
	}

	public void waitForRemoveButtonToDisplay() {
		super.visibleWait(removeButtonXpath);
	}

	public void clickOnEnableButton() {
		super.click(enableButtonXpath);
	}

	public boolean isInputTextFieldEnabled() {
		return super.isenabled(inputXpath);
	}

	public void waitForDisableButtonToDisplay() {
		super.visibleWait(disableButtonXpath);
	}

	public void enterText(String text) {
		super.enterText(inputXpath, text);
	}

	public void clickOnDisableButton() {
		super.click(disableButtonXpath);
	}

	public void waitForEnableButtonToDisplay() {
		super.visibleWait(enableButtonXpath);
	}

}
