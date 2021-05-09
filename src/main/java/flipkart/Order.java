package flipkart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Order o = new Order();
		o.basic_tc1("mobiles", "mobiles under 15000", 7000, 13000);
	}

	public WebDriver CreateDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.navigate().to("https://www.flipkart.com");
		return driver;
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void basic_tc1(String searchText, String selectText, int j, int k) throws InterruptedException {
		WebDriver driver = CreateDriver();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement dismiss = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2doB4z']")));
		dismiss.click();

		Actions actions = new Actions(driver);
		WebElement search = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		actions.sendKeys(search, searchText).build().perform();

//		Thread.sleep(2000);
		String selectItemXpath = "//li[@class='Y5N33s']/div[contains(@data-tkid,'" + selectText + "')]";
		driver.findElement(By.xpath(selectItemXpath)).click();

//		Thread.sleep(2000);
		WebElement minPrice = driver.findElement(By.xpath("//div[@class='_1YAKP4']/select"));
		minPrice.click();

		String minPriceXpath = "//div[@class='_1YAKP4']//option[text()='₹" + j + "']";
		WebElement min = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(minPriceXpath)));
		min.click();

		Thread.sleep(2000);
		WebElement maxPrice = driver.findElement(By.xpath("//div[@class='_3uDYxP']/select"));
		maxPrice.click();
		Thread.sleep(2000);
		String maxPriceXpath = "//div[@class='_3uDYxP']//option[text()='₹" + k + "']";
		driver.findElement(By.xpath(maxPriceXpath)).click();
//		pricevalidation_tc2(driver, j, k);
//		ramValidation_tc3(driver, "3 GB");
//		starRating_tc4(driver, "3 GB", "4★ & above");
		fAssured_tc5(driver, "3 GB", "4★ & above");

	}

	public void pricevalidation_tc2(WebDriver driver, int min, int max) throws InterruptedException {

		Thread.sleep(2000);
		List<WebElement> priceElements = driver.findElements(By.xpath("//div[contains(@class,'_30jeq3')]"));

		List<String> pricesString = new ArrayList<String>();

		for (int i = 0; i < priceElements.size(); i++) {
			String price = priceElements.get(i).getText();
			pricesString.add(price); // inserting values into arraylist
		}

		List<Integer> prices = new ArrayList<Integer>();
		for (int i = 0; i < pricesString.size(); i++) {
			String p = pricesString.get(i);
			p = p.replace("₹", "").replace(",", "");
			prices.add(Integer.parseInt(p));
		}

		for (int i = 0; i < prices.size(); i++) {
			if (prices.get(i) >= min && prices.get(i) <= max) {
			} else {
				System.out.println("Test Failed");
			}
		}
		quit(driver);

	}

	public void ramValidation_tc3(WebDriver driver, String selectText) throws InterruptedException {

		Thread.sleep(3000);
		String ramXapth = "//label[@class='_2iDkf8 t0pPfW']//div[text()='" + selectText + "']/preceding-sibling::input";
		WebElement ramElement = driver.findElement(By.xpath(ramXapth));

		if (!ramElement.isSelected()) {
			ramElement.click();
		}

		Thread.sleep(3000);
		List<WebElement> ram = driver.findElements(By.xpath("//li[contains(text(),'3 GB RAM')]"));

		for (int i = 0; i < ram.size(); i++) {
			String name = ram.get(i).getText();

			if (name.contains("3 GB RAM")) {
				System.out.println("test pass");
			} else {
				System.out.println("test fail");
			}

		}

		quit(driver);

	}

	public void starRating_tc4(WebDriver driver, String selectText, String text) throws InterruptedException {
		Thread.sleep(3000);
		String ram = "//label[@class='_2iDkf8 t0pPfW']//div[text()='" + selectText + "']";
		driver.findElement(By.xpath(ram)).click();
		Thread.sleep(3000);

		String stars = "//label[@class='_2iDkf8 t0pPfW']/div[contains(text(),'" + text + "')]";
		driver.findElement(By.xpath(stars)).click();
		Thread.sleep(3000);

		List<WebElement> ratingElements = driver.findElements(By.xpath("//span[@class='_1lRcqv']"));

		List<String> ratingsString = new ArrayList<String>();

		for (int i = 0; i < ratingElements.size(); i++) {
			String rating = ratingElements.get(i).getText();
			ratingsString.add(rating);
		}

		List<Double> ratings = new ArrayList<Double>();
		for (int i = 0; i < ratingsString.size(); i++) {
			String p = ratingsString.get(i);
			ratings.add(Double.parseDouble(p));
		}

		for (int i = 0; i < ratings.size(); i++)
			if (ratings.get(i) > 4) {
				System.out.println("test pass");
			} else {
				System.out.println("test fail");
			}

		quit(driver);

	}

	public void fAssured_tc5(WebDriver driver, String selectText, String text) throws InterruptedException {
		String ramXapth = "//label[@class='_2iDkf8 t0pPfW']//div[text()='" + selectText + "']";
		WebElement ram = driver.findElement(By.xpath(ramXapth));
		Actions actions = new Actions(driver);
		actions.moveToElement(ram).click().build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		String starsXpath = "//label[@class='_2iDkf8 t0pPfW']/div[contains(text(),'" + text + "')]";
		WebElement stars = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(starsXpath)));
		stars.click();

		WebElement fAssured = driver.findElement(By.xpath("//div[@class='_24_Dny _3tCU7L']/preceding-sibling::input"));

		if (!fAssured.isSelected()) {
			WebElement fAssured1 = driver.findElement(By.xpath("//div[@class='_24_Dny _3tCU7L']"));
			actions.moveToElement(fAssured1).click().build().perform();
		}

		List<WebElement> fAssuredImage = driver.findElements(By.xpath("//div[@class='_13J9qT']/img"));

		for (int i = 0; i < fAssuredImage.size(); i++) {
			System.out.println(fAssuredImage.get(i).isDisplayed());
		}
		quit(driver);
	}

}
