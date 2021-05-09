package flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Flipkart f = new Flipkart();
		f.Searchbox_tc1();
		f.Searchbox_tc2();
		f.Searchbox_tc3();
		f.Searchbox_tc4();
		f.Login_tc1();
		f.Login_tc2();
		f.Login_tc3();
		f.Login_tc4();
		f.MyProfile();
		f.CoustomerCare();

	}

	public WebDriver CreateDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com");
		return driver;
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void Searchbox_tc1() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys("ipad pro");
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.println(
				driver.findElement(By.xpath("//div[@class='_1YokD2 _2GoDe3 col-12-12']/div/div/span")).getText());
		quit(driver);

	}

	public void Searchbox_tc2() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys("asdfg");
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.println(
				driver.findElement(By.xpath("//div[@class='_1YokD2 _2GoDe3 col-12-12']/div/div/span")).getText());
		quit(driver);

	}

	public void Searchbox_tc3() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys("123456");
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.println(
				driver.findElement(By.xpath("//div[@class='_1YokD2 _2GoDe3 col-12-12']/div/div/span")).getText());
		quit(driver);

	}

	public void Searchbox_tc4() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys("asdfg23456y");
		driver.findElement(By.xpath("//div[@class='_1cmsER']/form/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.println(
				driver.findElement(By.xpath("//div[@class='_36fx1h _6t1WkM _3HqJxg']/div/div/div[1]")).getText());
		System.out.println(
				driver.findElement(By.xpath("//div[@class='_36fx1h _6t1WkM _3HqJxg']/div/div/div[2]")).getText());
		quit(driver);

	}

	public void Login_tc1() {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//form[@autocomplete='on']/div/input")).sendKeys("9494436012");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Arunreddy@186");
		driver.findElement(By.xpath("//div[@class='_1D1L_j']/button")).click();
		quit(driver);

	}

	public void Login_tc2() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//form[@autocomplete='on']/div/input")).sendKeys("9494436012");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("dffdffec");
		driver.findElement(By.xpath("//div[@class='_1D1L_j']/button")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//span[@class='_2YULOR']/span")).getText());
		quit(driver);

	}

	public void Login_tc3() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//form[@autocomplete='on']/div/input")).sendKeys("24343432");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Arunreddy@186");
		driver.findElement(By.xpath("//div[@class='_1D1L_j']/button")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//span[@class='_2YULOR']/span")).getText());
		quit(driver);

	}

	public void Login_tc4() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//div[@class='_1D1L_j']/button")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//span[@class='_2YULOR']/span")).getText());
		quit(driver);

	}

	public void MyProfile() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//form[@autocomplete='on']/div/input")).sendKeys("9494436012");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Arunreddy@186");
		driver.findElement(By.xpath("//div[@class='_1D1L_j']/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='_28p97w']/div/div/div")).click();
		driver.findElement(By.xpath("//div[@class='_28p97w']/div/div/div")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='_2kxeIr']/div")).click();
		quit(driver);

	}

	public void CoustomerCare() throws InterruptedException {
		WebDriver driver = CreateDriver();
		driver.findElement(By.xpath("//div[@class='_2hriZF _2rbIyg']/div/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='_28p97w']/div/div/div")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='24x7 Customer Care']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@class='_1EQH8l']/div/h1")).getText());
		quit(driver);

	}

}
