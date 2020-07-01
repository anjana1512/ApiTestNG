package com.testNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.Calculator;

public class TestNG_Assignment {
	Calculator calc = new Calculator();

	@BeforeMethod
	@BeforeClass
	public void setUp() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs once before class", true);
	}

	@AfterClass
	public void cleanUp() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs once after class", true);
	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs before every method", true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs after every method", true);
	}

	@Test(dataProvider = "testDataAddMul", priority = 0, groups = { "multiple", "add" })
	public void testAdd(int num1, int num2) {
		System.out.println(num1+" + "+num2+" is "+calc.add(num1, num2));
		Assert.assertEquals(3, calc.add(num1, num2));
		System.out.println("Add function from calculator class has been verified successfully");
	}

	@Test(dataProvider = "testData", priority = 1, groups = { "multiple" })
	public void testSubtract(int num1, int num2) {
		System.out.println(num1+" - "+num2+" is "+calc.sub(num1, num2));
		Assert.assertFalse(1 != calc.sub(num1, num2));
		System.out.println("Subtract function from calculator class has been verified successfully");
	}

	@Test(dataProvider = "testDataAddMul", priority = 2, groups = { "multiple" })
	public void testMultiply(int num1, int num2) {
		System.out.println(num1+" * "+num2+" is "+calc.mul(num1, num2));
		Assert.assertNotEquals(1, calc.mul(num1, num2));
		System.out.println("Mutiply function from calculator class has been verified successfully");
	}

	@Test(dataProvider = "testData", priority = 3, groups = { "multiple" })
	public void testDivide(int num1, int num2) {
		System.out.println(num1+" / "+num2+" is "+calc.divInt(num1, num2));
		Assert.assertTrue(2 == calc.divInt(num1, num2));
		System.out.println("Divide function from calculator class has been verified successfully");
	}

	@Test(priority = 5, groups = { "multiple" })
	public void testExponent() {
		System.out.println("2 ^ 2 is "+calc.exp(2, 2));
		Assert.assertEquals(4, calc.exp(2, 2));
		System.out.println("Exponent function from calculator class has been verified successfully");
	}

	@Parameters({ "single-integer" })
	@Test(groups = { "single" }, priority = 5)
	public void testInverse(int num) {
		System.out.println("1 / "+num+" is "+calc.inverse(num));
		Assert.assertEquals(0.5, calc.inverse(num));
		System.out.println("Inverse function from calculator class has been verified successfully");
	}

	@Parameters({ "single-integer" })
	@Test(groups = { "single" }, priority = 6)
	public void testNegate(int num) {
		System.out.println("-1 * "+num+" is "+calc.negate(num));
		Assert.assertEquals(-2, calc.negate(num));
		System.out.println("Negate function from calculator class has been verified successfully");
	}

	@Test(priority = 7, groups = { "multiple" })
	public void testMod() {
		System.out.println("6 / 4 is "+calc.mod(6, 4));
		Assert.assertEquals(2, calc.mod(6, 4));
		System.out.println("Modulus function from calculator class has been verified successfully");
	}

	@Test
	@DataProvider
	public Object[][] testDataAddMul() {
		return new Object[][] { new Object[] { 2, 1 },{ 3, 0 },{ 1, 2 }, };
	}

	@Test
	@DataProvider
	public Object[][] testData() {
		return new Object[][] { new Object[] { 2, 1 } };
	}
}
