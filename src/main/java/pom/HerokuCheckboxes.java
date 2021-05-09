package pom;

import org.openqa.selenium.WebDriver;

public class HerokuCheckboxes extends WebPage {

	private String checkbox1Xpath = "//input[1]";
	private String checkbox2Xpath = "//input[2]";

	public HerokuCheckboxes(WebDriver driver) {
		super(driver);
	}

	public void checkCheckbox1() {
		super.select(checkbox1Xpath);
	}

	public boolean isCheckBox1Selected() {
		return super.isElementSelected(checkbox1Xpath);
	}

	public void checkCheckbox2() {
		super.select(checkbox2Xpath);
	}

	public boolean isCheckBox2Selected() {
		return super.isElementSelected(checkbox2Xpath);
	}

}
