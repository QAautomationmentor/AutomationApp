package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Base;

public class Test3 extends Base {
	public WebDriver driver;

	@Test
	public void facelookLogin() {
		driver = initializeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("Test3 Title : " + driver.getTitle());
		driver.close();
	}
}
