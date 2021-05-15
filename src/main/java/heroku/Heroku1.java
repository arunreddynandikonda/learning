package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Heroku1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Heroku1 h = new Heroku1();
//		h.ABTesting_tc1();
		h.AddRemoveElements_tc2();
//		h.BasicAuth_tc3();
//		h.digestAuthentication_tc22();
//		h.Checkboxes_tc4();
//		h.DisappearingElements_tc5();
//		h.Dropdown_tc6();
//		h.DynamicContent_tc7();
//		h.DynamicControls_tc8();
//		h.DynamicLoading_tc9();
//		h.EntryAd_tc10();
//		h.ForgotPassword_tc11();
//		h.FormAuthentication_tc12();
//		h.Frames_tc13();
//		h.Inputs_tc14();
//		h.KeyPresses_tc15();
//		h.Multiplewindows_tc16();
//		h.NotificationMessages_tc17();
//		h.RedirectLink_tc18();
//		h.contextMenu_19();
//		h.dragandDrop_tc20();
//		h.hovers_tc21();
	}

	public WebDriver CreateBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		return driver;
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void ABTesting_tc1() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='A/B Testing']")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//h3[text()='A/B Test Control']")).getText());
		quit(driver);

	}

	public void AddRemoveElements_tc2() {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
		driver.findElement(By.xpath("//button[text()='Add Element']")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		quit(driver);

	}

	public void BasicAuth_tc3() {
		WebDriver driver = CreateBrowser();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		System.out.println(driver.findElement(By.xpath("//p")).getText());
		quit(driver);
	}

	public void digestAuthentication_tc22() {
		WebDriver driver = CreateBrowser();
		driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
		System.out.println(driver.findElement(By.xpath("//p")).getText());
		quit(driver);
	}

	public void Checkboxes_tc4() {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		quit(driver);
	}

	public void DisappearingElements_tc5() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Disappearing Elements']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='About']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Portfolio']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		quit(driver);
	}

	public void Dropdown_tc6() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
		Thread.sleep(5000);
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select option = new Select(dropDown);
		option.selectByValue("1");
//		quit(driver);
	}

	public void DynamicContent_tc7() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Dynamic Content']")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//div[@class='large-10 columns']")).getText());
		driver.findElement(By.xpath("//a[text()='click here']")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//div[@class='large-10 columns']")).getText());
		quit(driver);
	}

	public void DynamicControls_tc8() throws InterruptedException {
		WebDriver driver = CreateBrowser();

		WebElement dynamicControls = driver.findElement(By.xpath("//a[text()='Dynamic Controls']"));
		dynamicControls.click();

		WebElement input = driver.findElement(By.xpath("//input[@type='text']"));

		WebElement enable = driver.findElement(By.xpath("//button[text()='Enable']"));

		if (!input.isEnabled()) {
			enable.click();
		}

		Thread.sleep(5000);
		input.sendKeys("asdf");

		quit(driver);

	}

	public void DynamicLoading_tc9() {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Dynamic Loading']")).click();
		driver.findElement(By.xpath("//a[text()='Example 1: Element on page that is hidden']")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Example 2: Element rendered after the fact']")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		quit(driver);
	}

	public void EntryAd_tc10() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Entry Ad']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[text()='Close']")).click();
		quit(driver);

	}

	public void ForgotPassword_tc11() {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Forgot Password']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("11111234@gmail.com");
		driver.findElement(By.xpath("//i[text()='Retrieve password']")).click();
		quit(driver);
	}

	public void FormAuthentication_tc12() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Form Authentication']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSeceretPassword!");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
		driver.quit();

	}

	public void Frames_tc13() {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Frames']")).click();
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("(//frameset[@frameborder='1']/frame)[1]")));
//		driver.navigate().back();
//		driver.findElement(By.xpath("//a[text()='iFrame']")).click();
//		quit(driver);

	}

	public void Inputs_tc14() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Inputs']")).click();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("2345234");
		Thread.sleep(5000);
		quit(driver);
	}

	public void KeyPresses_tc15() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Key Presses']")).click();
		driver.findElement(By.xpath("//input[@id='target']")).sendKeys("arun");
		Thread.sleep(3000);
		quit(driver);
	}

	public void Multiplewindows_tc16() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Thread.sleep(5000);
		quit(driver);
	}

	public void NotificationMessages_tc17() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Notification Messages']")).click();
		driver.findElement(By.xpath("//a[text()='Click here']")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		quit(driver);
	}

	public void RedirectLink_tc18() {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Redirect Link']")).click();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//a[text()='404']")).click();
		quit(driver);
	}

	public void contextMenu_19() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Context Menu']")).click();
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		WebElement hotSpot = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		actions.moveToElement(hotSpot).contextClick().build().perform();
		quit(driver);
	}

	public void dragandDrop_tc20() throws InterruptedException {
//		TODO
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Drag and Drop']")).click();
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		WebElement source = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='column-b']"));
		actions.clickAndHold(source).moveToElement(target).release(source).build().perform();
//		quit(driver); 
	}

	public void hovers_tc21() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("//a[text()='Hovers']")).click();
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		WebElement figure1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
		actions.moveToElement(figure1).build().perform();
		System.out.println(driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[1]")).getText());
		WebElement figure2 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
		actions.moveToElement(figure2).build().perform();
		System.out.println(driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[2]")).getText());
		WebElement figure3 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));
		actions.moveToElement(figure3).build().perform();
		System.out.println(driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[3]")).getText());
		quit(driver);
	}

}
