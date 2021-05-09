package Asserstions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Makemytrip {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Makemytrip mmt = new Makemytrip();
		mmt.flightBooking_tc1("Round Trip", "Hyderabad, India", "Delhi, India", 12, 14, 2, "Business");
	}

	public WebDriver CreateDriver() {
		WebDriver driver = new ChromeDriver();
		Assert.assertEquals("Open ChromeBrowser", "Open ChromeBrowser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.navigate().to("https://www.makemytrip.com");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Make My Trip']")));
		WebElement productOffering = driver.findElement(By.xpath("//span[text()='Product Offering']"));
		Assert.assertTrue(productOffering.isDisplayed());
		return driver;
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void flightBooking_tc1(String triptype, String From, String To, int DepartureDate, int ReturnDate,
			int Adults, String TravelClass) {
		WebDriver driver = CreateDriver();

		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement dismiss = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chFlights active']")));
		actions.moveToElement(dismiss).click().build().perform();

		String tripType = "//ul[@class='fswTabs latoBlack greyText']/li[contains(text(),'" + triptype + "')]";
		WebElement tripTypeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tripType)));
		//tripType is not a Checkbox, hence isSelected should not be used
		if (!tripTypeSelect.isSelected()) {
			tripTypeSelect.click();
		}

		WebElement fromLabel = driver.findElement(By.xpath("//label[@for='fromCity']"));
		actions.moveToElement(fromLabel).click().build().perform();

		WebElement from = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From']")));
		actions.moveToElement(from).sendKeys(from, "HYD").build().perform();
		
		Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed());

		//Add expected result as a comment
		String fromSuggestionXpath = "//ul[@role='listbox']/li/div/div//p[contains(text(),'" + From + "')]";
		WebElement fromSuggestion = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fromSuggestionXpath)));
		actions.moveToElement(fromSuggestion).click().build().perform();

		WebElement toLabel = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='toCity']")));
		actions.moveToElement(toLabel).click().build().perform();

		WebElement to = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='To']")));
		actions.moveToElement(to).sendKeys(to, "DEL").build().perform();

		String toSuggestionXpath = "//ul[@role='listbox']/li/div/div//p[contains(text(),'" + To + "')]";
		WebElement toSuggestion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(toSuggestionXpath)));
		actions.moveToElement(toSuggestion).click().build().perform();

		String departureDateXpath = "(//div[@class='dateInnerCell']/p[contains(text(),'" + DepartureDate + "')])[2]";
		WebElement departureDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(departureDateXpath)));
		actions.moveToElement(departureDate).click().build().perform();

		String returnDateXpath = "(//div[@class='dateInnerCell']/p[contains(text(),'" + ReturnDate + "')])[2]";
		WebElement returnDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(returnDateXpath)));
		actions.moveToElement(returnDate).click().build().perform();

		WebElement travellersLabel = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='travellers']")));
		actions.moveToElement(travellersLabel).click().build().perform();

		String adultsXpath = "//li[@data-cy='adults-" + Adults + "']";
		WebElement adults = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(adultsXpath)));
		actions.moveToElement(adults).click().build().perform();

		String travelClassXpath = "//li[contains(text(),'" + TravelClass + "')]";
		WebElement travelClass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(travelClassXpath)));
		actions.moveToElement(travelClass).click().build().perform();

		WebElement apply = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-cy='travellerApplyBtn']")));
		actions.moveToElement(apply).click().build().perform();

		WebElement search = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")));
		actions.moveToElement(search).click().build().perform();

		WebElement journyType = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Non Stop']")));
		actions.moveToElement(journyType).click().build().perform();

//		List<WebElement> flightslist = wait.until(
//				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='listingCardWrap']")));
//		for (WebElement flights : flightslist) {
//			System.out.println(flights.getText());}

		WebElement text = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[@class='font24 blackFont whiteText appendBottom20']")));
//		System.out.println(text.getText()); 

		Assert.assertEquals("Flights from Hyderabad to New Delhi, and back", text.getText());
	}

}
