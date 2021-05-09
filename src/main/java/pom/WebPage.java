package pom;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Find find;

	public WebPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		find = new Find(driver);
	}

	public WebElement click(String xpath) {
		find.findElement(xpath).click();
		return null;
	}

	public void enterText(String xpath, String text) {
		find.findElement(xpath).sendKeys(text);
	}

	public String getText(String xpath) {
		return find.findElement(xpath).getText();
	}

	public WebElement visibleWait(String xpath) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void invisibilityWait(String xpath) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	public WebElement clickableWait(String xpath) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public void selectByValueFromDropDown(String xpath, String value) {
		Select dropdown = new Select(visibleWait(xpath));
		dropdown.selectByValue(value);
	}

	public void selectByTextFromDropDown(String xpath, String text) {
		Select dropdown = new Select(visibleWait(xpath));
		dropdown.selectByVisibleText(text);
	}

	public String selectedValue(String xpath) {
		Select dropdown = new Select(find.findElement(xpath));
		String selectedValue = dropdown.getFirstSelectedOption().getText();
		return selectedValue;
	}

	public boolean isElementPresent(String xpath) {
		List<WebElement> webElement = find.findElements(xpath);
		if (webElement.isEmpty())
			return false;
		else
			return true;
	}

	public WebElement select(String xpath) {
		WebElement checkbox = visibleWait(xpath);
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
		return checkbox;
	}

	public boolean isElementSelected(String xpath) {
		WebElement checkbox = find.findElement(xpath);
		return checkbox.isSelected();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public boolean isenabled(String xpath) {
		return find.findElement(xpath).isEnabled();
	}

	public void switchFrame(String xpath) {
		driver.switchTo().frame(find.findElement(xpath));
	}

	public void moveToElemnt(String xpath) {
		Actions actions = new Actions(driver);
		actions.moveToElement(find.findElement(xpath)).build().perform();
	}

	public void contextClick(String xpath) {
		Actions actions = new Actions(driver);
		actions.contextClick(find.findElement(xpath)).build().perform();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public Set<String> windows() {
		return driver.getWindowHandles();
	}

	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	public void switchToWindow(String text) {
		driver.switchTo().window(text);
	}

	public void clickEnter(String xpath) {
		find.findElement(xpath).sendKeys(Keys.ENTER);
	}

}
