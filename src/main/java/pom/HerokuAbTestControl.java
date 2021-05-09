package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerokuAbTestControl {

	private WebDriver driver;
	private String abTestControlXpath = "//div[@class='example']";

	public HerokuAbTestControl(WebDriver driver) {
		this.driver = driver;
	}

	public String validateText() {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(abTestControlXpath)));
		return text.getText();
	}
}
