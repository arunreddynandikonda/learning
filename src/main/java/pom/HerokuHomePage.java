package pom;

import org.openqa.selenium.WebDriver;

public class HerokuHomePage extends WebPage {

	private String abTestingXpath = "//*[@id=\"content\"]/ul/li[1]/a";
	private String addRemoveElementsXpath = "//a[text()='Add/Remove Elements']";
	private String checkBoxesXpath = "//a[text()='Checkboxes']";
	private String disappearingElementsXpath = "//a[text()='Disappearing Elements']";
	private String dropdownXpath = "//a[text()='Dropdown']";
	private String dynamicContentXpath = "//a[text()='Dynamic Content']";
	private String dynamicControlsXpath = "//a[text()='Dynamic Controls']";
	private String dynamicLoadingXpath = "//a[text()='Dynamic Loading']";
	private String entryAdXpath = "//a[text()='Entry Ad']";
	private String forgotPasswordXpath = "//a[text()='Forgot Password']";
	private String formAuthenticationXpath = "//a[text()='Form Authentication']";
	private String inputsXpath = "//a[text()='Inputs']";
	private String framesXpath = "//a[text()='Frames']";
	private String hoversXpath = "//a[text()='Hovers']";
	private String contextMenuXpath = "//a[text()='Context Menu']";
	private String multiplleWindowsXpath = "//a[text()='Multiple Windows']";

	public HerokuHomePage(WebDriver driver) {
		super(driver);
	}

	public void clickOnAbTestingLink() {
		super.click(abTestingXpath);
	}

	public void clickOnAddRemoveElementsLink() {
		super.click(addRemoveElementsXpath);
	}

	public void clickOnCheckBoxesLink() {
		super.click(checkBoxesXpath);
	}

	public void clickOnDisappearingElementsLink() {
		super.click(disappearingElementsXpath);
	}

	public void clickOnDropdownLink() {
		super.click(dropdownXpath);
	}

	public void clickOnDynamicContentLink() {
		super.click(dynamicContentXpath);
	}

	public void clickOnDynamicControlsLink() {
		super.click(dynamicControlsXpath);
	}

	public void clickOnDynamicLoadingLink() {
		super.click(dynamicLoadingXpath);
	}

	public void clickOnEntryAdLink() {
		super.click(entryAdXpath);
	}

	public void clickOnForgotPasswordLink() {
		super.click(forgotPasswordXpath);
	}

	public void clickOnFormAuthenticationLink() {
		super.click(formAuthenticationXpath);
	}

	public void clickOnFramesLink() {
		super.click(framesXpath);
	}

	public void clickOnInputsLink() {
		super.click(inputsXpath);
	}

	public void clickOnHoversLink() {
		super.click(hoversXpath);
	}

	public void clickOnContextMenuLink() {
		super.click(contextMenuXpath);
	}

	public void clickOnMultipleWindowsLink() {
		super.click(multiplleWindowsXpath);
	}
}
