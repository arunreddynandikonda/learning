package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dropdowns {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Dropdowns d = new Dropdowns();
//		d.basicDropDown_Bootstrap();
//		d.dropDownHeader_Bootstrap();
//		d.disableAndActiveDropDown_Bootstrap();
		d.basicDropDown_Css();

	}

	public WebDriver CreateBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver CreateBrowser1() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/css/css_dropdowns.asp");
		driver.manage().window().maximize();
		return driver;
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void basicDropDown_Bootstrap() {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		System.out.println(driver.findElement(By.xpath("(//ul[@class='dropdown-menu test'])[1]")).getText());
		driver.findElement(By.xpath("(//a[text()='JavaScript'])[1]")).click();
		quit(driver);

	}

	public void dropDownHeader_Bootstrap() {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("(//ul[@class='dropdown-menu test'])[2]")).getText());
		driver.findElement(By.xpath("(//a[text()='CSS'])[3]")).click();
		quit(driver);

	}

	public void disableAndActiveDropDown_Bootstrap() {
		WebDriver driver = CreateBrowser();
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		System.out.println(driver.findElement(By.xpath("(//ul[@class='dropdown-menu test'])[3]")).getText());
		driver.findElement(By.xpath("(//a[@role='menuitem'])[9]")).click();
		quit(driver);

	}

	public void basicDropDown_Css() {
//		TODO
		WebDriver driver = CreateBrowser1();
		Actions actions = new Actions(driver);
		WebElement dropdownmenu = driver.findElement(By.xpath("//button[@class='dropbtn']"));
		actions.moveToElement(dropdownmenu);
		System.out.println(driver.findElement(By.xpath("(//div[@class='dropdown-content'])[2]")).getText());
		WebElement link1 = driver.findElement(By.xpath("(//a[@href='javascript:void(0)' and text()='Link 1'])[1]"));
		actions.click(link1);
		quit(driver);

	}

}
