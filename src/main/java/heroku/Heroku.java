package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Heroku {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Heroku heroku = new Heroku();
//		heroku.abTesting_tc1();
//		heroku.AddRemoveElements_tc2();
		heroku.BasicAuth_tc3();
//		heroku.Checkboxes_tc4();
//		heroku.DisappearingElements_tc5();
//		heroku.Dropdown_tc6();
//		heroku.DynamicControls_tc7();
//		heroku.DynamicLoading_tc8();
//		heroku.EntryAd_tc9();
//		heroku.ForgotPassword_tc10();
//		heroku.FormAuthentication_tc11();
//		heroku.Frames_tc12();
//		heroku.Inputs_tv13();
//		heroku.JQueryUiMenus_tv14();
//		heroku.KeyPresses_tv15();
//		heroku.Multiplewindows_tv16();
//		heroku.NotificationMessages_tv17();
//		heroku.RedirectLink_tv18();
	}

	public WebDriver createBrowser() {
		return new ChromeDriver();
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void abTesting_tc1() {
		WebDriver driver = this.createBrowser();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a")).click();
		driver.quit();
	}

	public void AddRemoveElements_tc2() {
		WebDriver driver = this.createBrowser();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"elements\"]/button")).click();
		driver.quit();

	}

	public void BasicAuth_tc3() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
	}

	public void Checkboxes_tc4() {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
		quit(driver);

	}

	public void DisappearingElements_tc5() {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[9]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[5]/a")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[4]/a")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a")).click();
		driver.quit();

	}

	public void Dropdown_tc6() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"dropdown\"]")).click();
		driver.quit();

	}

	public void DynamicControls_tc7() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[13]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")).sendKeys("arun");
		driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
		driver.quit();

	}

	public void DynamicLoading_tc8() {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[14]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
		driver.quit();

	}

	public void EntryAd_tc9() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[15]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[3]/p")).click();
		driver.quit();
	}

	public void ForgotPassword_tc10() {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[20]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("11111234@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"form_submit\"]")).click();
		driver.quit();

	}

	public void FormAuthentication_tc11() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("SuperSeceretPassword!");
		driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i")).click();
		driver.quit();

	}

	public void Frames_tc12() {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[22]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/a")).click();
		driver.quit();

	}

	public void Inputs_tv13() {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[27]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).click();
		driver.quit();

	}

	public void JQueryUiMenus_tv14() {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[28]/a")).click();
		// scrollingdriver.findElement(By.xpath("<a href=\"#\">Enabled</a>")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]/a")).click();
		driver.quit();
	}

	public void KeyPresses_tv15() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[31]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"target\"]")).sendKeys("arun");
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"result\"]")).getText());
		driver.quit();
	}

	public void Multiplewindows_tv16() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[33]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		Thread.sleep(5000);
		driver.quit();

	}

	public void NotificationMessages_tv17() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[35]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText());
		driver.quit();

	}

	public void RedirectLink_tv18() {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[36]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"redirect\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[4]/a")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText());
		driver.quit();

	}

}
