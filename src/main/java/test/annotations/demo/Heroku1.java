package test.annotations.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Heroku1 {

	private WebDriver driver;

	@BeforeClass
	public void createBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	}

	@BeforeMethod
	public void website() {
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/");
	}

	@Test(enabled = false)
	public void dynamicControls_tc7() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement dynamicControls = driver.findElement(By.xpath("//a[text()='Dynamic Controls']"));
		dynamicControls.click();

		String inputXpath = "//input[@type='text']";
		WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputXpath)));

		WebElement enable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Enable']")));

		if (!input.isEnabled()) {
			enable.click();
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
		input.sendKeys("asdf");
	}

	@Test(groups = { "smoke" })
	public void dynamicLoading_tc8() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement dynamicLoading = driver.findElement(By.xpath("//a[text()='Dynamic Loading']"));
		dynamicLoading.click();

		WebElement example1 = driver.findElement(By.xpath("//a[text()='Example 1: Element on page that is hidden']"));
		example1.click();

		String startXpath = "//button[text()='Start']";
		WebElement start = driver.findElement(By.xpath(startXpath));
		start.click();

		driver.navigate().back();

		WebElement example2 = driver.findElement(By.xpath("//a[text()='Example 2: Element rendered after the fact']"));
		example2.click();

		WebElement start1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(startXpath)));
		start1.click();

	}

	@Test
	public void entryAd_tc9() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement entryAd = driver.findElement(By.xpath("//a[text()='Entry Ad']"));
		entryAd.click();

		WebElement close = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Close']")));
		close.click();
	}

	@Test
	public void forgotPassword_tc10() {

		WebElement forgotPassword = driver.findElement(By.xpath("//a[text()='Forgot Password']"));
		forgotPassword.click();

		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("test@email.com");

		WebElement retrivePassword = driver.findElement(By.xpath("//i[text()='Retrieve password']"));
		retrivePassword.click();
	}

	@Test
	public void formAuthentication_tc11() {

		WebElement formAuthentication = driver.findElement(By.xpath("//a[text()='Form Authentication']"));
		formAuthentication.click();

		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("tomsmith");

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("SuperSeceretPassword!");

		WebElement signin = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
		signin.click();

	}

	@Test
	public void inputs_tc12() {

		WebElement inputs = driver.findElement(By.xpath("//a[text()='Inputs']"));
		inputs.click();

		WebElement number = driver.findElement(By.xpath("//input[@type='number']"));
		number.sendKeys("2345234");
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
