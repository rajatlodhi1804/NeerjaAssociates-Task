package EPRSystem_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static String browser = "Chrome";
	public static WebDriver driver;

	@BeforeClass
	public void setUpEnv() {
		if (driver == null) {
			if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				System.out.println("Invalid Input: " + browser);
			}
			driver.get("https://epr-v3.cpcbeprplastic.in/#/plastic/home");
			driver.manage().window().maximize();
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
//			driver.quit();
//          driver = null;
		}
	}
}
