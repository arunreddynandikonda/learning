package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Find {
	
	private WebDriver driver;
	
	public Find(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement findElement(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public List<WebElement> findElements(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

}
