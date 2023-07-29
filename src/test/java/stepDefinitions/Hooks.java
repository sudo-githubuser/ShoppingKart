package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    TestContext testContext;
    public Hooks (TestContext context) { testContext = context; }
    @Before
    public void setUp(){
        //WebDriver Initialization
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            final byte[] screenShot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }
        testContext.getWebDriverManager().closeDriver();

    }
}
