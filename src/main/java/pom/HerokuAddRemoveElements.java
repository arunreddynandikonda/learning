package pom;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;

public class HerokuAddRemoveElements extends WebPage {

	private Find find;
	private String addElementXpath = "//button[text()='Add Element']";
	private String deleteXpath = "//button[text()='Delete']";

	public HerokuAddRemoveElements(WebDriver driver) {
		super(driver);
		find = new Find(driver);
	}

	public void clickOnAddElement() {
		super.click(addElementXpath);
	}

	public boolean isDeleteButtonPresent() {
		return super.isElementPresent(deleteXpath);
	}

	public void clickOnDelete() {
		super.click(deleteXpath);
	}

	public boolean isDeletePresent() {
		try {
			find.findElement(deleteXpath);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}

	}

}
