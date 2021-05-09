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
import org.testng.Assert;

public class Orderusingwait {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Orderusingwait o = new Orderusingwait();
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
		Actions actions = new Actions(driver);

		WebElement dismiss = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2doB4z']")));
		actions.moveToElement(dismiss).click().build().perform();

		WebElement search = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@title='Search for products, brands and more']")));
		actions.sendKeys(search, searchText).build().perform();

		String selectItemXpath = "//li[@class='Y5N33s']/div[contains(@data-tkid,'" + selectText + "')]";
		WebElement selectItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectItemXpath)));
		selectItem.click();

		WebElement minPrice = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_1YAKP4']/select")));
		minPrice.click();

		String minPriceSelectXpath = "//div[@class='_1YAKP4']//option[text()='₹" + j + "']";
		WebElement minPriceSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(minPriceSelectXpath)));
		minPriceSelect.click();

		WebElement maxPrice = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_3uDYxP']/select")));
		actions.moveToElement(maxPrice).click().build().perform();

		String maxPriceSelectXpath = "//div[@class='_3uDYxP']//option[text()='₹" + k + "']";
		WebElement maxPriceSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(maxPriceSelectXpath)));
		maxPriceSelect.click();

//		pricevalidation_tc2(driver, j, k);
//		ramValidation_tc3(driver, "3 GB", j, k);
		starRating_tc4(driver, "4★ & above", j, k);
//		fAssured_tc5(driver);
	}

	public void pricevalidation_tc2(WebDriver driver, int min, int max) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		String filterXpath = "//div[text()='₹" + min + "-₹" + max + "']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterXpath)));

		List<WebElement> priceElements = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'_30jeq3')]")));

		List<String> pricesString = new ArrayList<String>();
		for (WebElement priceElement : priceElements) {
			String price = priceElement.getText();
			pricesString.add(price);
		}
//		for (int i = 0; i < priceElements.size(); i++) {
//			String price = priceElements.get(i).getText();
//			pricesString.add(price);
//		}

		List<Integer> prices = new ArrayList<Integer>();
		for (String priceString : pricesString) {
			priceString = priceString.replace("₹", "").replace(",", "");
			prices.add(Integer.parseInt(priceString));
		}
//		for (int i = 0; i < pricesString.size(); i++) {
//			String p = pricesString.get(i);
//			p = p.replace("₹", "").replace(",", "");
//			prices.add(Integer.parseInt(p));
//		}

		for (Integer price : prices) {
			Assert.assertTrue(price >= min && price <= max);
			if (price >= min && price <= max) {
				System.out.println("Test pass");
			} else {
				System.out.println("Test Failed");
			}
		}
		quit(driver);

	}

	public void ramValidation_tc3(WebDriver driver, String selectText, int min, int max) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);

		String filterXpath = "//div[text()='₹" + min + "-₹" + max + "']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterXpath)));

		String ramXapth = "//label[@class='_2iDkf8 t0pPfW']/div[contains(text(),'" + selectText
				+ "')]/preceding-sibling::input";

		WebElement ramElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ramXapth)));

		if (!ramElement.isSelected()) {
			actions.moveToElement(ramElement).click().build().perform();
		}

		String filterXpath1 = "//div[@class='_3ztiZO']//div[contains(text(),'" + selectText + "')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterXpath1)));

		List<WebElement> rams = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(text(),'3 GB RAM')]")));

		for (WebElement ram : rams) {
			String name = ram.getText();

			if (name.contains("3 GB RAM")) {
				System.out.println("test pass");
			} else {
				System.out.println("test fail");
			}

		}

		quit(driver);

	}

	public void starRating_tc4(WebDriver driver, String text, int min, int max) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);

		String filterXpath = "//div[text()='₹" + min + "-₹" + max + "']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterXpath)));

		String starsXpath = "//label[@class='_2iDkf8 t0pPfW']/div[contains(text(),'" + text + "')]";
		WebElement stars = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(starsXpath)));

		if (!stars.isSelected()) {
			actions.moveToElement(stars).click().build().perform();
		}

		String filterXpath1 = "//div[@class='_3ztiZO']//div[contains(text(),'" + text + "')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterXpath1)));

		List<WebElement> ratingElements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='_1lRcqv']")));

		List<String> ratingsString = new ArrayList<String>();
		for (WebElement ratingElement : ratingElements) {
			String rating = ratingElement.getText();
			ratingsString.add(rating);
		}

//		for (int i = 0; i < ratingElements.size(); i++) {
//			String rating = ratingElements.get(i).getText();
//			ratingsString.add(rating);
//		}

		List<Double> ratings = new ArrayList<Double>();
		for (String ratingString : ratingsString) {
			ratings.add(Double.parseDouble(ratingString));
		}

//		for (int i = 0; i < ratingsString.size(); i++) {
//			String p = ratingsString.get(i);
//			ratings.add(Double.parseDouble(p));
//		}

		for (Double rating : ratings)
			if (rating > 4) {
				System.out.println("test pass");
			} else {
				System.out.println("test fail");
			}

		quit(driver);

	}

	public void fAssured_tc5(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);

		WebElement fAssured = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='_24_Dny _3tCU7L']/preceding-sibling::input")));

		if (!fAssured.isSelected()) {
			WebElement fAssured1 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_24_Dny _3tCU7L']")));
			actions.moveToElement(fAssured1).click().build().perform();
		}

		String filterXpath = "//div[@class='_3ztiZO']//div[contains(text(),'Flipkart Assured')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterXpath)));

		List<WebElement> fAssuredImages = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='_13J9qT']/img")));

		for (WebElement fAssuredImage : fAssuredImages) {
			System.out.println(fAssuredImage.isDisplayed());
		}

		quit(driver);
	}

}
