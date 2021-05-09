package pom;

import org.openqa.selenium.WebDriver;

public class FlipkartProductsPage extends WebPage {

	private String resultsTextXpath = "//div[@class='_1YokD2 _2GoDe3 col-12-12']/div/div/span";
	private String minimumPriceXpath = "//div[@class='_1YAKP4']/select[@class='_2YxCDZ']";
	private String maximumPriceXpath = "//div[@class='_3uDYxP']/select[@class='_2YxCDZ']";
	private String flipkartAssuredXpath = "//div[@class='_24_Dny _3tCU7L']";
	private String flipkartAssuredFilterXpath = "//div[text()='Flipkart Assured']";

	private String ramXpath(String value) {
		return "//div[@title='" + value + "']";
	}

	private String starRatingXpath(String value) {
		return "//div[@title='" + value + "★ & above']";
	}

	public FlipkartProductsPage(WebDriver driver) {
		super(driver);
	}

	public String searchResult() {
		String text = super.visibleWait(resultsTextXpath).getText();
		return text;
	}

	public void enterMiniumPrice(String value) {
		super.selectByValueFromDropDown(minimumPriceXpath, value);
	}

	public void enterMaximumPrice(String value) {
		super.selectByValueFromDropDown(maximumPriceXpath, value);
	}

	public void enterStarRating(String text) {
		super.visibleWait(flipkartAssuredFilterXpath);
		super.select(this.starRatingXpath(text));
	}

	public void checkFlipkartAssuredCheckbox() {
		super.visibleWait(flipkartAssuredXpath);
		super.select(flipkartAssuredXpath);
	}

	public void enterMinimumPriceAndMaximumprice(String minPrice, String maxPrice) {
		enterMiniumPrice(minPrice);
		enterMaximumPrice(maxPrice);
	}

	public void enterTheRamSize(String value) {
		super.select(this.ramXpath(value));
	}

}
