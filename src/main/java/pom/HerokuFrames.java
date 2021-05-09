package pom;

import org.openqa.selenium.WebDriver;

public class HerokuFrames extends WebPage {

	private String nestedFramesXpath = "//a[text()='Nested Frames']";
	private String topFrameXpath = "//frame[@name='frame-top']";
	private String middleFrameXpath = "//frame[@name='frame-middle']";
	private String middleFrameTextXpath = "//div[text()='MIDDLE']";

	public HerokuFrames(WebDriver driver) {
		super(driver);
	}

	public void clickOnNestedFrames() {
		super.click(nestedFramesXpath);
	}

	public void switchToTopFrame() {
		super.switchFrame(topFrameXpath);
	}

	public void switchToMiddleFrame() {
		super.switchFrame(middleFrameXpath);
	}

	public String getTextInMiddleFrame() {
		return super.getText(middleFrameTextXpath);
	}

}
