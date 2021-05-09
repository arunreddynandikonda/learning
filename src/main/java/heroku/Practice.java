package heroku;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
//import java.util.ArrayList;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Practice p = new Practice();
//		p.checkBoxes();
//		p.assignment();
//		p.explicitWaitAssignment();
//		p.exception();
//		p.windowHandlingAssignment();
//		p.nestedFrameAssignment();
//		p.linksCountAssignment();
//		p.dynamicAssignment("bmw");
//		p.tablesAssignment();
		p.autoCompleteDropdownAssignment();
	}

	public WebDriver CreateBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void checkBoxes() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement option1 = driver.findElement(By.xpath("//input[@value='option1']"));
		option1.click();
		System.out.println(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		driver.findElement(By.xpath("//input[@value='option1']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		Thread.sleep(3000);
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		quit(driver);
	}

	public void assignment() throws InterruptedException {
		WebDriver driver = CreateBrowser();
		driver.navigate().to("https://www.cleartrip.com");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//input[@id='OneWay']")).click();
		driver.findElement(By.xpath("//input[@title='Depart date']")).click();
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ']")).click();
		driver.findElement(By.xpath("//select[@id='Adults']")).click();
		WebElement adults = driver.findElement(By.xpath("//select[@id='Adults']"));
		Select age1 = new Select(adults);
		age1.selectByValue("2");
		driver.findElement(By.xpath("//select[@id='Childrens']")).click();
		WebElement children = driver.findElement(By.xpath("//select[@id='Childrens']"));
		Select age2 = new Select(children);
		age2.selectByValue("1");
		driver.findElement(By.xpath("//select[@id='Infants']")).click();
		WebElement infants = driver.findElement(By.xpath("//select[@id='Infants']"));
		Select age3 = new Select(infants);
		age3.selectByValue("1");
		driver.findElement(By.xpath("//a[@id='MoreOptionsLink']")).click();
		WebElement cla = driver.findElement(By.xpath("//select[@id='Class']"));
		Select item = new Select(cla);
		item.selectByValue("Business");
		driver.findElement(By.xpath("//input[@id='AirlineAutocomplete']")).sendKeys("Emirates (EK)");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='homeErrorMessage']")).getText());
		quit(driver);
	}

	public void explicitWaitAssignment() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.itgeared.com/demo/1506-ajax-loading.html");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement Demo = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[text()='Click to load get data via Ajax!']")));
		Demo.click();

		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']")));
		System.out.println(text.getText());

	}

	public void exception() {

		try {

			int[] a = { 2, 43, 55, 45, 43, 54, };

			System.out.println(a[12]);
		} catch (ArithmeticException a) {
			System.out.println("this is Arthemetic Exception block");
		}

		catch (IndexOutOfBoundsException e) {
			System.out.println("this is Index out of Bounds block");
		}

		finally {
			System.out.println("this is fainally block");
		}
	}

	public void windowHandlingAssignment() {

		WebDriver driver = CreateBrowser();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		WebElement multipleWindows = driver.findElement(By.xpath("//a[text()='Multiple Windows']"));
		multipleWindows.click();

		WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickHere.click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> w = windows.iterator();
		String parentWindow = w.next();
		String childWindow = w.next();
		driver.switchTo().window(childWindow);

		WebElement text = driver.findElement(By.xpath("//h3[text()='New Window']"));
		System.out.println(text.getText());

		driver.switchTo().window(parentWindow);
		WebElement text1 = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
		System.out.println(text1.getText());

	}

	public void nestedFrameAssignment() {

		WebDriver driver = CreateBrowser();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		WebElement nestedFrames = driver.findElement(By.xpath("//a[text()='Nested Frames']"));
		nestedFrames.click();

		WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(topFrame);

		WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middleFrame);

		WebElement text = driver.findElement(By.xpath("//div[text()='MIDDLE']"));
		System.out.println(text.getText());

	}

	public void linksCountAssignment() {

		WebDriver driver = CreateBrowser();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com");

		Actions actions = new Actions(driver);

		WebElement practice = driver.findElement(By.xpath("//a[text()='Practice']"));
		practice.click();

		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println(links.size());

		List<WebElement> footerLinks = driver
				.findElements(By.xpath("//div[@class=' footer_top_agile_w3ls gffoot footer_style']//a"));
		System.out.println(footerLinks.size());

		List<WebElement> coloum1footerLinks = driver
				.findElements(By.xpath("//a[text()='Discount Coupons']/parent::h3/parent::li/parent::ul//a"));
//		System.out.println(coloum1footerLinks.size()); 

		for (WebElement coloum1footerLink : coloum1footerLinks) {
			actions.keyDown(coloum1footerLink, Keys.CONTROL).release().build().perform();
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();

		while (window.hasNext()) {
			driver.switchTo().window(window.next());
			System.out.println(driver.getTitle());
		}
	}

	public void dynamicAssignment(String value) {

		WebDriver driver = CreateBrowser();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com");

		WebElement practice = driver.findElement(By.xpath("//a[text()='Practice']"));
		practice.click();

		String checkBox = "//label[@for='" + value + "']";
		WebElement checkboxSelect = driver.findElement(By.xpath(checkBox));
		if (!checkboxSelect.isSelected()) {
			checkboxSelect.click();
		}
		System.out.println(checkboxSelect.getText());

		String option = checkboxSelect.getText();

		WebElement dropDown = driver.findElement(By.xpath("//Select"));

		Select dd = new Select(dropDown);
		dd.selectByVisibleText(option);

		WebElement switchToAlert = driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']"));
		switchToAlert.sendKeys(option);

		WebElement alert = driver.findElement(By.xpath("//input[@value='Alert']"));
		alert.click();

	}

	public void tablesAssignment() {

		WebDriver driver = CreateBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

		List<WebElement> rows = driver.findElements(By.xpath("(//table[@id='product'])[1]//tr"));
		System.out.println("number of rows = " + rows.size());

		List<WebElement> colums = driver.findElements(By.xpath("(//table[@id='product'])[1]//tr[1]/th"));
		System.out.println("number of colums = " + colums.size());

		List<WebElement> thirdColum = driver.findElements(By.xpath("(//table[@id='product'])[1]//tr[3]"));
		for (WebElement row : thirdColum) {
			System.out.println(row.getText());
		}

	}

	public void autoCompleteDropdownAssignment() {

//		TODO

		WebDriver driver = CreateBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		WebElement selectCountries = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));
		selectCountries.sendKeys("aus");

//		List<WebElement> countrySuggeestions = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
	}

}
