package managers;

import org.openqa.selenium.WebDriver;

import enums.DriverType;

public class WebDriverManager {
	
	private WebDriver driver;
	private static DriverType driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	public WebDriverManager() {
	}
}
