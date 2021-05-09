package amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {
	public static void main(String Args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Amazon a = new Amazon();
//		a.Searchbox_tc1();
//		a.Searchbox_tc2();
//		a.Searchbox_tc3();
//		a.Searchbox_tc4();
//		a.CoustomerCare();
		a.selenium();
//		a.shoping();
	}

	public WebDriver CreateDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.in");
		return driver;
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void Searchbox_tc1() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")).sendKeys("m1 macebook pro");
		driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.print(
				driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[1]"))
						.getText());
		System.out.print(
				driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[3]"))
						.getText());
		quit(driver);

	}

	public void Searchbox_tc2() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")).sendKeys("qwert");
		driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.print(
				driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[1]"))
						.getText());
		System.out.print(
				driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[3]"))
						.getText());
		quit(driver);

	}

	public void Searchbox_tc3() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")).sendKeys("09876543");
		driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.print(
				driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[1]"))
						.getText());
		System.out.print(
				driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[3]"))
						.getText());
		quit(driver);

	}

	public void Searchbox_tc4() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")).sendKeys("34rff44t45tf");
		driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.print(driver.findElement(By.xpath("(//div[@tabindex='0']/div/span)[1]")).getText());
		System.out.print(driver.findElement(By.xpath("(//div[@tabindex='0']/div/span)[2]")).getText());
		quit(driver);

	}

	public void CoustomerCare() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//a[@aria-label='Open Menu']/i")).click();
		driver.findElement(By.xpath("(//ul[@class='hmenu hmenu-visible']/li/a)[21]")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath(
				"//div[@class='a-section a-spacing-extra-large a-spacing-top-extra-large ss-landing-container']/h1"))
				.getText());
		quit(driver);

	}

	public void selenium() throws InterruptedException {
		WebDriver driver = CreateDriver();
		Actions actions = new Actions(driver);
		WebElement searchBox = driver.findElement(By.xpath("//input[@aria-label='Search']"));
		actions.sendKeys(searchBox, "selenium").build().perform();
		actions.pause(3000);
		actions.sendKeys(searchBox, Keys.ENTER).build().perform();
//		driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")).sendKeys("selenium");
//		driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")).sendKeys(Keys.ENTER);
		List<WebElement> items = driver.findElements(By.xpath("//a[contains(@href,'Selenium')]"));

		for (int i = items.size() - 1; i >= 0; i--) {
			System.out.println(items.get(i).getText());
		}
		quit(driver);
	}

	public void shoping() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("flipflops");
	}
}
