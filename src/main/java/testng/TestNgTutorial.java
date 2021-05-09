package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgTutorial { 
	
	private WebDriver driver;
	
	@BeforeMethod
	public void createBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		this.driver = new ChromeDriver();
	}
	
	//createBrowser
	//fbLoginTest
	//quit
	//createBrowser
	//fbLoginTest2
	//quit

	//Annotation
	@Test
	public void fbLoginTest3() {
		driver.navigate().to("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("hjkl");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}
	
	@Test
	public void fbLoginTest2() {
		driver.navigate().to("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("hjkl");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Assert.assertTrue(false);
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
