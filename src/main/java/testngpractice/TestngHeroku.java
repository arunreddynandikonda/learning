package testngpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngHeroku {

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

	@Test
	public void keyPresses_tc13() {

		WebElement keyPresses = driver.findElement(By.xpath("//a[text()='Key Presses']"));
		keyPresses.click();

		WebElement target = driver.findElement(By.xpath("//input[@id='target']"));
		target.sendKeys("arun");
	}

	@Test
	public void multiplewindows_tc14() {

		WebElement multiplewindows = driver.findElement(By.xpath("//a[text()='Multiple Windows']"));
		multiplewindows.click();

		WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickHere.click();
	}

	@Test
	public void notificationMessages_tc15() throws InterruptedException {

		WebElement notificationMessages = driver.findElement(By.xpath("//a[text()='Notification Messages']"));
		notificationMessages.click();

		WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click here']"));
		clickHere.click();

		WebElement flash = driver.findElement(By.xpath("//div[@id='flash']"));
		System.out.println(flash.getText());
	}

	@Test
	public void redirectLink_tc16() {

		WebElement redirectLink = driver.findElement(By.xpath("//a[text()='Redirect Link']"));
		redirectLink.click();

		WebElement here = driver.findElement(By.xpath("//a[text()='here']"));
		here.click();

		WebElement linkId = driver.findElement(By.xpath("//a[text()='404']"));
		linkId.click();

	}

	@Test
	public void contextMenu_17() {

		WebElement contextMenu = driver.findElement(By.xpath("//a[text()='Context Menu']"));
		contextMenu.click();

		Actions actions = new Actions(driver);

		WebElement hotSpot = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		actions.moveToElement(hotSpot).contextClick().build().perform();
	}

	@Test(groups = { "smoke" })
	public void hovers_tc18() {

		Actions actions = new Actions(driver);

		WebElement hovers = driver.findElement(By.xpath("//a[text()='Hovers']"));
		hovers.click();

		WebElement figure1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
		actions.moveToElement(figure1).build().perform();
		WebElement caption1 = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[1]"));
		System.out.println(caption1.getText());

		WebElement figure2 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
		actions.moveToElement(figure2).build().perform();
		WebElement caption2 = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[2]"));
		System.out.println(caption2.getText());

		WebElement figure3 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));
		actions.moveToElement(figure3).build().perform();
		WebElement caption3 = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[3]"));
		System.out.println(caption3.getText());
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
