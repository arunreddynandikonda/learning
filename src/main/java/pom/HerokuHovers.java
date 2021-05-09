package pom;

import org.openqa.selenium.WebDriver;

public class HerokuHovers extends WebPage {

	private String image1Xpath = "(//div[@class='figure'])[1]";
	private String image2Xpath = "(//div[@class='figure'])[2]";
	private String image3Xpath = "(//div[@class='figure'])[3]";
	private String image1nameXpath = "(//div[@class='figcaption']/h5)[1]";
	private String image2nameXpath = "(//div[@class='figcaption']/h5)[2]";
	private String image3nameXpath = "(//div[@class='figcaption']/h5)[3]";

	public HerokuHovers(WebDriver driver) {
		super(driver);
	}

	public void mouseHoverOverImage1() {
		super.moveToElemnt(image1Xpath);
	}

	public String getImage1UserName() {
		return super.getText(image1nameXpath);
	}

	public void mouseHoverOverImage2() {
		super.moveToElemnt(image2Xpath);
	}

	public String getImage2UserName() {
		return super.getText(image2nameXpath);
	}

	public void mouseHoverOverImage3() {
		super.moveToElemnt(image3Xpath);
	}

	public String getImage3UserName() {
		return super.getText(image3nameXpath);
	}

}
