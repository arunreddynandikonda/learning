package pom;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public String takeScreenshot(WebDriver driver, String testName) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		String targetLocation = "C:\\Users\\saith\\Desktop\\Screenshots\\" + testName + "" + date.getTime() + ".jpg";
		File dest = new File(targetLocation);
		FileUtils.copyFile(screenshotFile, dest);
		return targetLocation;
	}

}
