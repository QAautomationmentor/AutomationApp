package utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("start-maximized");
		option.setAcceptInsecureCerts(true);
		// return new ChromeDriver(option);
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		return driver;
	}

	public static String captureScreenshot(String screenshotName, WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName + ".png");
		try {
			FileHandler.copy(src, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationFile.getAbsolutePath();
	}

}
