package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Facebook1 fb = new Facebook1();
		fb.FacebookLogin_tc1();
		fb.FacebookLogin_tc2();
		fb.FacebookLogin_tc3();
		fb.FacebookLogin_tc4();
		fb.FacebookLogin_tc5();

	}

	public WebDriver CreateDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.facebook.com");
		return driver;

	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void FacebookLogin_tc1() {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//input[@aria-label='Email address or phone number']"))
				.sendKeys("arunreddy186@gmail.com");
		driver.findElement(By.xpath("//div[@class='_6lux']/div/input")).sendKeys("1Sun3ith6a.");
		driver.findElement(By.xpath("//div[@class='_6ltg']/button")).click();
		quit(driver);
	}

	public void FacebookLogin_tc2() {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//input[@aria-label='Email address or phone number']"))
				.sendKeys("arunreddy186@gmail.com");
		driver.findElement(By.xpath("//div[@class='_6lux']/div/input")).sendKeys("adsdasd");
		driver.findElement(By.xpath("//div[@class='_6ltg']/button")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='clearfix _5466 _44mg']/div[2]")).getText());
		quit(driver);

	}

	public void FacebookLogin_tc3() {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//input[@aria-label='Email address or phone number']"))
				.sendKeys("arunreddy186@gmail.com");
		driver.findElement(By.xpath("//div[@class='_6ltg']/button")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='clearfix _5466 _44mg']/div[2]")).getText());
		quit(driver);

	}

	public void FacebookLogin_tc4() {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//input[@aria-label='Email address or phone number']")).sendKeys("sdfdsgdsdgd");
		driver.findElement(By.xpath("//div[@class='_6ltg']/button")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='clearfix _5466 _44mg']/div[2]")).getText());
		quit(driver);

	}

	public void FacebookLogin_tc5() {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//div[@class='_6ltg']/button")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='clearfix _5466 _44mg']/div[2]")).getText());
		quit(driver);

	}

}