package com.arun.arun_training;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionOne {

	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saith\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.fb.com");
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("12454");
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}
}
