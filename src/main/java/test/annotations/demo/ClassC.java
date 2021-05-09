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

public class ClassC {

	@BeforeSuite 
	public void beforeSuiteInClassC() {
		System.out.println("Before Suite From Class C");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test From Class C");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class From Class C");
	}

	@BeforeMethod
	public void beforeMethodInClassC() {
		System.out.println("Before Method in Class C");
	}

	@Test
	public void methodAInClassC() {
		System.out.println("Method A in Class C");
	}

	@Test
	public void methodBInClassC() {
		System.out.println("Method B in Class C");
	}
	
	@Test
	public void methodCInClassC() {
		System.out.println("Method C in Class C");
	}

	@Test
	public void methodDInClassC() {
		System.out.println("Method D in Class C"); 
	}

	@AfterMethod
	public void afterMethodInClassC() {
		System.out.println("After Method in Class C");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class From Class C");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test From Class C");
	}

	@AfterSuite
	public void afterSuiteInClassC() {
		System.out.println("After Suite From Class C");
	}

}
