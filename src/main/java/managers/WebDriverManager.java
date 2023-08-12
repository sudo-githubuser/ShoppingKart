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
			//System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
			/* Added the below lines of code for GitHub action execution */
			io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--headless");
			options.addArguments("--remote-allow-origins=*");

			options.addArguments("--window-size=1920,1080");
			options.addArguments("--disable-extensions");
			options.addArguments("--proxy-server='direct://'");
			options.addArguments("--proxy-bypass-list=*");
			//options.addArguments("--start-maximized");
			options.addArguments("--disable-gpu");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--no-first-run");
			options.addArguments("--no-default-browser-check");
			options.addArguments("--test-type");
			driver = new ChromeDriver(options);
			break;
		case INTERNETEXPLORER: driver = new InternetExplorerDriver();
			break;
		}
		//if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
		return driver;
	}
	public void closeDriver() {driver.close();}
	public void quitDriver() {driver.quit();}
}
