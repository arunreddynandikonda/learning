package globalvariables;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValues {

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\saith\\arun\\arun-training\\src\\main\\java\\data.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("browser"));
		prop.setProperty("browser", "firefox");
		System.out.println(prop.getProperty("browser"));
		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\saith\\arun\\arun-training\\src\\main\\java\\data.properties");
		prop.store(fos, null);
		prop.setProperty("url", "https://www.facebook.com");
		System.out.println(prop.getProperty("url"));

	}

}
