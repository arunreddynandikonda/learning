package pom;

import org.openqa.selenium.WebDriver;

public class HerokuDisappearingElements extends WebPage {

	private String galleryXpath = "//a[text()='Gallery']";

	public HerokuDisappearingElements(WebDriver driver) {
		super(driver);
	}

	public void refresh() {
		super.refresh();
	}

	public boolean isGalleryPresent() {
		return super.isElementPresent(galleryXpath);
	}
}
