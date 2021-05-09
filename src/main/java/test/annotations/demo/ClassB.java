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

public class ClassB {

	@BeforeSuite
	public void beforeSuiteInClassB() {
		System.out.println("Before Suite From Class B");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test From Class B");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class From Class B");
	}

	@BeforeMethod
	public void beforeMethodInClassB() {
		System.out.println("Before Method in Class B");
	}

	@Test
	public void methodAInClassB() {
		System.out.println("Method A in Class B");
	}

	@Test
	public void methodBInClassB() {
		System.out.println("Method B in Class B");
	}

	@AfterMethod
	public void afterMethodInClassB() {
		System.out.println("After Method in Class B");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class From Class B");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test From Class B");
	}

	@AfterSuite
	public void afterSuiteInClassB() {
		System.out.println("After Suite From Class B");
	}
}
