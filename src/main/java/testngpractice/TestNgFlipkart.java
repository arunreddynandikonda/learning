package testngpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgFlipkart {

	private WebDriver driver;
	//BeforeSuite
	//BeforeTest
//	@BeforeClass
	//BeforeMethod
	//@Test
	//AfterMethod
//	@AfrerClass
	//AfterTest
	//AfterSuite
	
	//Test --> classes

	@BeforeMethod
	public void createBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
	}

	@Test
	public void Searchbox_tc1() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys("ipad pro");
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys(Keys.ENTER);
		System.out.println(wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='_1YokD2 _2GoDe3 col-12-12']/div/div/span")))
				.getText());
	}

	@Test
	public void Searchbox_tc2() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys("asdfg");
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys(Keys.ENTER);
		System.out.println(wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='_1YokD2 _2GoDe3 col-12-12']/div/div/span")))
				.getText());
	}

	@Test
	public void Searchbox_tc3() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys("123456");
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys(Keys.ENTER);
		System.out.println(wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='_1YokD2 _2GoDe3 col-12-12']/div/div/span")))
				.getText());
	}

	@Test
	public void Searchbox_tc4() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys("asdfg23456y");
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys(Keys.ENTER);
		System.out.println(wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='_36fx1h _6t1WkM _3HqJxg']/div/div/div[1]")))
				.getText());
		System.out.println(wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='_36fx1h _6t1WkM _3HqJxg']/div/div/div[2]")))
				.getText());
	}

	@Test
	public void Login_tc1() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//form[@autocomplete='on']/div/input")).sendKeys("9494436012");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("dffdffec");
		driver.findElement(By.xpath("//div[@class='_1D1L_j']/button")).click();
		System.out.println(
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='_2YULOR']/span")))
						.getText());
	}

	@Test
	public void Login_tc2() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//form[@autocomplete='on']/div/input")).sendKeys("24343432");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Arunreddy@186");
		driver.findElement(By.xpath("//div[@class='_1D1L_j']/button")).click();
		System.out.println(
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='_2YULOR']/span")))
						.getText());
	}

	@Test
	public void Login_tc3() { 
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//div[@class='_1D1L_j']/button")).click();
		System.out.println(
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='_2YULOR']/span")))
						.getText());
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
