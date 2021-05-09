package Asserstions;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Goibibo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Goibibo g = new Goibibo();
		g.flightBooking_tc1();

	}

	public WebDriver CreateDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.goibibo.com");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement confirmHomePage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[text()='Domestic and International Flights']")));
		Assert.assertTrue(
				confirmHomePage.isDisplayed());
		return driver;
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void flightBooking_tc1() {
		WebDriver driver = CreateDriver();
		Map<String, String> flightDetails = new Hashtable<String, String>();
		flightDetails.put("tripType", "Round trip");
		flightDetails.put("from", "Delhi");
		flightDetails.put("destination", "Mumbai");
		flightDetails.put("departureDate", "Apr 12");
		flightDetails.put("returnDate", "Apr 20");
		WebDriverWait wait = new WebDriverWait(driver, 10);

		String tripTypeXpath = "//div[@class='fltSwitchOpt dIF alignItemsCenter ico15']/span[contains(text(),'"
				+ flightDetails.get("tripType") + "')]";
		WebElement tripType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tripTypeXpath)));
		tripType.click();

		WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
		from.sendKeys("Del");

		String fromSuggestionXpath = "//ul/li/div/div[2]/div[1]/span[1][contains(text(),'" + flightDetails.get("from")
				+ "')]";
		WebElement fromSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fromSuggestionXpath)));
		fromSuggestion.click();
		Assert.assertTrue(from.isDisplayed());

		WebElement destination = driver.findElement(By.xpath("//input[@placeholder='Destination']"));
		destination.sendKeys("Mum");

		String destinationSuggestionXpath = "//ul/li/div/div[2]/div[1]/span[1][contains(text(),'"
				+ flightDetails.get("destination") + "')]";
		WebElement destinationSuggestion = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(destinationSuggestionXpath)));
		destinationSuggestion.click();
		Assert.assertTrue(destination.isDisplayed());

		String departureDateXpath = "//div[@aria-label='Mon " + flightDetails.get("departureDate") + " 2021']";
		WebElement departureDate = driver.findElement(By.xpath(departureDateXpath));
		departureDate.click();
		WebElement departureDateCheck = driver.findElement(By.xpath("//input[@placeholder='Departure']"));
		Assert.assertTrue(departureDateCheck.isDisplayed());

		String returndateXpath = "//div[@aria-label='Tue " + flightDetails.get("returnDate") + " 2021']";
		WebElement returnDate = driver.findElement(By.xpath(returndateXpath));
		returnDate.click();
		WebElement returnDateCheck = driver.findElement(By.xpath("//input[@placeholder='Return']"));
		Assert.assertTrue(returnDateCheck.isDisplayed());

		WebElement travellersAndClass = driver.findElement(By.xpath("//span[@id='pax_label']"));
		travellersAndClass.click();

		WebElement Adults = driver.findElement(By.xpath("//button[@id='adultPaxPlus']"));
		Adults.click();

		WebElement travellClass = driver.findElement(By.xpath("//select[@id='gi_class']"));
		travellClass.click();

		WebElement travellClassSelect = driver.findElement(By.xpath("//select/option[contains(text(),'Business')]"));
		travellClassSelect.click();

		WebElement closeTravellersAndCLass = driver.findElement(By.xpath("//a[@id='pax_close']"));
		closeTravellersAndCLass.click();

		WebElement search = driver.findElement(By.xpath("//button[@value='Search']"));
		search.click();
		List<WebElement> flightsList = driver
				.findElements(By.xpath("//div[@class='fltHpyRsltCard flexCol whiteBg marginT10 brdrRd5']"));
		Assert.assertTrue(flightsList.size() > 0);

		quit(driver);
	}

}
