package udemey;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Udemey {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Udemey u = new Udemey();
		u.selinium();
	}

	public WebDriver CreateBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.udemy.com");
		return driver;

	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void selinium() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		Actions actions = new Actions(driver);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("selenium with java");
		driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[text()='Selenium WebDriver with Java -Basics to Advanced+Frameworks'])[1]"))
				.click();

		WebElement moreSectionsButton = driver
				.findElement(By.xpath("//span[contains(text(),'more section')]/parent::button"));
		actions.click(moreSectionsButton);
		Thread.sleep(5000);

		List<WebElement> expandIcons = driver.findElements(By.xpath("//h3/following-sibling::*"));

		for (int i = expandIcons.size() - 1; i >= 0; i--) {
			actions.moveToElement(expandIcons.get(i)).click().build().perform();
			Thread.sleep(1000);
		}

		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class,'section--row')]"));

		for (int i = 0; i < rows.size(); i++) {
			System.out.println(rows.get(i).getText());
		}
	}

}
