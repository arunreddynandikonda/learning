package test.annotations.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Heroku {

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

	@Test(groups = { "smoke" })
	public void abTesting_tc1() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement abtesting = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a"));
		abtesting.click();

		WebElement text = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='example']")));
		System.out.println(text.getText());
	}

	@Test
	public void addRemoveElements_tc2() {

		WebElement addremoveElement = driver.findElement(By.xpath("//a[text()='Add/Remove Elements']"));
		addremoveElement.click();

		WebElement addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
		addElement.click();

		WebElement delete = driver.findElement(By.xpath("//button[text()='Delete']"));
		delete.click();
	}

	@Test
	public void checkBoxes_tc3() {

		WebElement checkBoxes = driver.findElement(By.xpath("//a[text()='Checkboxes']"));
		checkBoxes.click();

		WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

		WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		if (!checkBox1.isSelected()) {
			checkBox1.click();
		}
		if (!checkBox2.isSelected()) {
			checkBox2.click();
		}
	}

//	(dependsOnMethods = { "checkBoxes_tc3", "dropdown_tc5()" })
	@Test
	public void disappearingElements_tc4() {

		WebElement disappearingElements = driver.findElement(By.xpath("//a[text()='Disappearing Elements']"));
		disappearingElements.click();

		WebElement about = driver.findElement(By.xpath("//a[text()='About']"));
		about.click();

		driver.navigate().back();

		WebElement portfolio = driver.findElement(By.xpath("//a[text()='Portfolio']"));
		portfolio.click();

		driver.navigate().back();

		WebElement home = driver.findElement(By.xpath("//a[text()='Home']"));
		home.click();
	}

	@Test
	public void dropdown_tc5() {

		WebElement dropdown = driver.findElement(By.xpath("//a[text()='Dropdown']"));
		dropdown.click();

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select option = new Select(dropDown);
		option.selectByValue("1");
	}

	@Test
	public void dynamicContent_tc6() {

		WebElement dynamicContent = driver.findElement(By.xpath("//a[text()='Dynamic Content']"));
		dynamicContent.click();

		WebElement paragraph1 = driver.findElement(By.xpath("//div[@class='large-10 columns']"));
		System.out.println(paragraph1.getText());

		WebElement click = driver.findElement(By.xpath("//a[text()='click here']"));
		click.click();

		WebElement paragraph2 = driver.findElement(By.xpath("//div[@class='large-10 columns']"));
		System.out.println(paragraph2.getText());
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
