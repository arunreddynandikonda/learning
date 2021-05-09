package facebooksignup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		Facebook fb = new Facebook();
		fb.FacebookLogin_tc1(driver);
		fb.FacebookSignup_tc2(driver);

	}

	public void FacebookLogin_tc1(ChromeDriver driver) {
		driver.navigate().to("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("hjkl");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.navigate().back();
		driver.navigate().back();

	}

	public void FacebookSignup_tc2(ChromeDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[@data-testid=\"open-registration-form-button\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@aria-label=\"First name\"]")).sendKeys("asdf");
		driver.findElement(By.xpath("//*[@aria-label=\"Mobile number or email address\"]")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@data-type=\"password\"]")).sendKeys("12345678");
		WebElement day = driver.findElement(By.xpath("//*[@aria-label=\"Day\"]"));
		Select dob1 = new Select(day);
		dob1.selectByIndex(12);
		WebElement month = driver.findElement(By.xpath("//*[@aria-label=\"Month\"]"));
		Select dob2 = new Select(month);
		dob2.selectByIndex(4);
		WebElement year = driver.findElement(By.xpath("//*[@aria-label=\"Year\"]"));
		Select dob3 = new Select(year);
		dob3.selectByValue("1996");
		driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba']/input)[2]")).click();
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
//		driver.quit();
	}

}
