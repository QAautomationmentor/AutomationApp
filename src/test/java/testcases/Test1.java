package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilities.Base;

public class Test1 extends Base{
	public WebDriver driver;
	@Test
	public void academtLogin() {
		driver=initializeDriver();
		driver.get("https://www.rahulshettyacademy.com/");
		System.out.println("Test1 Title : "+driver.getTitle());
		driver.close();
	}
}
