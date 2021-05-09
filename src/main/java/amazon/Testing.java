package amazon;

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

public class Testing {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		Testing t = new Testing();
		t.basic_tc1("laptops", "laptops under 50000", "30000", "100000");
	}

	public WebDriver CreateDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.navigate().to("https://www.amazon.in");
		return driver;
	}

	public void quit(WebDriver driver) {
		driver.quit();
	}

	public void basic_tc1(String searchText, String selectText, String min, String max) {
		WebDriver driver = CreateDriver();
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement searchbox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search']")));
		actions.sendKeys(searchbox, searchText).build().perform();

		String selectItemXpath = "//div[contains(@data-keyword,'" + selectText + "')]";
		WebElement selectItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectItemXpath)));
		selectItem.click();

		String minPriceXpath = "//input[@placeholder='Min']";
		WebElement minPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(minPriceXpath)));
		actions.moveToElement(minPrice).sendKeys(minPrice, min).build().perform();

		String maxPriceXpath = "//input[@placeholder='Max']";
		WebElement maxPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(maxPriceXpath)));
		actions.sendKeys(maxPrice, max).build().perform();

		WebElement go = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='a-button-input']")));
		go.click();

		pricevalidation_tc2(driver, min, max);

	}

	public void pricevalidation_tc2(WebDriver driver, String min, String max) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		int mi = Integer.parseInt(min);
		int ma = Integer.parseInt(max);

		List<WebElement> priceElements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='a-price-whole']")));

		List<String> pricesString = new ArrayList<String>();

		for (WebElement priceElement : priceElements) {
//		for (int i = 0; i < priceElements.size(); i++) {
			String price = priceElement.getText();
			pricesString.add(price);
		}

//		List<Integer> prices = new ArrayList<Integer>();
//		for (int i = 0; i < pricesString.size(); i++) {
//			String p = pricesString.get(i);
//			p = p.replace(",", "");
//			prices.add(Integer.parseInt(p));
//		}

		List<Integer> prices = new ArrayList<Integer>();
		for (String priceString : pricesString) {
//			String p = priceString;
			priceString = priceString.replace(",", "");
			prices.add(Integer.parseInt(priceString));
		}

//		for (int i = 0; i < prices.size(); i++) {
		for (Integer price : prices) {
			if (price >= mi && price <= ma) {
				System.out.println("test pass");
			} else {
				System.out.println("test fail");
			}
		}
		quit(driver);
	}
}
