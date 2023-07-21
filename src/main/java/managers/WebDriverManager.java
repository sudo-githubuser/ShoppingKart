package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;

public class WebDriverManager {
	
	private WebDriver driver;
	private static DriverType driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	public WebDriverManager(){driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();}
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}
	private WebDriver createDriver() {
		switch(driverType) {
		case FIREFOX: driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			break;
		case INTERNETEXPLORER: driver = new InternetExplorerDriver();
			break;
		}
		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
		return driver;
	}
	public void closeDriver() {driver.close();}
	public void quitDriver() {driver.quit();}
}
