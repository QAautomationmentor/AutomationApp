package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilities.Base;

public class Test2 extends Base{
	public WebDriver driver;
	@Test
	public void googleTitleValidation() {
		driver=initializeDriver();
		driver.get("https://www.google.co.in");
		System.out.println("Test2 Title : "+driver.getTitle());
		driver.close();
	}
}
