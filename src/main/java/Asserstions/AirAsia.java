package Asserstions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class AirAsia {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		AirAsia aa = new AirAsia();
		aa.flightBooking_tc1("One Way", "Hyderabad", "GOA", 30);

	}

	public WebDriver CreateDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.navigate().to("https://www.airasia.co.in/content/air-asia/en/home");
		return driver;
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void flightBooking_tc1(String triptype, String From, String To, int DepartureDate) {
		WebDriver driver = CreateDriver();
		try {

			Actions actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, 10);
	
			String tripType = "//div[@class='trip-option']/div[contains(text(),'" + triptype + "')]";
			WebElement tripTypeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tripType)));
			if (!tripTypeSelect.isSelected()) {
				tripTypeSelect.click();
			}
	
			WebElement from = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='setting'])[1]")));
			actions.moveToElement(from).sendKeys(from, "HYD").build().perform();
	
			String fromSuggestionXpath = "//div[@class='recent-list-items list-group']//div[contains(text(),'" + From
					+ "')]";
			WebElement fromSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fromSuggestionXpath)));
			actions.moveToElement(fromSuggestion).click().build().perform();
			actions.sendKeys("goa").build().perform();
	
			String toSuggestionXpath = "//div[@class='recent-list-items list-group']//div[contains(text(),'" + To + "')]";
			WebElement toSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(toSuggestionXpath)));
			actions.moveToElement(toSuggestion).click().build().perform();
	
			WebElement departureDate = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='date-picker-date-group']")));
			actions.moveToElement(departureDate).click().build().perform();
	
			String departureDateXpath = "(//div[@data-day-index='" + DepartureDate + "'])[2]";
			WebElement departureDateSelect = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(departureDateXpath)));
			actions.moveToElement(departureDateSelect).click().build().perform();
	
			WebElement back = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Back']")));
			actions.moveToElement(back).click().build().perform();
	
			WebElement passenger = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='show-passengers']")));
			actions.moveToElement(passenger).click().build().perform();
	
			WebElement adults = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@alt='plus'])[1]")));
			actions.moveToElement(adults).click().build().perform();
	
			WebElement done = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Done']")));
			actions.moveToElement(done).click().build().perform();
	
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='select']")));
			actions.moveToElement(search).click().build().perform();
	
			WebElement flights = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flight-detail-panel-info']")));
	
			Assert.assertEquals("HYD\r\n" + "GOI\r\n" + "30 Apr\r\n" + "Friday\r\n" + "Standard\r\n" + "Lowest Fare\r\n"
					+ "Premium Flex\r\n" + "Free seat, Meals ..", flights.getText());
		}catch(NoSuchElementException e) {
			
		}finally {
			driver.quit();
		}
		

	}
	
	
	public double divi(int a, int b) throws ArithmeticException{
		if(b == 0) {
			throw new ArithmeticException("Den should not be zero");
		}
		return a/b;
	}
	

}
