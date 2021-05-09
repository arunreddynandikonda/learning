package test.annotations.demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassA {

	@BeforeSuite
	public void beforeSuiteInClassA() {
		System.out.println("Before Suite From Class A");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test From Class A");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class From Class A");
	}
	
	@BeforeMethod
	public void beforeMethodInClassA() {
		System.out.println("Before Method in Class A");
	}
	
	@Test
	public void methodAInClassA() {
		System.out.println("Method A in Class A");
	}
	
	@Test
	public void methodBInClassA() {
		System.out.println("Method B in Class A");
	}
	
	@AfterMethod
	public void afterMethodInClassA() {
		System.out.println("After Method in Class A");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class From Class A");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test From Class A");
	}
	
	@AfterSuite
	public void afterSuiteInClassA() {
		System.out.println("After Suite From Class A");
	}
}
